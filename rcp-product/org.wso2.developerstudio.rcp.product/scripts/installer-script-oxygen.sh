#! /bin/bash
BASE_DIR=$(pwd)
PRODUCT_VERSION=$1

echo BASE_DIR $BASE_DIR and PRODUCT_VERSION $PRODUCT_VERSION

# Product extraction locations
PRODUCT_PATH_ROOT=$BASE_DIR/target/products
PRODUCT_PATH_LINUX_86=$PRODUCT_PATH_ROOT/temp/linux-x86
PRODUCT_PATH_LINUX_64=$PRODUCT_PATH_ROOT/temp/linux-x86_64
PRODUCT_PATH_MACOS=$PRODUCT_PATH_ROOT/temp/macos
PRODUCT_PATH_WIN_86=$PRODUCT_PATH_ROOT/temp/win-x86
PRODUCT_PATH_WIN_64=$PRODUCT_PATH_ROOT/temp/win-x86_64

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
MACOS_JDK_LIB_PATH="$PRODUCT_PATH_MACOS/DeveloperStudio.app/Contents/Eclipse/$JDK_DEFAULT_DIRECTORY_NAME/Contents/Home/jre/lib"

JDK_DISTRIBUTION_PATH_LINUX=$JDK_DISTRIBUTION_PATH/jdk-linux
JDK_DISTRIBUTION_PATH_WINDOWS=$JDK_DISTRIBUTION_PATH/jdk-windows
JDK_DISTRIBUTION_PATH_MACOS=$JDK_DISTRIBUTION_PATH/jdk-macos

# Generate micro esb profile. Input 6 into profile-creator tool
echo 6|$PRODUCT_PATH_ROOT/wso2ei-$PRODUCT_VERSION/bin/profile-creator.sh

# Create temp directory and unzip created packages
mkdir $PRODUCT_PATH_ROOT/temp
mkdir $PRODUCT_PATH_LINUX_86
mkdir $PRODUCT_PATH_LINUX_64
mkdir $PRODUCT_PATH_MACOS
mkdir $PRODUCT_PATH_WIN_86
mkdir $PRODUCT_PATH_WIN_64

unzip $PRODUCT_PATH_ROOT/WSO2-Developer-Studio-linux.gtk.x86.zip -d $PRODUCT_PATH_LINUX_86
unzip $PRODUCT_PATH_ROOT/WSO2-Developer-Studio-linux.gtk.x86_64.zip -d $PRODUCT_PATH_LINUX_64
unzip $PRODUCT_PATH_ROOT/WSO2-Developer-Studio-macosx.cocoa.x86_64.zip -d $PRODUCT_PATH_MACOS
unzip $PRODUCT_PATH_ROOT/WSO2-Developer-Studio-win32.win32.x86.zip -d $PRODUCT_PATH_WIN_86
unzip $PRODUCT_PATH_ROOT/WSO2-Developer-Studio-win32.win32.x86_64.zip -d $PRODUCT_PATH_WIN_64

# Unzip micro esb to relevant packages
unzip $PRODUCT_PATH_ROOT/wso2ei-${PRODUCT_VERSION}_micro-integrator.zip -d $PRODUCT_PATH_LINUX_86/runtime
unzip $PRODUCT_PATH_ROOT/wso2ei-${PRODUCT_VERSION}_micro-integrator.zip -d $PRODUCT_PATH_LINUX_64/runtime
unzip $PRODUCT_PATH_ROOT/wso2ei-${PRODUCT_VERSION}_micro-integrator.zip -d $PRODUCT_PATH_MACOS/DeveloperStudio.app/Contents/MacOS/runtime
unzip $PRODUCT_PATH_ROOT/wso2ei-${PRODUCT_VERSION}_micro-integrator.zip -d $PRODUCT_PATH_WIN_86/runtime
unzip $PRODUCT_PATH_ROOT/wso2ei-${PRODUCT_VERSION}_micro-integrator.zip -d $PRODUCT_PATH_WIN_64/runtime

