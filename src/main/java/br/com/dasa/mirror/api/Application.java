package br.com.dasa.mirror.api;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class Application {
	
	private static final Logger LOGGER = Logger.getLogger(Application.class.getName());

	public static void main(String[] args) {
		LOGGER.log(Level.INFO, "[LOG] Iniciando Application");
		SpringApplication.run(Application.class, args);
	}
}
