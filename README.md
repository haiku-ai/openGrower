# opengrower
Spring Boot REST API to facilitate storing sensor data in a persistent data store


## getting started

docker run -d --name mongo -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME=... -e MONGO_INITDB_ROOT_PASSWORD=... -e MONGO_INITDB_DATABASE=mongo mongo

docker run -d --name opengrower -p 8080:8080 ghcr.io/haiku-ai/opengrower -e MONGO_DB_URL=... -e MONGO_DB_USERNAME=... -e MONGO_DB_PASSWORD=... 



