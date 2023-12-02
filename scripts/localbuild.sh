#!/bin/bash
source ../.env

./gradlew clean build
cd waggle-api
java -Djarmode=layertools -jar build/libs/"${JAR_FILE_NAME}".jar extract
cd ..
docker-compose up -d --build
docker-compose up
