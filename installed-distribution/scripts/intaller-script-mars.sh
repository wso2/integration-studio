wget http://product-dist.wso2.com/p2/developer-studio-kernel/eclipse/mars2/eclipse-jee-mars-2-linux-gtk-x86_64.tar.gz
wget http://product-dist.wso2.com/p2/developer-studio-kernel/eclipse/mars2/eclipse-jee-mars-2-linux-gtk.tar.gz
wget http://product-dist.wso2.com/p2/developer-studio-kernel/eclipse/mars2/eclipse-jee-mars-2-macosx-cocoa-x86_64.tar.gz
wget http://product-dist.wso2.com/p2/developer-studio-kernel/eclipse/mars2/eclipse-jee-mars-2-win32-x86_64.zip
wget http://product-dist.wso2.com/p2/developer-studio-kernel/eclipse/mars2/eclipse-jee-mars-2-win32.zip
mvn install:install-file \
  -DgroupId=org.eclipse \
  -DartifactId=eclipse-jee-mars-2-linux-gtk-x86_64 \
  -Dpackaging=tar.gz \
  -Dversion=4.5.2 \
  -Dfile=eclipse-jee-mars-2-linux-gtk-x86_64.tar.gz \
  -DgeneratePom=true
mvn install:install-file \
  -DgroupId=org.eclipse \
  -DartifactId=eclipse-jee-mars-2-linux-gtk \
  -Dpackaging=tar.gz \
  -Dversion=4.5.2 \
  -Dfile=eclipse-jee-mars-2-linux-gtk.tar.gz \
  -DgeneratePom=true
mvn install:install-file \
  -DgroupId=org.eclipse \
  -DartifactId=eclipse-jee-mars-2-macosx-cocoa-x86_64 \
  -Dpackaging=tar.gz \
  -Dversion=4.5.2 \
  -Dfile=eclipse-jee-mars-2-macosx-cocoa-x86_64.tar.gz \
  -DgeneratePom=true
mvn install:install-file \
  -DgroupId=org.eclipse \
  -DartifactId=eclipse-jee-mars-2-win64-x86_64 \
  -Dpackaging=zip \
  -Dversion=4.5.2 \
  -Dfile=eclipse-jee-mars-2-win32-x86_64.zip \
  -DgeneratePom=true
mvn install:install-file \
  -DgroupId=org.eclipse \
  -DartifactId=eclipse-jee-mars-2-win32 \
  -Dpackaging=zip \
  -Dversion=4.5.2 \
  -Dfile=eclipse-jee-mars-2-win32.zip \
  -DgeneratePom=true
