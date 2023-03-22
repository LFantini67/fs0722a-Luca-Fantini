package com.epicode.gestione.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.gestione.models.PostazioneAziendale;
import com.epicode.gestione.models.Tipo;
import com.epicode.gestione.services.EdificioService;

@Configuration
public class PostazioneAziendaleConfig {

	
	@Autowired
	EdificioService edificioService;
		
	
	@Bean
	@Scope("prototype")
	public PostazioneAziendale newPostazioneAziendale() {

		PostazioneAziendale p1 = new PostazioneAziendale();

		p1.setDescrizione("Meeting");
		p1.setTipo(Tipo.OPENSPACE);
		p1.setEdificio(edificioService.findById(1));
		return p1;
	}
}
