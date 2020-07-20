#! /bin/bash
BASE_DIR=$(pwd)
PRODUCT_VERSION=$1
APACHE_MAVEN_VERSION=$2
APIM_CTL_VERSION=$3
PRODUCT_DIRECTORY=$4

echo BASE_DIR $BASE_DIR and PRODUCT_VERSION $PRODUCT_VERSION

# Product extraction locations
PRODUCT_PATH_ROOT=$BASE_DIR/target/products
PRODUCT_PATH_LINUX_64=$PRODUCT_PATH_ROOT/temp/linux-x86_64
PRODUCT_PATH_MACOS=$PRODUCT_PATH_ROOT/temp/macos
PRODUCT_PATH_WIN_64=$PRODUCT_PATH_ROOT/temp/win-x86_64/IntegrationStudio

PRODUCT_EXECUTABLE_NAME_DEFAULT=developerstudio
PRODUCT_EXECUTABLE_NAME=IntegrationStudio
PRODUCT_EXECUTABLE_CONFIG_FILE_NAME_DEFAULT=$PRODUCT_EXECUTABLE_NAME_DEFAULT.ini
PRODUCT_EXECUTABLE_CONFIG_FILE_NAME=$PRODUCT_EXECUTABLE_NAME.ini


# Temporary location of JDK distributions
JDK_DISTRIBUTION_PATH=$BASE_DIR/target/jdk
JDK_DEFAULT_DIRECTORY_NAME="jdk-home"
JDK_DISTRIBUTION_FILE_PREFIX="OpenJDK"
JDK_DIRECTORY_PREFIX="jdk8u"
JDK_HOME_LINUX="$JDK_DEFAULT_DIRECTORY_NAME/bin"
JDK_HOME_WINDOWS="$JDK_DEFAULT_DIRECTORY_NAME/bin"
JDK_HOME_MACOS="..\/Eclipse/$JDK_DEFAULT_DIRECTORY_NAME/Contents/Home/bin"
JDK_DISTRIBUTION_NAME="jdk-distibution"
MACOS_ECLIPSE_CONFIG_PATH="$PRODUCT_PATH_MACOS/DeveloperStudio.app/Contents/Eclipse"
MACOS_ECLIPSE_PLIST_PATH="$PRODUCT_PATH_MACOS/DeveloperStudio.app/Contents"
MACOS_ECLIPSE_EXECUTABLE_PATH="$PRODUCT_PATH_MACOS/DeveloperStudio.app/Contents/MacOS"
MACOS_JDK_LIB_PATH="$PRODUCT_PATH_MACOS/DeveloperStudio.app/Contents/Eclipse/$JDK_DEFAULT_DIRECTORY_NAME/Contents/Home/jre/lib"

JDK_DISTRIBUTION_PATH_LINUX=$JDK_DISTRIBUTION_PATH/jdk-linux
JDK_DISTRIBUTION_PATH_WINDOWS=$JDK_DISTRIBUTION_PATH/jdk-windows
JDK_DISTRIBUTION_PATH_MACOS=$JDK_DISTRIBUTION_PATH/jdk-macos

# Location of apictl distributions
APICTL_DISTRIBUTION_PATH=$BASE_DIR/target/apictl
APICTL_DISTRIBUTION_PATH_LINUX_64=$APICTL_DISTRIBUTION_PATH/apictl-linux-x64
APICTL_DISTRIBUTION_PATH_WINDOWS_64=$APICTL_DISTRIBUTION_PATH/apictl-windows-x64
APICTL_DISTRIBUTION_PATH_MACOSX_64=$APICTL_DISTRIBUTION_PATH/apictl-macosx-x64

# Micro Integrator configurations 
DEPLOYMENT_FILE=deployment.toml
DEPLOYMENT_FILE_PATH=resources/$DEPLOYMENT_FILE

# Create temp directory and unzip created packages
mkdir -p $PRODUCT_PATH_LINUX_64
mkdir -p $PRODUCT_PATH_MACOS
mkdir -p $PRODUCT_PATH_WIN_64

unzip $PRODUCT_PATH_ROOT/WSO2-Integration-Studio-linux.gtk.x86_64.zip -d $PRODUCT_PATH_LINUX_64
unzip $PRODUCT_PATH_ROOT/WSO2-Integration-Studio-macosx.cocoa.x86_64.zip -d $PRODUCT_PATH_MACOS
unzip $PRODUCT_PATH_ROOT/WSO2-Integration-Studio-win32.win32.x86_64.zip -d $PRODUCT_PATH_WIN_64

