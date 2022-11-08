#! /bin/bash

# ----------------------------------------------------------------------------
#
# Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

BASE_DIR=$(pwd)
SERVER_PATH_ROOT=$BASE_DIR/resources/server

# Micro Integrator configurations
DEPLOYMENT_FILE=deployment.toml
DEPLOYMENT_FILE_PATH=$SERVER_PATH_ROOT/$DEPLOYMENT_FILE

# Replace "deployment.toml" in Micro Integrator
echo "Copying updated deployment.toml file"
cp -f $DEPLOYMENT_FILE_PATH $SERVER_PATH_ROOT/microesb/conf

# Zip the packages with microesb and JDK
cd $SERVER_PATH_ROOT
zip -r microesb.zip microesb/
rm -r microesb

echo Completed Micro Integrator Packaging
