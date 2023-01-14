# opengrower
Spring Boot REST API to facilitate storing sensor data in a persistent data store


## getting started

docker run -d --name mongo -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME=mongoAdmin -e MONGO_INITDB_ROOT_PASSWORD=mongoAdmin123 -e MONGO_INITDB_DATABASE=mongo mongo

docker run -d --name opengrower -p 8080:8080 ghcr.io/haiku-ai/opengrower

docker run -d --name grafana -p 3000:3000 ghcr.io/ajeje93/grafana-mongodb-docker:latest



