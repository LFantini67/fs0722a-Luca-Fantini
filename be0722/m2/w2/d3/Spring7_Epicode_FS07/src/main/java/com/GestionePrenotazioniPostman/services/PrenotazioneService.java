package com.GestionePrenotazioniPostman.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionePrenotazioniPostman.models.Prenotazione;
import com.GestionePrenotazioniPostman.repositories.PrenotazioneRepository;

@Service
public class PrenotazioneService {

	@Autowired
	PrenotazioneRepository prenotazioneRepository;

	public List<Prenotazione> findAllPrenotazioni() {

		return (List<Prenotazione>) prenotazioneRepository.findAll();
	}
	
	
}
