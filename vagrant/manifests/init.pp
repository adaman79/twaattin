group { "puppet":
     ensure => "present",
}
include java_jdk_7

node "jboss.cc.de" {
    include jboss
    Exec { path => [ "/bin/", "/sbin/" , "/usr/bin/", "/usr/sbin/" ] }
}

File { owner => 0, group => 0, mode => 0644 }

class java_jdk_7 {

  exec { "apt-get-update":
   	command => "/usr/bin/apt-get update",
    	refreshonly => true,
  }

  package { "openjdk-7-jdk":
	ensure => installed,
	require => Exec["apt-get-update"],
  }

}
