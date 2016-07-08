####### IMPORTANT : You need to have 'axel' installed for this script to work.

# get args
VERSION=$1

# define variables
ROOT_URL="http://builder1.us1.wso2.org/~developerstudio/staging/developer-studio-kernel"
PACK_NAME_PREFIX="WSO2-Developer-Studio-kernel"

LINUX_32BIT_PACK_NAME=$PACK_NAME_PREFIX-linux-gtk-x86-$VERSION.zip
LINUX_64BIT_PACK_NAME=$PACK_NAME_PREFIX-linux-gtk-x86_64-$VERSION.zip
MAC_64BIT_PACK_NAME=$PACK_NAME_PREFIX-macosx-cocoa-x86_64-$VERSION.zip
WIN_32BIT_PACK_NAME=$PACK_NAME_PREFIX-win32-x86-$VERSION.zip
WIN_64BIT_PACK_NAME=$PACK_NAME_PREFIX-win32-x86_64-$VERSION.zip

# download packs

if [ -f $LINUX_32BIT_PACK_NAME ];
then
     echo "$LINUX_32BIT_PACK_NAME already exists. Skipping download."
else
   axel $ROOT_URL/$VERSION/products/$LINUX_32BIT_PACK_NAME
fi

if [ -f $LINUX_64BIT_PACK_NAME ];
then
     echo "$LINUX_64BIT_PACK_NAME already exists. Skipping download."
else
   axel $ROOT_URL/$VERSION/products/$LINUX_64BIT_PACK_NAME
fi

if [ -f $MAC_64BIT_PACK_NAME ];
then
     echo "$MAC_64BIT_PACK_NAME already exists. Skipping download."
else
   axel $ROOT_URL/$VERSION/products/$MAC_64BIT_PACK_NAME
fi

if [ -f $WIN_32BIT_PACK_NAME ];
then
     echo "$WIN_32BIT_PACK_NAME already exists. Skipping download."
else
   axel $ROOT_URL/$VERSION/products/$WIN_32BIT_PACK_NAME
fi

if [ -f $WIN_64BIT_PACK_NAME ];
then
     echo "$WIN_64BIT_PACK_NAME already exists. Skipping download."
else
   axel $ROOT_URL/$VERSION/products/$WIN_64BIT_PACK_NAME
fi


#install packs to local m2

mvn install:install-file \
  -DgroupId=org.wso2.developerstudio \
  -DartifactId=developer-studio-kernel-rcp-linux-gtk-x86_64 \
  -Dpackaging=zip\
  -Dversion=$VERSION \
  -Dfile=$LINUX_64BIT_PACK_NAME \
  -DgeneratePom=true


mvn install:install-file \
  -DgroupId=org.wso2.developerstudio \
  -DartifactId=developer-studio-kernel-rcp-linux-gtk-x86 \
  -Dpackaging=zip \
  -Dversion=$VERSION \
  -Dfile=$LINUX_32BIT_PACK_NAME \
  -DgeneratePom=true


mvn install:install-file \
  -DgroupId=org.wso2.developerstudio \
  -DartifactId=developer-studio-kernel-rcp-macosx-cocoa-x86_64 \
  -Dpackaging=zip \
  -Dversion=$VERSION \
  -Dfile=$MAC_64BIT_PACK_NAME\
  -DgeneratePom=true


mvn install:install-file \
  -DgroupId=org.wso2.developerstudio \
  -DartifactId=developer-studio-kernel-rcp-win64-x86_64 \
  -Dpackaging=zip \
  -Dversion=$VERSION \
  -Dfile=$WIN_64BIT_PACK_NAME\
  -DgeneratePom=true


mvn install:install-file \
  -DgroupId=org.wso2.developerstudio \
  -DartifactId=developer-studio-kernel-rcp-win32-x86 \
  -Dpackaging=zip \
  -Dversion=$VERSION \
  -Dfile=$WIN_32BIT_PACK_NAME \
  -DgeneratePom=true


