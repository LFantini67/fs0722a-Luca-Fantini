package com.epicode.gestione.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.epicode.gestione.configuration.EdificioConfig;
import com.epicode.gestione.models.Edificio;
import com.epicode.gestione.models.PostazioneAziendale;
import com.epicode.gestione.services.EdificioService;
import com.epicode.gestione.services.PostazioneAziendaleService;

@Component
@Order(3)
public class PostazioneAziendaleRunner implements ApplicationRunner {

	@Autowired
	private PostazioneAziendaleService postazioneAziendaleService;
	
	@Autowired
	PostazioneAziendale p1;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		
		postazioneAziendaleService.addPostazioneAziendale(p1);

	}

}
