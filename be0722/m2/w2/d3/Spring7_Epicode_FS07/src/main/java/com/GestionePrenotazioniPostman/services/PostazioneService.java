package com.GestionePrenotazioniPostman.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionePrenotazioniPostman.repositories.PostazioneRepository;

@Service
public class PostazioneService {

	@Autowired
	PostazioneRepository postazioneRepository;
}
