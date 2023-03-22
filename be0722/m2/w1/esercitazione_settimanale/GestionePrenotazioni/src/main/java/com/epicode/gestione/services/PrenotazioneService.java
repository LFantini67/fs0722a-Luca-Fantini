package com.epicode.gestione.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.gestione.models.Prenotazione;
import com.epicode.gestione.repository.PrenotazioneRepository;

@Service
public class PrenotazioneService {

	@Autowired
	private PrenotazioneRepository repo;

	public List<Prenotazione> findAll() {
		return (List<Prenotazione>) repo.findAll();
	}

	public Prenotazione findById(Long id) {
		return repo.findById(id).get();
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}

	public void edit(Prenotazione prenotazione) {
		repo.save(prenotazione);
	}

	public void addPrenotazione(Prenotazione prenotazione) {
		repo.save(prenotazione);
	}
}
