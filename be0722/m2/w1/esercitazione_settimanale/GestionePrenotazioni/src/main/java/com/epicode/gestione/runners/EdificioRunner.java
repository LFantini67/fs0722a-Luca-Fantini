package com.epicode.gestione.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.epicode.gestione.models.Edificio;
import com.epicode.gestione.services.EdificioService;

@Component
@Order(2)
public class EdificioRunner implements ApplicationRunner {
	
	@Autowired
	private EdificioService edificioService;
	
	@Autowired
	Edificio e1;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		edificioService.addEdificio(e1);

	}

}
