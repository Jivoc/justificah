package progweb.prova01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import progweb.prova01.Prova01Application;

@SpringBootApplication
public class Prova01Application {

	private static final Logger logger = LoggerFactory.getLogger(Prova01Application.class);

	public static void main(String[] args) {
		logger.info(">>>> Iniciando a execucao da aplicacao");
		SpringApplication.run(Prova01Application.class, args);
		logger.info(">>>> Aplicacao inicializada");
	}
}
