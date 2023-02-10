package com.dancode.pokedexApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
proxyBeanMethods= false)
public class PokedexAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokedexAppApplication.class, args);
	}

}
