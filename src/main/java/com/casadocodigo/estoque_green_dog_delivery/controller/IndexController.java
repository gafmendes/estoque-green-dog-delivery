package com.casadocodigo.estoque_green_dog_delivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/")
	public String getRoot() {
		return "home";
	}

	@GetMapping("/home")
	public String getHome() {
		return "home";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

}