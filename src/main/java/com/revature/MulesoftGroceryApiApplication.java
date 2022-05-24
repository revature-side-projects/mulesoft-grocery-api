package com.revature;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Grocery API", version = "1.0", description = "Grocery API"))
public class MulesoftGroceryApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MulesoftGroceryApiApplication.class, args);
	}

}
