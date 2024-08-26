package com.casadocodigo.estoque_green_dog_delivery.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casadocodigo.estoque_green_dog_delivery.domain.Estoque;
import com.casadocodigo.estoque_green_dog_delivery.repository.EstoqueRepository;

import io.swagger.v3.oas.annotations.Hidden;

@RestController
@RequestMapping("/api")
public class EstoqueController {
	
	private final Logger logger = LoggerFactory.getLogger(EstoqueController.class.getSimpleName());
	
	@Autowired
	@Qualifier("estoqueRepository")
	EstoqueRepository estoqueRepository;
	
	@Hidden
	@GetMapping("/lista")
	public List<Estoque> getTodoEstoque() {
		return estoqueRepository.findAll();
	}
	
	@PostMapping("/atualiza")
	public String atualiza(@RequestBody Estoque estoque) {
		logger.info("Recebido via REST: "+estoque);
		estoqueRepository.save(estoque);
		return "OK";
	}
	


}
