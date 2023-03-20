package com.GestionePrenotazioniPostman.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.GestionePrenotazioniPostman.models.Prenotazione;

@Repository
public interface PrenotazioneRepository extends CrudRepository<Prenotazione, Long> {

}
