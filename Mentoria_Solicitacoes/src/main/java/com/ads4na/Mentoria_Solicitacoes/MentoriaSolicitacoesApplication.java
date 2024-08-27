package com.ads4na.Mentoria_Solicitacoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MentoriaSolicitacoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MentoriaSolicitacoesApplication.class, args);
	}

}
