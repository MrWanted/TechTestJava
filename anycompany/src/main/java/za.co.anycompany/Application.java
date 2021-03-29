package za.co.anycompany;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import za.co.anycompany.entity.Customer;
import za.co.anycompany.service.CustomerService;

@SpringBootApplication
@RestController
@Log
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerService repository) {
		return (args) -> {
			log.info("save few sample customers..");
			repository.save(new Customer("Linda", "Motholo"));
			repository.save(new Customer("Tumi", "Sang"));
			repository.save(new Customer("Linda", "Shole"));
			repository.save(new Customer("Wanted", "Lepota"));
			repository.save(new Customer("Michelle", "Dessler"));
		};
	}
}
