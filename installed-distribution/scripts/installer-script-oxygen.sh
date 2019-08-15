#! /bin/bash

PRODUCT_VERSION=7.0.0

wget http://product-dist.wso2.com/p2/developer-studio-kernel/eclipse/oxygen3a/eclipse-jee-oxygen-3a-linux-gtk-x86_64.tar.gz
wget http://product-dist.wso2.com/p2/developer-studio-kernel/eclipse/oxygen3a/eclipse-jee-oxygen-3a-linux-gtk.tar.gz
wget http://product-dist.wso2.com/p2/developer-studio-kernel/eclipse/oxygen3a/eclipse-jee-oxygen-3a-macosx-cocoa-x86_64.tar.gz
wget http://product-dist.wso2.com/p2/developer-studio-kernel/eclipse/oxygen3a/eclipse-jee-oxygen-3a-win32-x86_64.zip
wget http://product-dist.wso2.com/p2/developer-studio-kernel/eclipse/oxygen3a/eclipse-jee-oxygen-3a-win32.zip
wget http://product-dist.wso2.com/tools/developerstudio/wso2ei-7.0.0.zip

mvn install:install-file \
  -DgroupId=org.eclipse \
  -DartifactId=eclipse-jee-oxygen-3a-linux-gtk-x86_64 \
  -Dpackaging=tar.gz \
  -Dversion=4.7.3a \
  -Dfile=eclipse-jee-oxygen-3a-linux-gtk-x86_64.tar.gz \
  -DgeneratePom=true\
  -DlocalRepositoryPath=$1
mvn install:install-file \
  -DgroupId=org.eclipse \
  -DartifactId=eclipse-jee-oxygen-3a-linux-gtk \
  -Dpackaging=tar.gz \
  -Dversion=4.7.3a \
  -Dfile=eclipse-jee-oxygen-3a-linux-gtk.tar.gz \
  -DgeneratePom=true\
  -DlocalRepositoryPath=$1
mvn install:install-file \
  -DgroupId=org.eclipse \
  -DartifactId=eclipse-jee-oxygen-3a-macosx-cocoa-x86_64 \
  -Dpackaging=tar.gz \
  -Dversion=4.7.3a \
  -Dfile=eclipse-jee-oxygen-3a-macosx-cocoa-x86_64.tar.gz \
  -DgeneratePom=true\
  -DlocalRepositoryPath=$1
mvn install:install-file \
  -DgroupId=org.eclipse \
  -DartifactId=eclipse-jee-oxygen-3a-win64-x86_64 \
  -Dpackaging=zip \
  -Dversion=4.7.3a \
  -Dfile=eclipse-jee-oxygen-3a-win32-x86_64.zip \
  -DgeneratePom=true\
  -DlocalRepositoryPath=$1
mvn install:install-file \
  -DgroupId=org.eclipse \
  -DartifactId=eclipse-jee-oxygen-3a-win32 \
  -Dpackaging=zip \
  -Dversion=4.7.3a \
  -Dfile=eclipse-jee-oxygen-3a-win32.zip \
  -DgeneratePom=true\
  -DlocalRepositoryPath=$1  
  
#generate micro integrator profile
unzip wso2ei-$PRODUCT_VERSION.zip
#input 6 into profile-creator tool
echo 6|./wso2ei-$PRODUCT_VERSION/bin/profile-creator.sh

mvn install:install-file \
  -DgroupId=org.wso2 \
  -DartifactId=micro-integrator \
  -Dpackaging=zip \
  -Dversion=$PRODUCT_VERSION \
  -Dfile=wso2ei-${PRODUCT_VERSION}_micro-integrator.zip \
  -DgeneratePom=true\
  -DlocalRepositoryPath=$1

rm -rf wso2ei-$PRODUCT_VERSION
rm -rf wso2ei-${PRODUCT_VERSION}_micro-integrator.zip

