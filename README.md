## Run with docker-compose
```
./mvnw clean install -P buildDocker
```

```
docker-compose up
```

## Run services with MySQL as Database
```
docker run -e MYSQL_ROOT_PASSWORD=carworkshop -e MYSQL_DATABASE=carworkshop -p 3306:3306 mysql:5.7.8
```

To use a MySQL database, you have to start all the microservice with the `mysql` Spring profile. Add the `--spring.profiles.active=mysql` as an argument.

By default, at startup, database schema will be created and data will be populated.
You may also manually create the database and data by executing the `"db/mysql/{schema,data}.sql"` scripts of each 3 microservices. 
In the `application.yml` of the [Configuration repository], set the `initialization-mode` to `never`.

If you are running the microservices with Docker, you have to add the `mysql` profile into the (Dockerfile)[docker/Dockerfile]:
```
ENV SPRING_PROFILES_ACTIVE docker,mysql
```
In the `mysql section` of the `application.yml` from the [Configuration repository], you have to change 
the host and port of your MySQL JDBC connection string. 

## List of Endpoints
* API Gateway - http://localhost:8080
* Customers, Workshops and Visits Services - random port, check Eureka Dashboard 
* Discovery Server - http://localhost:8761
* Config Server - http://localhost:8888
* Admin Server (Spring Boot Admin) - http://localhost:9090
* Tracing Server (Zipkin) - http://localhost:9411/zipkin/
* Prometheus - http://localhost:9091
* Grafana Dashboards - http://localhost:3000