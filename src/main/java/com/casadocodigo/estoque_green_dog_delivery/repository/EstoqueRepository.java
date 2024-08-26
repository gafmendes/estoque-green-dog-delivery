package com.casadocodigo.estoque_green_dog_delivery.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casadocodigo.estoque_green_dog_delivery.domain.Estoque;

public interface EstoqueRepository extends MongoRepository<Estoque, String>{

}
