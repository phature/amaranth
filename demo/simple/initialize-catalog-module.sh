#!/bin/sh

COMPANY="phature"
DEPARTMENT="amaranth"
PROJECT="simple"
CATALOG="$1"
MODULE="$2"
TAG="$3"
VERSION="11.2020.12"
ARTIFACT_ID=""

if test $CATALOG && test $MODULE
then
	if test $TAG
	then
		ARTIFACT_ID="$PROJECT-$CATALOG-$MODULE-$TAG"
		mkdir $CATALOG/$ARTIFACT_ID/src/main/java/$COMPANY/$DEPARTMENT/$PROJECT/$CATALOG/$MODULE/$TAG -p
	else
		ARTIFACT_ID="$PROJECT-$CATALOG-$MODULE"
		mkdir $CATALOG/$ARTIFACT_ID/src/main/java/$COMPANY/$DEPARTMENT/$PROJECT/$CATALOG/$MODULE -p
	fi
	mkdir $CATALOG/$ARTIFACT_ID/src/main/resources -p
	cat > $CATALOG/$ARTIFACT_ID/pom.xml << EOF
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>$COMPANY.$DEPARTMENT</groupId>
        <artifactId>$PROJECT</artifactId>
        <version>$VERSION</version>
        <relativePath>../../pom.xml</relativePath>
    </parent>
    <artifactId>$ARTIFACT_ID</artifactId>

    <packaging>jar</packaging>
</project>
EOF
else
	echo "./initialize-catalog-module.sh CATALOG MODULE"
fi
