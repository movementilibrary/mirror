package br.com.dasa.mirror.api;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.dasa.mirror.api.service.impl.ConsumerSQSService;

@SpringBootApplication
@Component
@Order(1)
public class Application {
	
	private static final Logger LOGGER = Logger.getLogger(Application.class.getName());

	public static void main(String[] args) {
		LOGGER.log(Level.INFO, "[LOG] Iniciando Application");
		SpringApplication.run(Application.class, args);
	}
}
@Component
@Order(2)
class Application2 implements ApplicationRunner {
	private static final Logger LOGGER = Logger.getLogger(Application2.class.getName());

	@Autowired
	ConsumerSQSService consumerSQSService;
	
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
		LOGGER.log(Level.INFO, "[LOG] Iniciando Consumer SQS");
        consumerSQSService.consumerSQS();
    }
}
