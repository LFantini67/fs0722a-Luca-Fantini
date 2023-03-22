package com.epicode.gestione.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.epicode.gestione.models.Utente;
import com.epicode.gestione.services.UtenteService;



@Component
@Order(1)
public class UtenteRunner implements ApplicationRunner {

	@Autowired
	private UtenteService utenteService;

	@Autowired
	Utente u1;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
	utenteService.addUtente(u1);
	
	
		
	}

}
