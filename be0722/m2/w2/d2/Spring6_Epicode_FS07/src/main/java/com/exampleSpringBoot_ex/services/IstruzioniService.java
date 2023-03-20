package com.exampleSpringBoot_ex.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.exampleSpringBoot_ex.exceptions.LinguaException;

@Service
public class IstruzioniService {
	
	@Value("${gestionePrenotazioni.istruzioniInglese}")
	private String istruzioniInglese;
	@Value("${gestionePrenotazioni.istruzioniItaliano}")
	private String istruzioniItaliano;

	public String check(String lingua) {
		if(lingua.equals("italiano")) {
			return istruzioniItaliano;
		}else if(lingua.equals("inglese")) {
			return istruzioniInglese;
		}else {
			throw new LinguaException("Errore");
		}
}
}
