package com.ads4na.Mentoria_GateWay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MentoriaGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MentoriaGateWayApplication.class, args);
	}

}
