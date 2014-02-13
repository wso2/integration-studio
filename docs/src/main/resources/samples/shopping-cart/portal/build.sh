#!/bin/bash

mvn clean install -Dmaven.test.skip=true -o
set +e
rm -rf /home/sumedha/ext/servers/cloud-sample/apache-tomcat-6.0.20/webapps/zbay
set -e
set +e
rm /home/sumedha/ext/servers/cloud-sample/apache-tomcat-6.0.20/webapps/zbay.war
set -e
set +e
rm -rf /home/sumedha/ext/servers/cloud-sample/apache-tomcat-6.0.20/work/Catalina
set -e

cp target/zbay.war /home/sumedha/ext/servers/cloud-sample/apache-tomcat-6.0.20/webapps

