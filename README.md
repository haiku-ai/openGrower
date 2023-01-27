# opengrower
Spring Boot REST API to facilitate storing sensor data in a persistent data store


## getting started

docker run -d --name mongo -p 27017:27017 -v /mnt/ssd1/mongodb/data -e MONGO_INITDB_ROOT_USERNAME=mongoAdmin -e MONGO_INITDB_ROOT_PASSWORD=mongo123 -e MONGO_INITDB_DATABASE=mongo mongo:4.2.22

docker run -d --name opengrower -p 8080:8080 hcr.io/haiku-ai/opengrower



