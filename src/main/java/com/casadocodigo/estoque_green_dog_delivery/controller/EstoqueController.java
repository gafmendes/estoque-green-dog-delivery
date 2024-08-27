package com.casadocodigo.estoque_green_dog_delivery.controller;

import java.time.Duration;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.casadocodigo.estoque_green_dog_delivery.domain.Estoque;
import com.casadocodigo.estoque_green_dog_delivery.repository.EstoqueRepository;
import com.casadocodigo.estoque_green_dog_delivery.repository.ReactiveEstoqueRepository;

import io.swagger.v3.oas.annotations.Hidden;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class EstoqueController {
	
	private final Logger logger = LoggerFactory.getLogger(EstoqueController.class.getSimpleName());
	
	@Autowired
	@Qualifier("estoqueRepository")
	EstoqueRepository estoqueRepository;
	
	@Autowired 
	@Qualifier("reactiveEstoqueRepository")
	ReactiveEstoqueRepository reactiveEstoqueRepository;
	
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
	
	@Hidden
	@GetMapping("/")
	@ResponseBody
	public Mono<String> one(){
		return Mono.just("API");
	}
	
	@Hidden
	@GetMapping("/ultimos")
	@ResponseBody
	public Flux<Estoque> ultimos(){
		return reactiveEstoqueRepository.findTop10ByOrderByIdDesc();
	}
	
	@Hidden
	@GetMapping(value = "/lista-stream-com-pausa", produces = "text/event-stream")
	public Flux<Estoque> getListaEstoqueStreamComPausa(){
		return reactiveEstoqueRepository.findTop10ByOrderByIdDesc().delayElements(Duration.ofMillis(300));
	}
	
	@Hidden
	@GetMapping(value = "/lista-stream", produces = "application/stream+json")
	public Flux<Estoque> getListaEstoqueStream(){
		return reactiveEstoqueRepository.findAll();
	}
	
	@Hidden
	@PostMapping("/atualiza-reativo")
	public Mono<String> atualizaReativo(@RequestBody Estoque estoque){
		logger.info("Recebido via REST: " +estoque);
		estoqueRepository.save(estoque);
		return Mono.just("OK");
	}

}
