# opengrower
Spring Boot REST API to facilitate storing sensor data in a persistent data store


## getting started

docker network create -d bridge opengrower --subnet 172.0.0.0/16

docker run -d --name mongo --network opengrower -e MONGO_INITDB_ROOT_USERNAME=mongo -e MONGO_INITDB_ROOT_PASSWORD=mongo -e MONGO_INITDB_DATABASE=mongo mongo

docker run -d --name opengrower -p 8080:8080 --network opengrower ghcr.io/haiku-ai/opengrower



