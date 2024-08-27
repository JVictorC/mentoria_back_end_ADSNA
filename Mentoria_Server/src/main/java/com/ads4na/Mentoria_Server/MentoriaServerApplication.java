package com.ads4na.Mentoria_Server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MentoriaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MentoriaServerApplication.class, args);
	}

}
