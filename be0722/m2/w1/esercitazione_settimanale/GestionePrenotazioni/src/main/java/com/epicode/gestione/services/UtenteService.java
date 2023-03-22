package com.epicode.gestione.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.gestione.models.Utente;
import com.epicode.gestione.repository.UtenteRepository;

@Service
public class UtenteService {

	@Autowired
	private UtenteRepository repo;

	public List<Utente> findAll() {
		return (List<Utente>) repo.findAll();
	}

	public Utente findById(Long id) {
		return repo.findById(id).get();
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}

	public void edit(Utente utente) {
		repo.save(utente);
	}

	public void addUtente(Utente utente) {
		repo.save(utente);
	}
}
