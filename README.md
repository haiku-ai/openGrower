# opengrower
Spring Boot REST API to facilitate storing sensor data in a persistent data store


## getting started

docker network create -d bridge opengrower 

docker run -d --name mongo -p 27017:27017 --network opengrower -e MONGO_INITDB_ROOT_USERNAME=mongoAdmin -e MONGO_INITDB_ROOT_PASSWORD=mongoAdmin123 -e MONGO_INITDB_DATABASE=mongo mongo

docker run --name opengrower -p 8080:8080 --network opengrower ghcr.io/haiku-ai/opengrower

docker run -d --name grafana -p 3000:3000 grafana/grafana

docker run -p 4019:4019 -p 4018:4018 --network opengrower \
  -e CB_SECRET=admin123 \
  -e CB_API_HOST=0.0.0.0 \
  -e CB_API_PORT=4019 \
  -e CB_DB_HOST=mongo \
  -e CB_DB_NAME=mongo \
  -e CB_DB_USERNAME=mongoAdmin \
  -e CB_DB_PASSWORD=mongoAdmin123 \
  -e REACT_APP_CLIENT_HOST=http://localhost:4018 \
  -e REACT_APP_API_HOST=http://localhost:4019 \
  razvanilin/chartbrew
