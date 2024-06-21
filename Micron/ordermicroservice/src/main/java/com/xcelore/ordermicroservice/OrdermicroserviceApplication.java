package com.xcelore.ordermicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.xcelore.ordermicroservice.controller")
public class OrdermicroserviceApplication {

	public static void main(String[] args) {

		SpringApplication.run(OrdermicroserviceApplication.class, args);
	}

}
