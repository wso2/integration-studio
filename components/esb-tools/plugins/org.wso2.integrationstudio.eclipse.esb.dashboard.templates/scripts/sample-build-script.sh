#! /bin/bash

set -e
cd scripts/
rm IS_SAMPLE.zip && rm -rf IS_SAMPLE/
for entry in ../NewSamples/*
do
  #skip files, docker sample and k8 sample
  if [ $entry = "../NewSamples/DefaultReadMe.html" ] || [ $entry = "../NewSamples/HelloDocker" ] || [ $entry = "../NewSamples/HelloKubernetes" ] || [ $entry = "../NewSamples/Resources" ]
  then
    continue
  fi
  #copy the IS_SAMPLE.zip into scripts directory and build the sample
  echo "1. Starting sample: $entry"
  cp "$entry"/IS_SAMPLE.zip . && unzip IS_SAMPLE.zip -d IS_SAMPLE && cd IS_SAMPLE && mvn clean install -Dmaven.test.skip=true
  BUILD_STATUS=$?
  echo "2. Build status of sample $entry: $BUILD_STATUS"
  #clean scripts directory for next iteration
  cd .. && rm IS_SAMPLE.zip && rm -rf IS_SAMPLE/
  echo "3. Delete status of sample $entry: $?"
  if [ $BUILD_STATUS != 0 ]
  then
    #exit if sample execution fails
    echo "Build Failed while executing the sample $entry"
    exit 1
  fi
done
