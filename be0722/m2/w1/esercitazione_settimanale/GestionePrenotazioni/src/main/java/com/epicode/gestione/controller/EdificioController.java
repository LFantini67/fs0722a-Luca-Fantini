package com.epicode.gestione.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.gestione.models.Edificio;
import com.epicode.gestione.services.EdificioService;

@RestController
@RequestMapping("/edificio")
public class EdificioController {

	@Autowired
	EdificioService edificioService;
	
	@PostMapping("/add")
	public void creaEdificio(@RequestBody Edificio edificio) {

		edificioService.addEdificio(edificio);
	}
	
	@GetMapping
	public List<Edificio> findAll() {
		return edificioService.findAll();
	}
	
	@GetMapping("/{id}")
	public Edificio findById(@PathVariable Long id) {
		return edificioService.findById(id);
	}
}
