#!/bin/sh

ORGANIZATION="phature.amaranth"
PROJECT="simple"
CATALOG="$1"
MODULE="$2"
VERSION="11.2020.12"

if test $CATALOG && test $MODULE
then
	mkdir $CATALOG/$PROJECT-$CATALOG-$MODULE/src/main/resources -p
	mkdir $CATALOG/$PROJECT-$CATALOG-$MODULE/src/main/java/$ORGANIZATION/$PROJECT/$CATALOG/$MODULE -p
	cat > $CATALOG/$PROJECT-$CATALOG-$MODULE/pom.xml << EOF
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>$ORGANIZATION</groupId>
        <artifactId>$PROJECT</artifactId>
        <version>$VERSION</version>
        <relativePath>../../pom.xml</relativePath>
    </parent>
    <artifactId>$PROJECT-$CATALOG-$MODULE</artifactId>

    <packaging>jar</packaging>
</project>
EOF
else
	echo "./initialize-catalog-module.sh CATALOG MODULE"
fi