# Unzip micro esb to relevant packages
unzip $PRODUCT_PATH_ROOT/wso2mi-${PRODUCT_VERSION}.zip -d $PRODUCT_PATH_LINUX_64/runtime
unzip $PRODUCT_PATH_ROOT/wso2mi-${PRODUCT_VERSION}.zip -d $PRODUCT_PATH_MACOS/DeveloperStudio.app/Contents/Eclipse/runtime
unzip $PRODUCT_PATH_ROOT/wso2mi-${PRODUCT_VERSION}.zip -d $PRODUCT_PATH_WIN_64/runtime

# Rename as "microesb" (this is the static name used in EI Tooling code)
mv $PRODUCT_PATH_LINUX_64/runtime/wso2mi-$PRODUCT_DIRECTORY $PRODUCT_PATH_LINUX_64/runtime/microesb
mv $PRODUCT_PATH_MACOS/DeveloperStudio.app/Contents/Eclipse/runtime/wso2mi-$PRODUCT_DIRECTORY $PRODUCT_PATH_MACOS/DeveloperStudio.app/Contents/Eclipse/runtime/microesb
mv $PRODUCT_PATH_WIN_64/runtime/wso2mi-$PRODUCT_DIRECTORY $PRODUCT_PATH_WIN_64/runtime/microesb

# Unzip mi-monitoring-dashboard to relevant packages
unzip $PRODUCT_PATH_ROOT/wso2mi-monitoring-dashboard-${PRODUCT_VERSION}.zip -d $PRODUCT_PATH_LINUX_64/
unzip $PRODUCT_PATH_ROOT/wso2mi-monitoring-dashboard-${PRODUCT_VERSION}.zip -d $PRODUCT_PATH_MACOS/DeveloperStudio.app/Contents/Eclipse/
unzip $PRODUCT_PATH_ROOT/wso2mi-monitoring-dashboard-${PRODUCT_VERSION}.zip -d $PRODUCT_PATH_WIN_64/

# Rename as "mi-monitoring-dashboard" (this is the static name used in EI Tooling code)
mv $PRODUCT_PATH_LINUX_64/wso2mi-monitoring-dashboard-$PRODUCT_DIRECTORY $PRODUCT_PATH_LINUX_64/mi-monitoring-dashboard
mv $PRODUCT_PATH_MACOS/DeveloperStudio.app/Contents/Eclipse/wso2mi-monitoring-dashboard-$PRODUCT_DIRECTORY $PRODUCT_PATH_MACOS/DeveloperStudio.app/Contents/Eclipse/mi-monitoring-dashboard
mv $PRODUCT_PATH_WIN_64/wso2mi-monitoring-dashboard-$PRODUCT_DIRECTORY $PRODUCT_PATH_WIN_64/mi-monitoring-dashboard

# Change default configuration to http in mi-moniroting-dashboard
sed -i 's/transportId: "https"/transportId: "http"/g' $PRODUCT_PATH_LINUX_64/mi-monitoring-dashboard/conf/server/deployment.yaml
sed -i 's/transportId: "https"/transportId: "http"/g' $PRODUCT_PATH_MACOS/DeveloperStudio.app/Contents/Eclipse/mi-monitoring-dashboard/conf/server/deployment.yaml
sed -i 's/transportId: "https"/transportId: "http"/g' $PRODUCT_PATH_WIN_64/mi-monitoring-dashboard/conf/server/deployment.yaml

# Unzip apche maven to relevant packages
unzip $PRODUCT_PATH_ROOT/apache-maven-${APACHE_MAVEN_VERSION}-bin.zip -d $PRODUCT_PATH_LINUX_64/
unzip $PRODUCT_PATH_ROOT/apache-maven-${APACHE_MAVEN_VERSION}-bin.zip -d $PRODUCT_PATH_MACOS/DeveloperStudio.app/Contents/Eclipse/
unzip $PRODUCT_PATH_ROOT/apache-maven-${APACHE_MAVEN_VERSION}-bin.zip -d $PRODUCT_PATH_WIN_64/

