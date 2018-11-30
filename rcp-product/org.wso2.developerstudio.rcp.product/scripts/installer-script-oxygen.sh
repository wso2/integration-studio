mvn install:install-file \
  -DgroupId=org.eclipse \
  -DartifactId=eclipse-jee-oxygen-3a-linux-gtk-x86_64 \
  -Dpackaging=zip \
  -Dversion=4.7.3a \
  -Dfile=target/products/WSO2-Developer-Studio-linux-gtk-x86_64.zip \
  -DgeneratePom=true\
  -DlocalRepositoryPath=$1
mvn install:install-file \
  -DgroupId=org.eclipse \
  -DartifactId=eclipse-jee-oxygen-3a-linux-gtk \
  -Dpackaging=zip \
  -Dversion=4.7.3a \
  -Dfile=target/products/WSO2-Developer-Studio-linux-gtk-x86.zip \
  -DgeneratePom=true\
  -DlocalRepositoryPath=$1
mvn install:install-file \
  -DgroupId=org.eclipse \
  -DartifactId=eclipse-jee-oxygen-3a-macosx-cocoa-x86_64 \
  -Dpackaging=zip \
  -Dversion=4.7.3a \
  -Dfile=target/products/WSO2-Developer-Studio-macosx-cocoa-x86_64.zip \
  -DgeneratePom=true\
  -DlocalRepositoryPath=$1
mvn install:install-file \
  -DgroupId=org.eclipse \
  -DartifactId=eclipse-jee-oxygen-3a-win64-x86_64 \
  -Dpackaging=zip \
  -Dversion=4.7.3a \
  -Dfile=target/products/WSO2-Developer-Studio-win32-x86_64.zip \
  -DgeneratePom=true\
  -DlocalRepositoryPath=$1
mvn install:install-file \
  -DgroupId=org.eclipse \
  -DartifactId=eclipse-jee-oxygen-3a-win32 \
  -Dpackaging=zip \
  -Dversion=4.7.3a \
  -Dfile=target/products/WSO2-Developer-Studio-win32-x86.zip \
  -DgeneratePom=true\
  -DlocalRepositoryPath=$1
