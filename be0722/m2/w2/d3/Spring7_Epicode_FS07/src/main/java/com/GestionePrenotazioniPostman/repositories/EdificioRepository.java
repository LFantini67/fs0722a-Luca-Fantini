package com.GestionePrenotazioniPostman.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.GestionePrenotazioniPostman.models.Edificio;

@Repository
public interface EdificioRepository extends CrudRepository<Edificio, Long> {

}
