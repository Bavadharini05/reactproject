package com.database.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
info =@Info(
		title = "Stockmangement",
		version = "1.1.2",
		description = "properities management",
		contact = @Contact(
				name = "Bavadharini",
				email = "bava@gmail"
				)
		)
)
public class StockmangementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockmangementApplication.class, args);
	}

}
