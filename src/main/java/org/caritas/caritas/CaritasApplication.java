package org.caritas.caritas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CaritasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaritasApplication.class, args);
	}

}
