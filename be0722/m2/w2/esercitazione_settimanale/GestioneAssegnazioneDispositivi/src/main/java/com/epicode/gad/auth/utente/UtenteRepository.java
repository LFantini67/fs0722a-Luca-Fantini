package com.epicode.gad.auth.utente;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {
	Optional<Utente> findByUsername(String username);

	Boolean existsByUsername(String username);
}
