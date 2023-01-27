
FROM openjdk:8-jdk-alpine
COPY target/*.jar openGrower.jar
ENTRYPOINT ["java","-jar", "openGrower.jar"]
