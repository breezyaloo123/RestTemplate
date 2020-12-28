package com.example.clientMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ClientMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientMsApplication.class, args);
	}

	@Bean
	public RestTemplate getrestTemplate()
	{
		return new RestTemplate();
	}

}
