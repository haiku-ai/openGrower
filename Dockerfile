
FROM openjdk:17

EXPOSE 8080

WORKDIR /applications

COPY target/*.jar /applications/openGrower.jar

ENTRYPOINT ["java","-jar", "openGrower.jar"]
