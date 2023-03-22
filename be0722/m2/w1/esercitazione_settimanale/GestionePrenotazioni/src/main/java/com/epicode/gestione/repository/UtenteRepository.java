package com.epicode.gestione.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epicode.gestione.models.Utente;

@Repository
public interface UtenteRepository extends CrudRepository<Utente, Long> {

}
