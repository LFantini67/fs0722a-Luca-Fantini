package com.epicode.gestione.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epicode.gestione.models.Utente;

@Configuration
public class UtenteConfig {
	
	@Bean
	public Utente newUtente() {
		
		Utente u1 = new Utente();
		
		u1.setName("Cristian");
		u1.setSurname("Laporta");
		u1.setMail("cristian@live.it");
		u1.setUsername("TheCriicom");
		
		return u1;
	}
}
