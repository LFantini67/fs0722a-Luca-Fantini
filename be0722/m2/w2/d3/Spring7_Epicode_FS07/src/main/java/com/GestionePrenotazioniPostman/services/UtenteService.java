package com.GestionePrenotazioniPostman.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionePrenotazioniPostman.repositories.UtenteRepository;

@Service
public class UtenteService {

	@Autowired UtenteRepository utenteRepository;
	
}
