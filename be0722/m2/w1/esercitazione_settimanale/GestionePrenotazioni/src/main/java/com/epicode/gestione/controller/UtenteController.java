package com.epicode.gestione.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.gestione.models.Utente;
import com.epicode.gestione.services.UtenteService;

@RestController
@RequestMapping("/utente")
public class UtenteController {

	@Autowired
	UtenteService utenteService;
	
	@PostMapping("/add")
	public void addUtente(@RequestBody Utente utente) {
		
		utenteService.addUtente(utente);
	}
	
	@GetMapping
	public List<Utente> findAll(){
		return utenteService.findAll();
	}
	
	@GetMapping("/{id}")
	public Utente findById(@PathVariable Long id) {
		return utenteService.findById(id);
	}
}
