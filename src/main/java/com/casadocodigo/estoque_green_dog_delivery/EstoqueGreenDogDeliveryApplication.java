package com.casadocodigo.estoque_green_dog_delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.mendes") 
@EnableReactiveMongoRepositories("com.mendes") 
@ComponentScan(basePackages = "com.mendes")
public class EstoqueGreenDogDeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstoqueGreenDogDeliveryApplication.class, args);
	}

}
