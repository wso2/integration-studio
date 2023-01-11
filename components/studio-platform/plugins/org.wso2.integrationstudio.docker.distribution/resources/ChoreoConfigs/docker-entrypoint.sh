#!/bin/sh
# ------------------------------------------------------------------------
# Copyright 2023 WSO2, LLC. (http://wso2.com)
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License
# ------------------------------------------------------------------------

set -e

# volume mount
config_volume=${WORKING_DIRECTORY}/wso2-config-volume

# check if the WSO2 non-root user home exists
test ! -d ${WORKING_DIRECTORY} && echo "WSO2 Docker non-root user home does not exist" && exit 1

# check if the WSO2 product home exists
test ! -d ${WSO2_SERVER_HOME} && echo "WSO2 Docker product home does not exist" && exit 1

# copy any configuration changes mounted to config_volume
test -d ${config_volume} && [[ "$(ls -A ${config_volume})" ]] && cp -RL ${config_volume}/* ${WSO2_SERVER_HOME}/

# mkdir /tmp/wso2mi

# mv ${WSO2_SERVER_HOME} /tmp/wso2mi

# export WSO2_SERVER_HOME=/tmp/wso2mi/wso2mi-4.1.0

mkdir -p /tmp/registry/config
mkdir -p /tmp/registry/governance
mkdir -p /tmp/registry/local

cp -r ${WSO2_SERVER_HOME}/wso2/components/micro-integrator-default/configuration /tmp/configuration

# start WSO2 server
sh ${WSO2_SERVER_HOME}/bin/micro-integrator.sh "$@"
