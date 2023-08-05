## How to run on Docker container

1. cd waggle-api
2.  ./gradlew clean build
3.  java -Djarmode=layertools -jar build/libs/${jar file name} extract
4. cd ..
5. docker-compose build

    ```java
     docker-compose up -d --build
    ```

    - If you already build docker-compose, please follow this command

        ```java
        docker-compose up
        ```

## Project structure

### waggle-common

- AOP
- 로깅 기능
- 공통 config, enum 클래스
- common response

### waggle-api

- controller
- service
- repository
- entity

### waggle-admin

- 관리자 페이지에 필요한 기능

### waggle-service

- batch scheduler 기능