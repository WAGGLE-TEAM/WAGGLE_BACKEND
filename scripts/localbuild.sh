#!/bin/bash
source ../.env

git submodule update --remote --recursive --init
../gradlew clean build
docker-compose up -d --build
