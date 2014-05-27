define jboss::deployFile(
    $source,
    $baseDir,
    $version,
    $serverConf,
    $user,
    $group
    )
{
    $deployDir = "$baseDir/$version/standalone/deployments"
        file {
            $deployDir:
                ensure => directory;
            "$deployDir/$name":
                ensure => present,
                owner => $user,
                group => $group,
                source => $source,
            ;
    }

}
