package com.epicode.gestione.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.gestione.models.Prenotazione;
import com.epicode.gestione.services.PrenotazioneService;

@RestController
@RequestMapping("/prenotazione")
public class PrenotazioneController {

	@Autowired
	PrenotazioneService prenotazioneService;
	
	@PostMapping("/add")
	public void addPrenotazione(@RequestBody Prenotazione prenotazione) {
		
		prenotazioneService.addPrenotazione(prenotazione);
	}
	
	@GetMapping
	public List<Prenotazione> findAll(){
		return prenotazioneService.findAll();
	}
	
	@GetMapping("/{id}")
	public Prenotazione findById(@PathVariable Long Id) {
		return prenotazioneService.findById(Id);
	}
}
