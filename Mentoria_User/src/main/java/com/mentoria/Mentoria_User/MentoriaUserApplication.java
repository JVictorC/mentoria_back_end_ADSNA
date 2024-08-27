package com.mentoria.Mentoria_User;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MentoriaUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MentoriaUserApplication.class, args);
	}

}
