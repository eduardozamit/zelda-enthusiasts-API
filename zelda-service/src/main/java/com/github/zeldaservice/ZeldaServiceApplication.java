package com.github.zeldaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ZeldaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZeldaServiceApplication.class, args);
	}

	// Bean para configurar o WebClient usado nos serviços
	@Bean
	public WebClient webClient() {
		return WebClient.create();
	}
}
