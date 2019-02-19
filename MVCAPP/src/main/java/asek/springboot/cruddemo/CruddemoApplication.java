package asek.springboot.cruddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"asek.springboot.crudddemo.service","asek.springboot.cruddemo.dao","asek.springboot.cruddemo.entity","asek.springboot.cruddemo.rest"})
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

}

