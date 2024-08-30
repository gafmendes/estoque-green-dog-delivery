package com.casadocodigo.estoque_green_dog_delivery.carga;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.casadocodigo.estoque_green_dog_delivery.domain.Estoque;
import com.casadocodigo.estoque_green_dog_delivery.repository.EstoqueRepository;

import reactor.core.publisher.Mono;

@Component
public class RepositoryTest implements ApplicationRunner {

	private static final long TOTAL_DE_REGISTROS = 100000L;

	private final Logger logger = LoggerFactory.getLogger(RepositoryTest.class.getSimpleName());

	private final EstoqueRepository repository;

	public RepositoryTest(EstoqueRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {

		var totalAntes = repository.count();

		if (totalAntes < TOTAL_DE_REGISTROS) {

			logger.info(">>> Iniciando carga de dados...");

			logger.info(">>> Total antes: " + Mono.just(totalAntes));

			int contador;
			for (contador = 0; contador < TOTAL_DE_REGISTROS; contador++) {
				repository.save(new Estoque(getRandomIntegerBetweenRange(1, 3), getRandomIntegerBetweenRange(1, 5)));

				if (contador % 100 == 0)
					logger.info(">>> Gravado estoque: " + (contador + 1));
			}

			logger.info(">>> Total de registros gravados: " + contador);

			var totalDepois = repository.count();

			logger.info(">>> Total depois: " + totalDepois);
		}

	}

	public static long getRandomIntegerBetweenRange(double min, double max) {
		long x = (long) ((int) (Math.random() * ((max - min) + 1)) + min);
		return x;
	}

}
