package com.casadocodigo.estoque_green_dog_delivery.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.casadocodigo.estoque_green_dog_delivery.config.RabbitmqConfig;
import com.casadocodigo.estoque_green_dog_delivery.domain.Estoque;
import com.casadocodigo.estoque_green_dog_delivery.domain.LogFila;
import com.casadocodigo.estoque_green_dog_delivery.repository.LogFilaRepository;

@Component
public class Producer {
	
	private final Logger logger = LoggerFactory.getLogger(Producer.class.getSimpleName());

	@Autowired
	private LogFilaRepository logFilaRepository;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void send(Estoque message) throws Exception {

		logger.info("Enviando mensagem...");

		logFilaRepository.save(new LogFila("Enviando",message.toString()));

		rabbitTemplate.convertAndSend(RabbitmqConfig.QUEUE_NAME, message);

	}

}