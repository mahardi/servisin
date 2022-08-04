## Run with docker-compose
```
./mvnw clean install -P buildDocker
```

```
docker-compose up
```

## Run services with MySQL as Database
```
docker run --name "servisin-mysql" -e MYSQL_ROOT_PASSWORD=test -e MYSQL_DATABASE=servisin -p 3306:3306 mysql:5.7.8
```

Add the `mysql` profile into the (Dockerfile)[docker/Dockerfile]:
```
ENV SPRING_PROFILES_ACTIVE docker,mysql
```

## List of Endpoints
* API Gateway - http://localhost:8080
* Customers, Workshops and Visits Services - random port, check Eureka Dashboard 
* Discovery Server - http://localhost:8761
* Config Server - http://localhost:8888
* Admin Server (Spring Boot Admin) - http://localhost:9090
* Tracing Server (Zipkin) - http://localhost:9411/zipkin/
* Prometheus - http://localhost:9091
* Grafana Dashboards - http://localhost:3000