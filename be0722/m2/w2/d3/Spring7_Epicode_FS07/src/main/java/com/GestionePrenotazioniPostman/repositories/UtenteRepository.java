package com.GestionePrenotazioniPostman.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.GestionePrenotazioniPostman.models.Utente;

@Repository
public interface UtenteRepository extends CrudRepository<Utente, Long> {

}
