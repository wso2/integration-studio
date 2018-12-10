#! /bin/bash
BASE_DIR=$(pwd)
PRODUCT_VERSION=$1

echo BASE_DIR $BASE_DIR and PRODUCT_VERSION $PRODUCT_VERSION

PRODUCTS_PATH=$BASE_DIR/target/products/WSO2-Developer-Studio

#Generate micro esb profile. Input 6 into profile-creator tool
echo 6|$BASE_DIR/target/products/wso2ei-$PRODUCT_VERSION/bin/profile-creator.sh

#Create temp directory and unzip created packages
mkdir $BASE_DIR/target/products/temp
mkdir $BASE_DIR/target/products/temp/linux-x86
mkdir $BASE_DIR/target/products/temp/linux-x86_64
mkdir $BASE_DIR/target/products/temp/macos
mkdir $BASE_DIR/target/products/temp/win-x86
mkdir $BASE_DIR/target/products/temp/win-x86_64


unzip $BASE_DIR/target/products/WSO2-Developer-Studio-linux.gtk.x86.zip -d $BASE_DIR/target/products/temp/linux-x86
unzip $BASE_DIR/target/products/WSO2-Developer-Studio-linux.gtk.x86_64.zip -d $BASE_DIR/target/products/temp/linux-x86_64
unzip $BASE_DIR/target/products/WSO2-Developer-Studio-macosx.cocoa.x86_64.zip -d $BASE_DIR/target/products/temp/macos
unzip $BASE_DIR/target/products/WSO2-Developer-Studio-win32.win32.x86.zip -d $BASE_DIR/target/products/temp/win-x86
unzip $BASE_DIR/target/products/WSO2-Developer-Studio-win32.win32.x86_64.zip -d $BASE_DIR/target/products/temp/win-x86_64




#Unzip micro esb to relevant packages
unzip $BASE_DIR/target/products/wso2ei-${PRODUCT_VERSION}_micro-integrator.zip -d $BASE_DIR/target/products/temp/linux-x86/runtime
unzip $BASE_DIR/target/products/wso2ei-${PRODUCT_VERSION}_micro-integrator.zip -d $BASE_DIR/target/products/temp/linux-x86_64/runtime
unzip $BASE_DIR/target/products/wso2ei-${PRODUCT_VERSION}_micro-integrator.zip -d $BASE_DIR/target/products/temp/macos/DeveloperStudio.app/Contents/MacOS/runtime
unzip $BASE_DIR/target/products/wso2ei-${PRODUCT_VERSION}_micro-integrator.zip -d $BASE_DIR/target/products/temp/win-x86/runtime
unzip $BASE_DIR/target/products/wso2ei-${PRODUCT_VERSION}_micro-integrator.zip -d $BASE_DIR/target/products/temp/win-x86_64/runtime

#rename as "microesb" (this is the static name used in EI Tooling code)
mv $BASE_DIR/target/products/temp/linux-x86/runtime/wso2ei-$PRODUCT_VERSION $BASE_DIR/target/products/temp/linux-x86/runtime/microesb
mv $BASE_DIR/target/products/temp/linux-x86_64/runtime/wso2ei-$PRODUCT_VERSION $BASE_DIR/target/products/temp/linux-x86_64/runtime/microesb
mv $BASE_DIR/target/products/temp/macos/DeveloperStudio.app/Contents/MacOS/runtime/wso2ei-$PRODUCT_VERSION $BASE_DIR/target/products/temp/macos/DeveloperStudio.app/Contents/MacOS/runtime/microesb
mv $BASE_DIR/target/products/temp/win-x86/runtime/wso2ei-$PRODUCT_VERSION $BASE_DIR/target/products/temp/win-x86/runtime/microesb
mv $BASE_DIR/target/products/temp/win-x86_64/runtime/wso2ei-$PRODUCT_VERSION $BASE_DIR/target/products/temp/win-x86_64/runtime/microesb


#clean up existing packages
rm -rf $BASE_DIR/target/products/WSO2-Developer-Studio-linux.gtk.x86.zip
rm -rf $BASE_DIR/target/products/WSO2-Developer-Studio-linux.gtk.x86_64.zip
rm -rf $BASE_DIR/target/products/WSO2-Developer-Studio-win32.win32.x86.zip
rm -rf $BASE_DIR/target/products/WSO2-Developer-Studio-win32.win32.x86_64.zip
rm -rf $BASE_DIR/target/products/WSO2-Developer-Studio-macosx.cocoa.x86_64.zip


#Zip the packages with microesb

current_dir=$(pwd)

cd $BASE_DIR/target/products/temp/linux-x86
zip -r $BASE_DIR/target/products/WSO2-Developer-Studio-linux.gtk.x86.zip *
cd $BASE_DIR/target/products/temp/linux-x86_64
zip -r $BASE_DIR/target/products/WSO2-Developer-Studio-linux.gtk.x86_64.zip *
cd $BASE_DIR/target/products/temp/macos
zip -r $BASE_DIR/target/products/WSO2-Developer-Studio-macosx.cocoa.x86_64.zip *
cd $BASE_DIR/target/products/temp/win-x86
zip -r $BASE_DIR/target/products/WSO2-Developer-Studio-win32.win32.x86.zip *
cd $BASE_DIR/target/products/temp/win-x86_64
zip -r $BASE_DIR/target/products/WSO2-Developer-Studio-win32.win32.x86_64.zip *

cd $current_dir

#cleanup
rm -rf $BASE_DIR/target/products/wso2ei-$PRODUCT_VERSION
rm -rf $BASE_DIR/target/products/wso2ei-${PRODUCT_VERSION}_micro-integrator.zip
rm -rf $BASE_DIR/target/products/temp