# Rename as "apche-maven" (this is the static name used in EI Tooling code)
mv $PRODUCT_PATH_LINUX_64/apache-maven-$APACHE_MAVEN_VERSION $PRODUCT_PATH_LINUX_64/apache-maven
mv $PRODUCT_PATH_MACOS/DeveloperStudio.app/Contents/Eclipse/apache-maven-${APACHE_MAVEN_VERSION} $PRODUCT_PATH_MACOS/DeveloperStudio.app/Contents/Eclipse/apache-maven
mv $PRODUCT_PATH_WIN_64/apache-maven-${APACHE_MAVEN_VERSION} $PRODUCT_PATH_WIN_64/apache-maven

# Replace "deployment.toml" in Micro Integrator
cp -f $DEPLOYMENT_FILE_PATH $PRODUCT_PATH_LINUX_64/runtime/microesb/conf
cp -f $DEPLOYMENT_FILE_PATH $PRODUCT_PATH_MACOS/DeveloperStudio.app/Contents/Eclipse/runtime/microesb/conf
cp -f $DEPLOYMENT_FILE_PATH $PRODUCT_PATH_WIN_64/runtime/microesb/conf

# Clean up existing packages
rm -rf $PRODUCT_PATH_ROOT/WSO2-Integration-Studio-linux.gtk.x86_64.tar.gz
rm -rf $PRODUCT_PATH_ROOT/WSO2-Integration-Studio-win32.win32.x86_64.zip
rm -rf $PRODUCT_PATH_ROOT/WSO2-Integration-Studio-macosx.cocoa.x86_64.tar.gz

# Extract api-ctl to relevant packages
pushd ${APICTL_DISTRIBUTION_PATH_LINUX_64}
tar xzf apictl-$APIM_CTL_VERSION-linux-x64.tar.gz -C $PRODUCT_PATH_LINUX_64
popd

pushd ${APICTL_DISTRIBUTION_PATH_WINDOWS_64}
unzip apictl-$APIM_CTL_VERSION-windows-x64.zip -d $PRODUCT_PATH_WIN_64
popd

pushd ${APICTL_DISTRIBUTION_PATH_MACOSX_64}
tar xzf apictl-$APIM_CTL_VERSION-macosx-x64.tar.gz -C $PRODUCT_PATH_MACOS/DeveloperStudio.app/Contents/Eclipse
popd

# Extract JDK distributions
pushd ${JDK_DISTRIBUTION_PATH_LINUX}
mv $JDK_DISTRIBUTION_FILE_PREFIX* $JDK_DISTRIBUTION_NAME.tar.gz
tar xzf $JDK_DISTRIBUTION_NAME.tar.gz -C $PRODUCT_PATH_LINUX_64
popd

pushd ${JDK_DISTRIBUTION_PATH_WINDOWS}
mv $JDK_DISTRIBUTION_FILE_PREFIX* $JDK_DISTRIBUTION_NAME.zip
unzip $JDK_DISTRIBUTION_NAME.zip -d $PRODUCT_PATH_WIN_64
popd

pushd ${JDK_DISTRIBUTION_PATH_MACOS}
mv $JDK_DISTRIBUTION_FILE_PREFIX* $JDK_DISTRIBUTION_NAME.tar.gz
tar xzf $JDK_DISTRIBUTION_NAME.tar.gz -C $PRODUCT_PATH_MACOS/DeveloperStudio.app/Contents/Eclipse
popd

# Configure JDKs
pushd ${PRODUCT_PATH_LINUX_64}
mv $JDK_DIRECTORY_PREFIX* $JDK_DEFAULT_DIRECTORY_NAME
sed -e '/-vmargs/i\'$'\n''-vm' developerstudio.ini > developerstudio_temp.ini
sed -e '/-vmargs/i\'$'\n'$JDK_HOME_LINUX developerstudio_temp.ini > developerstudio.ini
rm -f developerstudio_temp.ini
popd

pushd ${PRODUCT_PATH_WIN_64}
mv $JDK_DIRECTORY_PREFIX* $JDK_DEFAULT_DIRECTORY_NAME
sed -e '/-vmargs/i\'$'\n''-vm' developerstudio.ini > developerstudio_temp.ini
sed -e '/-vmargs/i\'$'\n'$JDK_HOME_WINDOWS developerstudio_temp.ini > developerstudio.ini
rm -f developerstudio_temp.ini
popd

