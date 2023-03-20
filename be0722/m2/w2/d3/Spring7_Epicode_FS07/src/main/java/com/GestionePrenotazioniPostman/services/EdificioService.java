package com.GestionePrenotazioniPostman.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionePrenotazioniPostman.repositories.EdificioRepository;

@Service
public class EdificioService {

	@Autowired
	EdificioRepository edificioRepository;
}
