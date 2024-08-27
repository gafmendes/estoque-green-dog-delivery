package com.casadocodigo.estoque_green_dog_delivery.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoReactiveConfig extends AbstractReactiveMongoConfiguration{
	
	@Bean
	public MongoClient mongoReactiveCliente() {
		return MongoClients.create();
	}
	
	@Override
	protected String getDatabaseName() {
		return "test";
	}

}
