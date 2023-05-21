## How to run on Docker container

1. ./gradlew clean build
2. java -Djarmode=layertools -jar build/libs/trip_in_world-0.0.1-SNAPSHOT.jar extract
3. docker-compose build
    
    ```
    docker-compose up -d --build
    ```
    
- If you already build docker-compose, please follow this command
    
    ```
    docker-compose up
    ```
