package com.epicode.gestione.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.gestione.models.PostazioneAziendale;
import com.epicode.gestione.models.Utente;
import com.epicode.gestione.services.PostazioneAziendaleService;

@RestController
@RequestMapping("/postazione")
public class PostazioneAziendaleController {

	@Autowired
	PostazioneAziendaleService postazioneAziendaleService;

	@PostMapping("add")
	public void addPostazione(@RequestBody PostazioneAziendale postazioneAziendale) {

		postazioneAziendaleService.addPostazioneAziendale(postazioneAziendale);
	}
	
	@GetMapping
	public List<PostazioneAziendale> findAll(){
		return postazioneAziendaleService.findAll();
	}
	
	@GetMapping("/{id}")
	public PostazioneAziendale findById(@PathVariable Long id) {
		return postazioneAziendaleService.findById(id);
	}

}
