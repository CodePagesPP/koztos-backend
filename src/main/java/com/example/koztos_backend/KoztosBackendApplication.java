package com.example.koztos_backend;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class KoztosBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(KoztosBackendApplication.class, args);
	}

	@PostConstruct
	public void init() {

		TimeZone.setDefault(TimeZone.getTimeZone("America/Lima"));
		System.out.println("Zona horaria configurada a: " + TimeZone.getDefault().getID());
	}
}
