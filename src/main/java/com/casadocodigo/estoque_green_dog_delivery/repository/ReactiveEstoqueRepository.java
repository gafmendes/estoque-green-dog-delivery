package com.casadocodigo.estoque_green_dog_delivery.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.casadocodigo.estoque_green_dog_delivery.domain.Estoque;

import reactor.core.publisher.Flux;

public interface ReactiveEstoqueRepository extends ReactiveCrudRepository<Estoque, String> {
	Flux<Estoque> findAll();
	
	Flux<Estoque> findTop10ByOrderByIdDesc();

}
