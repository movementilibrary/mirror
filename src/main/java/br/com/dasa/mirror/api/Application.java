package br.com.dasa.mirror.api;

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
	
	public static void main(String[] args) {
        System.out.println( "Application1" );
		SpringApplication.run(Application.class, args);
	}
}
@Component
@Order(2)
class Application2 implements ApplicationRunner {
	
	@Autowired
	ConsumerSQSService consumerSQSService;
	
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        System.out.println( "Application2" );
        consumerSQSService.consumerSQS();
    }
}
