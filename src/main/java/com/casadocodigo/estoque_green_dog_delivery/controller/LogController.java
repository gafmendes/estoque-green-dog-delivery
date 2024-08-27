package com.casadocodigo.estoque_green_dog_delivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casadocodigo.estoque_green_dog_delivery.domain.LogFila;
import com.casadocodigo.estoque_green_dog_delivery.repository.LogFilaRepository;

import io.swagger.v3.oas.annotations.Hidden;

@Hidden
@RestController
@RequestMapping("/api")
public class LogController {

	@Autowired
	LogFilaRepository logFilaRepository;

	@GetMapping("/logs")
	public List<LogFila> getLogs() {
		return logFilaRepository.findAll();
	}

}
