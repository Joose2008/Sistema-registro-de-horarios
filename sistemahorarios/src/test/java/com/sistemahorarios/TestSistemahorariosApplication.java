package com.sistemahorarios;

import org.springframework.boot.SpringApplication;

public class TestSistemahorariosApplication {

	public static void main(String[] args) {
		SpringApplication.from(SistemahorariosApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
