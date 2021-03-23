package br.com.pacato;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PacatoApplication {
	public static void main(String[] args) {
		SpringApplication.run(PacatoApplication.class, args);
		System.out.println("Oi mundo");
	}
}
