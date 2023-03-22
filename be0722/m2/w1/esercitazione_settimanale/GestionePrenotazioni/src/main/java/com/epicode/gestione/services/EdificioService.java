package com.epicode.gestione.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.gestione.models.Edificio;
import com.epicode.gestione.repository.EdificioRepository;

@Service
public class EdificioService {

	@Autowired
	private EdificioRepository repo;
	
	public List<Edificio> findAll() {
		return (List<Edificio>) repo.findAll();
	}

	public Edificio findById(long i) {
		return repo.findById(i).get();
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}

	public void edit(Edificio edificio) {
		repo.save(edificio);
	}

	public void addEdificio(Edificio edificio) {
		repo.save(edificio);
	}
}
