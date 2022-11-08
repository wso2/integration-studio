#!/bin/bash

# ----------------------------------------------------------------------------
#
# Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
#
# WSO2 Inc. licenses this file to you under the Apache License,
# Version 2.0 (the "License"); you may not use this file except
# in compliance with the License.
# You may obtain a copy of the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing,
# software distributed under the License is distributed on an
# "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
# KIND, either express or implied.  See the License for the
# specific language governing permissions and limitations
# under the License.
#
# ----------------------------------------------------------------------------

readonly WSO2_USERNAME=$1
readonly WSO2_PASSWORD=$2
BASE_DIR=$(pwd)
PRODUCT_VERSION=$3
SERVER_PATH_ROOT=$BASE_DIR/resources/server
echo BASE_DIR: $BASE_DIR, PRODUCT_VERSION: $PRODUCT_VERSION and SERVER_PATH_ROOT: $SERVER_PATH_ROOT

# Unzip micro integrator archive
echo "Unzipping wso2mi-$PRODUCT_VERSION Pack."
unzip $SERVER_PATH_ROOT/wso2mi-${PRODUCT_VERSION}.zip -d $SERVER_PATH_ROOT

# Cleanup
rm $SERVER_PATH_ROOT/wso2mi-$PRODUCT_VERSION.zip

# Rename as "microesb" (this is the static name used in EI Tooling code)
echo "Rename runtime distribution directory as microesb"
mv $SERVER_PATH_ROOT/wso2mi-$PRODUCT_VERSION $SERVER_PATH_ROOT/microesb

# Chek WSO2 Credentials
echo "Check WSO2 Credentials to proceed with update"

if [ -z $WSO2_USERNAME ] || [ -z $WSO2_PASSWORD ] || [[ "$WSO2_USERNAME" == '${WSO2_USERNAME}' ]] || [[ "$WSO2_PASSWORD" == '${WSO2_PASSWORD}' ]]; then
  echo "WSO2 Credentials are empty. Build proceeding with wso2mi-${PRODUCT_VERSION} vanilla pack."
  exit 0
fi

# Unzip wso2 updater scripts
echo "Unzipping wso2-update script archive"
unzip $SERVER_PATH_ROOT/update.zip -d $SERVER_PATH_ROOT

# Copy wso2-update scripts into Micro Integrator bin direcotry
echo "Copying wso2update_linux file"
cp -f $SERVER_PATH_ROOT/update/wso2update_linux $SERVER_PATH_ROOT/microesb/bin

# Cleanup update scripts
rm $SERVER_PATH_ROOT/update.zip
rm -r $SERVER_PATH_ROOT/update

# Run inplace update
cd $SERVER_PATH_ROOT/microesb/bin
chmod +x wso2update_linux
./wso2update_linux --username $WSO2_USERNAME --password $WSO2_PASSWORD
update_exit_code=$(echo $?)

if [ $update_exit_code -eq 2 ]; then
    echo "Self Update. Trying to run update tool again"
    ./wso2update_linux --username $WSO2_USERNAME --password $WSO2_PASSWORD
    update_exit_code=$(echo $?)
fi

# Chek the update status
if [ $update_exit_code -eq 0 ]; then
    echo "Successfully updated."
    exit 0
elif [ $update_exit_code -eq 1 ]; then
    echo "Default error."
elif [ $update_exit_code -eq 3 ]; then
    echo "Conflict(s) encountered."
elif [ $update_exit_code -eq 4 ]; then
    echo "Reverted."
else
    echo "Unkown exit code from update tool."
fi
exit 1
