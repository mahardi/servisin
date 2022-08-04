package io.mahardi.springservisinvisitsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringServisinVisitsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringServisinVisitsServiceApplication.class, args);
	}

}
