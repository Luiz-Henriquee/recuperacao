package com.prova.clientems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ClienteMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClienteMsApplication.class, args);
	}

}
