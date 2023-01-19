
FROM openjdk:17
COPY target/*.jar openGrower.jar
ENTRYPOINT ["java","-jar", "openGrower.jar", "--spring.data.mongodb.host=$MONGO_DB_URL", "--spring.data.mongodb.username=$MONGO_DB_USERNAME", "--spring.data.mongodb.password=$MONGO_DB_PASSWORD"]