# Rename as "microesb" (this is the static name used in EI Tooling code)
mv $PRODUCT_PATH_LINUX_86/runtime/wso2ei-$PRODUCT_VERSION $PRODUCT_PATH_LINUX_86/runtime/microesb
mv $PRODUCT_PATH_LINUX_64/runtime/wso2ei-$PRODUCT_VERSION $PRODUCT_PATH_LINUX_64/runtime/microesb
mv $PRODUCT_PATH_MACOS/DeveloperStudio.app/Contents/MacOS/runtime/wso2ei-$PRODUCT_VERSION $PRODUCT_PATH_MACOS/DeveloperStudio.app/Contents/MacOS/runtime/microesb
mv $PRODUCT_PATH_WIN_86/runtime/wso2ei-$PRODUCT_VERSION $PRODUCT_PATH_WIN_86/runtime/microesb
mv $PRODUCT_PATH_WIN_64/runtime/wso2ei-$PRODUCT_VERSION $PRODUCT_PATH_WIN_64/runtime/microesb

# Clean up existing packages
rm -rf $PRODUCT_PATH_ROOT/WSO2-Developer-Studio-linux.gtk.x86.tar.gz
rm -rf $PRODUCT_PATH_ROOT/WSO2-Developer-Studio-linux.gtk.x86_64.tar.gz
rm -rf $PRODUCT_PATH_ROOT/WSO2-Developer-Studio-win32.win32.x86.zip
rm -rf $PRODUCT_PATH_ROOT/WSO2-Developer-Studio-win32.win32.x86_64.zip
rm -rf $PRODUCT_PATH_ROOT/WSO2-Developer-Studio-macosx.cocoa.x86_64.tar.gz

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

pushd ${MACOS_JDK_LIB_PATH}
cp libfreetype.dylib.6 libfreetype.6.dylib
popd

# Zip the packages with microesb and JDK
pushd ${PRODUCT_PATH_LINUX_86}
tar -czf WSO2-Developer-Studio-linux.gtk.x86.tar.gz *
mv WSO2-Developer-Studio-linux.gtk.x86.tar.gz $PRODUCT_PATH_ROOT/WSO2-Developer-Studio-linux.gtk.x86.tar.gz
popd

pushd ${PRODUCT_PATH_LINUX_64}
tar -czf WSO2-Developer-Studio-linux.gtk.x86_64.tar.gz *
mv WSO2-Developer-Studio-linux.gtk.x86_64.tar.gz $PRODUCT_PATH_ROOT/WSO2-Developer-Studio-linux.gtk.x86_64.tar.gz
popd

pushd ${PRODUCT_PATH_MACOS}
tar -czf WSO2-Developer-Studio-macosx.cocoa.x86_64.tar.gz *
mv WSO2-Developer-Studio-macosx.cocoa.x86_64.tar.gz $PRODUCT_PATH_ROOT/WSO2-Developer-Studio-macosx.cocoa.x86_64.tar.gz
popd

pushd ${PRODUCT_PATH_WIN_86}
zip -r $PRODUCT_PATH_ROOT/WSO2-Developer-Studio-win32.win32.x86.zip *
popd

pushd ${PRODUCT_PATH_WIN_64}
zip -r $PRODUCT_PATH_ROOT/WSO2-Developer-Studio-win32.win32.x86_64.zip *
popd

# Cleanup
rm -rf $PRODUCT_PATH_ROOT/wso2ei-$PRODUCT_VERSION
rm -rf $PRODUCT_PATH_ROOT/wso2ei-${PRODUCT_VERSION}_micro-integrator.zip
rm -rf $PRODUCT_PATH_ROOT/temp
rm -rf $JDK_DISTRIBUTION_PATH

rm -rf $PRODUCT_PATH_ROOT/WSO2-Developer-Studio-linux.gtk.x86.zip
rm -rf $PRODUCT_PATH_ROOT/WSO2-Developer-Studio-linux.gtk.x86_64.zip
rm -rf $PRODUCT_PATH_ROOT/WSO2-Developer-Studio-macosx.cocoa.x86_64.zip
