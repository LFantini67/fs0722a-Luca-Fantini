package com.epicode.gestione.configuration;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


import com.epicode.gestione.models.Prenotazione;
import com.epicode.gestione.services.PostazioneAziendaleService;
import com.epicode.gestione.services.UtenteService;

@Configuration
public class PrenotazioneConfig {

	@Autowired
	private PostazioneAziendaleService postazioneAziendaleService;
	
	@Autowired
	private UtenteService utenteService;
	
	@Bean
	@Scope("prototype")
	public Prenotazione newPrenotazione() {
		
		Prenotazione pre1 = new Prenotazione();
		
		pre1.setData(LocalDate.now());
		pre1.setUtente(utenteService.findById((long) 1));
		pre1.setPostazione(postazioneAziendaleService.findById((long) 1));
		
		return pre1;
	}
}
