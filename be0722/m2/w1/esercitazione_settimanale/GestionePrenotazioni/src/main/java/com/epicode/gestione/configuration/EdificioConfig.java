package com.epicode.gestione.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.gestione.models.Edificio;

@Configuration
public class EdificioConfig {

	@Bean("e1")
	@Scope("prototype")
	public Edificio newEdificio() {
		Edificio e1 = new Edificio();
		e1.setId(1);
		
		e1.setName("hotel");
		e1.setCity("milano");
		e1.setIndirizzo("via milano, 1");
		
		return e1;
	}
}
