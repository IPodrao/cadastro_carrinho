package com.br.ipodrao.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class Cadastro_CarrinhoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Cadastro_CarrinhoApplication.class, args);
	}

}
