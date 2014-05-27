class jboss::install($baseDir,
                    $version,
                    $serverConf = "standard",
                    $bindAddress = "0.0.0.0",
                    $user = "jboss") {
    $installDir = "$baseDir/$version"
    $serverBaseDir = "$installDir/server/$serverConf"
    group {
        "${user}":
            ensure => present;
    }
    user {
        "${user}":
            ensure => present,
            gid => "${user}",
            require => Group["${user}"],
	    password => '$6$$UBsgLScCxSolynuqeLh1Q81Fo728qr4fiZ.Y4TqMxNUOyjvp5b5OsVqB88rHAs7nt592zSLFeHkpb6Z9rqXp90',
	    password_max_age => '99999',
            password_min_age => '0',
	    shell            => '/bin/bash',
 	    uid              => '1546',
    }
    file { ["/var","/var/lib","/var/lib/puppet","/var/lib/puppet/files"]:
        ensure => directory
    }
    file {
        "/var/lib/puppet/files/${version}.zip":
            ensure => present,
            source => "/vagrent/files/${version}.zip",
#		source => "/tmp/vagrant-puppet/modules-0/jboss/${version}.zip",
#            source => "puppet:///modules/jboss/${version}.zip",
            require => File["/var/lib/puppet/files"];
        "${baseDir}":
            ensure => directory;
    }

    exec {
        "unzip-jboss":
            command => "unzip -o /var/lib/puppet/files/${version}.zip -d ${baseDir}",
            creates => "${baseDir}/${version}",
            require => [File["/var/lib/puppet/files/${version}.zip"],
                        File["${baseDir}"],
                        Package["unzip"]];
    } -> File["${baseDir}/${version}"]
    
    file {
        "${baseDir}/${version}":
            owner => "${user}",
	    mode => 777,
            group => "${user}",
            recurse => true,
            require => [User["${user}"],
                        Exec["unzip-jboss"]];
    }
    file {
        "/etc/init.d/jboss":
            ensure => present,
            mode => 0755,
            content => template("jboss/jboss.sh.erb");
    }
    
   service {
	"jboss":
	ensure => running,
	enable => true,
	require => [File ["/etc/init.d/jboss"], File ["${baseDir}/${version}"],
		],
   }	
    
}
