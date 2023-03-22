package com.epicode.gestione.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epicode.gestione.models.PostazioneAziendale;

@Repository
public interface PostazioneAziendaleRepository extends CrudRepository<PostazioneAziendale, Long> {

}
