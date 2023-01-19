
FROM openjdk:17
COPY target/*.jar openGrower.jar
ARG MONGO_DB_URL
ARG MONGO_DB_USERNAME
ARG MONGO_DB_PASSWORD
ENTRYPOINT ["java","-jar", "openGrower.jar"]
