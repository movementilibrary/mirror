package br.com.dasa.mirror.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@SqsListener("admissoes-dev")
	public void listen(DataObject message) {
		System.out.println(message.getFoo() +" - "+message.getBar());
	}

	public static class DataObject {
		private String foo;
		private String bar;

		@JsonCreator
		public DataObject(@JsonProperty("foo") String foo, @JsonProperty("bar") String bar) {
			this.foo = foo;
			this.bar = bar;
		}

		public String getFoo() {
			return foo;
		}

		public String getBar() {
			return bar;
		}
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
