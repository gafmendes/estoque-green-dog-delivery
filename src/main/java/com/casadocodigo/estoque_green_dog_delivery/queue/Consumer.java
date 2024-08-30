package com.casadocodigo.estoque_green_dog_delivery.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.casadocodigo.estoque_green_dog_delivery.domain.Estoque;
import com.casadocodigo.estoque_green_dog_delivery.domain.LogFila;
import com.casadocodigo.estoque_green_dog_delivery.repository.EstoqueRepository;
import com.casadocodigo.estoque_green_dog_delivery.repository.LogFilaRepository;

@Component
public class Consumer {

	private final Logger logger = LoggerFactory.getLogger(Consumer.class.getSimpleName());
	@Autowired
	private LogFilaRepository logFilaRepository;

	@Autowired
	private EstoqueRepository estoqueRepository;

	@RabbitListener(queues = { "springboot.boaglio.queue" })
	public void receiveMessage(@Payload Estoque mensagem) {

		logger.info("Recebido via fila: <" + mensagem + ">");

		logFilaRepository.save(new LogFila("Recebendo", mensagem.toString()));

		logger.info("Gravando: <" + mensagem + ">");

		estoqueRepository.save(mensagem);

	}
}
