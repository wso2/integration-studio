#! /bin/bash
BASE_DIR=$(pwd)
PRODUCT_VERSION=$1
SERVER_PATH_ROOT=$BASE_DIR/resources/server

echo BASE_DIR: $BASE_DIR, PRODUCT_VERSION: $PRODUCT_VERSION and SERVER_PATH_ROOT: $SERVER_PATH_ROOT

# Micro Integrator configurations
DEPLOYMENT_FILE=deployment.toml
DEPLOYMENT_FILE_PATH=$SERVER_PATH_ROOT/$DEPLOYMENT_FILE

# Unzip micro esb to relevant packages
unzip $SERVER_PATH_ROOT/wso2mi-${PRODUCT_VERSION}.zip -d $SERVER_PATH_ROOT

# Cleanup
rm $SERVER_PATH_ROOT/wso2mi-$PRODUCT_VERSION.zip

# Rename as "microesb" (this is the static name used in EI Tooling code)
mv $SERVER_PATH_ROOT/wso2mi-$PRODUCT_VERSION $SERVER_PATH_ROOT/microesb

# Replace "deployment.toml" in Micro Integrator
cp -f $DEPLOYMENT_FILE_PATH $SERVER_PATH_ROOT/microesb/conf

# Zip the packages with microesb and JDK
cd $SERVER_PATH_ROOT
zip -r microesb.zip microesb/
rm -r microesb

echo Completed Micro Integrator Packaging
