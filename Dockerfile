FROM adoptopenjdk:11-jre-hotspot as builder
WORKDIR /backend
ARG JAR_FILE=build/libs/*-SNAPSHOT.jar
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract
FROM adoptopenjdk:11-jre-hotspot
WORKDIR application
COPY --from=builder backend/dependencies/ ./
RUN true
COPY --from=builder backend/spring-boot-loader/ ./
RUN true
COPY --from=builder backend/snapshot-dependencies/ ./
RUN true
COPY --from=builder backend/application/ ./
RUN true
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
