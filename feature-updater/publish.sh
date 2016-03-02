 #!/bin/bash
echo "\nCreating 'Feature Update' for ESB Feature\n"
currentDirectory="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

#delete all expect this file (publish.sh)
rm -rf  $currentDirectory/newp2

echo Please provide the feature name of the feature that you are going to update=
read -p 'Feature Name : ' feature
#feature=org.wso2.developerstudio.eclipse.esb.feature
version=4.0.0
featureJar=$feature-$version-SNAPSHOT.jar
echo "featureJar = " $featureJar

#No need to set this(ECLIPSE_HOME) here as this need to be configured on the machine, commented below is an example only
#ECLIPSE_HOME=/home/susinda/eclipseIDEs/kernelTest/pureEclipse/eclipse/
echo "ECLIPSE_HOME = " $ECLIPSE_HOME
#TODO if ECLIPSE HOME is null terminate giving error message

#TODO add a check to see weather org.eclipse.equinox.launcher_*.jar is availabe, if not give a error message and terminate 
equinoxLauncherJar=plugins/org.eclipse.equinox.launcher_1.3.0.v20140415-2008.jar
echo "equinoxLauncher = " $equinoxLauncherJar
equinoxLauncherPath=$ECLIPSE_HOME$equinoxLauncherJar
echo "equinoxLauncherPath = " $equinoxLauncherPath

application=org.eclipse.equinox.p2.publisher.FeaturesAndBundlesPublisher
echo "application = " $application

echo "currentDirectory = " $currentDirectory
metadataRepository=file://$currentDirectory/newp2
echo "metadataRepository = " $metadataRepository

#here artifactRepository and metadataRepository are same but can change if wanted
artifactRepository=$metadataRepository
echo "artifactRepository = " $artifactRepository

#TODO need to create a directory called p2 and then a directory called features anf plugins
echo "Creating './p2/' directory, ./p2/features and ./p2/plugins directories"

#TODO need to copy updated feature into features directory
echo "Copying updated feature into features directory"

#TODO need to copy updated plugin jars into features directory
echo "Copying updated feature into plugins directory"

source=./p2/
echo "source = " $source


configs=gtk.linux.x86
echo "configs = " $configs

cmdArgs=" -compress -publishArtifacts"
echo "cmdArgs = " $cmdArgs

java -jar $equinoxLauncherPath -application $application -metadataRepository $metadataRepository  -artifactRepository $artifactRepository -source $source -configs $configs $cmdArgs

echo "\nSuccessfully Created 'Feature Update' for ESB Feature\n"
