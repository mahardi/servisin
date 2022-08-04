package io.mahardi.springservisinconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringServisinConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringServisinConfigServerApplication.class, args);
	}

}
