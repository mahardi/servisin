## Run with docker-compose
```
./mvnw clean install -P buildDocker
```

```
docker-compose up
```

# Remove unused Docker images after building
```
docker rmi $(docker images -f “dangling=true” -q)
```

## List of Endpoints
* API Gateway - http://localhost:8080
* Discovery Server - http://localhost:8761
* Config Server - http://localhost:8888
* Admin Server (Spring Boot Admin) - http://localhost:9090
* Tracing Server (Zipkin) - http://localhost:9411/zipkin/
* Prometheus - http://localhost:9091
* Grafana Dashboards - http://localhost:3000