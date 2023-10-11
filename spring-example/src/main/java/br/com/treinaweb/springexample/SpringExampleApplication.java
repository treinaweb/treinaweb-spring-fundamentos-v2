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
		clientRepository.save(new Client("Cleyson", 27));

		var clients = clientRepository.findAll();
		System.out.println(clients);

		var client1 = clientRepository.findById(1L);
		var client2 = clientRepository.findById(2L);

		if (client1.isPresent()) {
			System.out.println("Client com ID 1 encontrado");
			System.out.println(client1);
		}

		if (!client2.isPresent()) {
			System.out.println("Client com ID 2 não encontrado");
		}

		client1.get().setName("Cleyson Editado");
		clientRepository.save(client1.get());

		// clientRepository.deleteById(1L);
		clientRepository.delete(client1.get());
	}

}
