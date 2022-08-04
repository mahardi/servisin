package io.mahardi.springservisinworkshopsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import io.mahardi.springservisinworkshopsservice.config.WorkshopProperties;


@EnableDiscoveryClient
@SpringBootApplication
@EnableConfigurationProperties(WorkshopProperties.class)
public class SpringServisinWorkshopsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringServisinWorkshopsServiceApplication.class, args);
	}

}