pushd ${MACOS_ECLIPSE_CONFIG_PATH}
mv $JDK_DIRECTORY_PREFIX* $JDK_DEFAULT_DIRECTORY_NAME
sed -e '/-vmargs/i\'$'\n''-vm' developerstudio.ini > developerstudio_temp.ini
sed -e '/-vmargs/i\'$'\n'$JDK_HOME_MACOS developerstudio_temp.ini > developerstudio.ini
rm -f developerstudio_temp.ini
popd

# pushd ${MACOS_JDK_LIB_PATH}
# cp libfreetype.dylib.6 libfreetype.6.dylib
# popd

# Rename distribution executables and configuration files
pushd ${PRODUCT_PATH_LINUX_64}
mv $PRODUCT_EXECUTABLE_NAME_DEFAULT $PRODUCT_EXECUTABLE_NAME
mv $PRODUCT_EXECUTABLE_CONFIG_FILE_NAME_DEFAULT $PRODUCT_EXECUTABLE_CONFIG_FILE_NAME
popd

pushd ${MACOS_ECLIPSE_EXECUTABLE_PATH}
mv $PRODUCT_EXECUTABLE_NAME_DEFAULT $PRODUCT_EXECUTABLE_NAME
popd

pushd ${MACOS_ECLIPSE_CONFIG_PATH}
mv $PRODUCT_EXECUTABLE_CONFIG_FILE_NAME_DEFAULT $PRODUCT_EXECUTABLE_CONFIG_FILE_NAME
popd

pushd ${PRODUCT_PATH_WIN_64}
mv $PRODUCT_EXECUTABLE_NAME_DEFAULT.exe $PRODUCT_EXECUTABLE_NAME.exe
mv $PRODUCT_EXECUTABLE_CONFIG_FILE_NAME_DEFAULT $PRODUCT_EXECUTABLE_CONFIG_FILE_NAME
popd

#Rename Info.plist for Mac issue 
#TODO: Need to fix this on RCP level
pushd ${MACOS_ECLIPSE_PLIST_PATH}
sed -e 's/developerstudio/IntegrationStudio/; s/Developerstudio/IntegrationStudio/; s/WSO2-Developer-Studio/WSO2-Integration-Studio/' Info.plist > Info_temp.plist
rm Info.plist
mv Info_temp.plist Info.plist
popd

# Zip the packages with microesb and JDK
pushd ${PRODUCT_PATH_LINUX_64}
cd ../
rm -rf IntegrationStudio
mv linux-x86_64 IntegrationStudio
tar -czf WSO2-Integration-Studio-linux.gtk.x86_64.tar.gz IntegrationStudio
mv WSO2-Integration-Studio-linux.gtk.x86_64.tar.gz $PRODUCT_PATH_ROOT/WSO2-Integration-Studio-linux.gtk.x86_64.tar.gz
popd

pushd ${PRODUCT_PATH_MACOS}
mv DeveloperStudio.app IntegrationStudio.app
tar -czf WSO2-Integration-Studio-macosx.cocoa.x86_64.tar.gz *
mv WSO2-Integration-Studio-macosx.cocoa.x86_64.tar.gz $PRODUCT_PATH_ROOT/WSO2-Integration-Studio-macosx.cocoa.x86_64.tar.gz
popd

pushd ${PRODUCT_PATH_WIN_64}
cd ../
zip -r $PRODUCT_PATH_ROOT/WSO2-Integration-Studio-win32.win32.x86_64.zip *
popd

# Cleanup
rm $PRODUCT_PATH_ROOT/wso2mi-$PRODUCT_VERSION.zip
rm $PRODUCT_PATH_ROOT/wso2mi-monitoring-dashboard-$PRODUCT_VERSION.zip
rm $PRODUCT_PATH_ROOT/apache-maven-${APACHE_MAVEN_VERSION}-bin.zip
rm -rf $APICTL_DISTRIBUTION_PATH
rm -rf $PRODUCT_PATH_ROOT/temp
rm -rf $PRODUCT_PATH_ROOT/IntegrationStudio
rm -rf $JDK_DISTRIBUTION_PATH

rm -rf $PRODUCT_PATH_ROOT/WSO2-Integration-Studio-linux.gtk.x86_64.zip
rm -rf $PRODUCT_PATH_ROOT/WSO2-Integration-Studio-macosx.cocoa.x86_64.zip
