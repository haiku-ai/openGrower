
FROM openjdk:18
COPY target/*.jar openGrower.jar
ENTRYPOINT ["java","-jar", "openGrower.jar"]
