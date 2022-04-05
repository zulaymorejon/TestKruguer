package com.empleado.kruguer.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
public class ApirestEmpleadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApirestEmpleadoApplication.class, args);
	}

}
