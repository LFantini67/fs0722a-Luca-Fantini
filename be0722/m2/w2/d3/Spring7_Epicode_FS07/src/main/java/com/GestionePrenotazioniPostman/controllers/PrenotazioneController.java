package com.GestionePrenotazioniPostman.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GestionePrenotazioniPostman.models.Prenotazione;
import com.GestionePrenotazioniPostman.services.PrenotazioneService;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {

	@Autowired
	PrenotazioneService prenotazioneService;

	@GetMapping
	public ResponseEntity<List<Prenotazione>> getAllPrenotazione() {
		return new ResponseEntity<List<Prenotazione>>(prenotazioneService.findAllPrenotazioni(), HttpStatus.OK);
	}

}
