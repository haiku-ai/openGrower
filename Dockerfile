
FROM openjdk:17
COPY target/*.jar openGrower.jar
ENTRYPOINT ["java","-jar", "openGrower.jar"]
