package com.epicode.gestione.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.epicode.gestione.models.Prenotazione;
import com.epicode.gestione.services.PrenotazioneService;

@Component
@Order(4)
public class PrenotazioneRunner implements ApplicationRunner {

	@Autowired
	private PrenotazioneService prenotazioneService;
	
	@Autowired
	Prenotazione pre1;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		
		prenotazioneService.addPrenotazione(pre1);

	}

}
