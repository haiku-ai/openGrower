# opengrower
Spring Boot REST API to facilitate storing sensor data in a persistent data store


## getting started

docker network create -d bridge opengrow --subnet=172.0.0.0/16

docker run -d --name mongo -p 27017:27017 --network opengrow --ip 172.0.0.100 -e MONGO_INITDB_ROOT_USERNAME=mongoAdmin -e MONGO_INITDB_ROOT_PASSWORD=mongoAdmin123 -e MONGO_INITDB_DATABASE=mongo mongo

docker run --name opengrower -p 8080:8080 --network opengrow --ip 172.0.0.101 ghcr.io/haiku-ai/opengrower
