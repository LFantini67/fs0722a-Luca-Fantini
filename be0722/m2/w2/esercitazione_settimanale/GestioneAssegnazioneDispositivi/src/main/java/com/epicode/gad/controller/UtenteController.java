package com.epicode.gad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.gad.auth.utente.Utente;
import com.epicode.gad.auth.utente.UtenteService;

@RestController
@RequestMapping("/utenti")
public class UtenteController {

	@Autowired
	UtenteService userService;

	@GetMapping
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<Utente>> getAllUser() {

		return ResponseEntity.ok(userService.getAllUser());
	}

	@GetMapping("/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<Utente> findById(@PathVariable Long id) {

		return ResponseEntity.ok(userService.findById(id));
	}

	@PostMapping("/crea")
	public ResponseEntity<Utente> postUser(@RequestBody Utente utente) {

		return ResponseEntity.ok(userService.postUser(utente));
	}

	@PutMapping("/modifica/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Utente> putUser(@PathVariable Long id, @RequestBody Utente utente) {

		return ResponseEntity.ok(userService.putUser(id, utente));
	}

	@DeleteMapping("/elimina/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return ResponseEntity.ok("Utente Cancellato");
	}
}
