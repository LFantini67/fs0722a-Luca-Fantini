package com.epicode.gestione.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.gestione.models.PostazioneAziendale;
import com.epicode.gestione.models.Utente;
import com.epicode.gestione.repository.PostazioneAziendaleRepository;
import com.epicode.gestione.repository.UtenteRepository;

@Service
public class PostazioneAziendaleService {
	
	@Autowired
	private PostazioneAziendaleRepository repo;

	public List<PostazioneAziendale> findAll() {
		return (List<PostazioneAziendale>) repo.findAll();
	}

	public PostazioneAziendale findById(Long id) {
		return repo.findById(id).get();
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}

	public void edit(PostazioneAziendale postazioneAziendale) {
		repo.save(postazioneAziendale);
	}

	public void addPostazioneAziendale(PostazioneAziendale postazioneAziendale) {
		repo.save(postazioneAziendale);
	}
}
