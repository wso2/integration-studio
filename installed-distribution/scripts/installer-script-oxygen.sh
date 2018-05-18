wget 'http://product-dist.wso2.com/p2/developer-studio-kernel/eclipse/oxygen3a/eclipse-jee-oxygen-3a-linux-gtk-x86_64.tar.gz'
wget 'http://product-dist.wso2.com/p2/developer-studio-kernel/eclipse/oxygen3a/eclipse-jee-oxygen-3a-linux-gtk.tar.gz'
wget 'http://product-dist.wso2.com/p2/developer-studio-kernel/eclipse/oxygen3a/eclipse-jee-oxygen-3a-win32-x86_64.zip'
wget 'http://product-dist.wso2.com/p2/developer-studio-kernel/eclipse/oxygen3a/eclipse-jee-oxygen-3a-win32.zip'
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
