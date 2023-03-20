package com.GestionePrenotazioniPostman.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.GestionePrenotazioniPostman.models.Postazione;

@Repository
public interface PostazioneRepository extends CrudRepository<Postazione, Long> {

}
