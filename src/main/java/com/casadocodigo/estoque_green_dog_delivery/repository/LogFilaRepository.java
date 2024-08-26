package com.casadocodigo.estoque_green_dog_delivery.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casadocodigo.estoque_green_dog_delivery.domain.LogFila;

public interface LogFilaRepository extends MongoRepository<LogFila, String>{

}
