package br.com.treinaweb.springexample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringExampleApplication implements CommandLineRunner {

	private final ClientRepository clientRepository;

	public SpringExampleApplication(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(clientRepository);
		System.out.println("A aplicação iniciou");
	}

}
