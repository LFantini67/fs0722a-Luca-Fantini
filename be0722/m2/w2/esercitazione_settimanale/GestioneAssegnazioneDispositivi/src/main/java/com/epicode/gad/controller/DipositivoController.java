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

import com.epicode.gad.dispositivo.Dispositivo;
import com.epicode.gad.dispositivo.DispositivoService;

@RestController
@RequestMapping("/dispositivi")
public class DipositivoController {

	@Autowired
	DispositivoService dispositivoService;

	@GetMapping
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<Dispositivo>> getAllDevice() {

		return ResponseEntity.ok(dispositivoService.getAllDevice());
	}

	@GetMapping("/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<Dispositivo> findById(@PathVariable Long id) {

		return ResponseEntity.ok(dispositivoService.findById(id));
	}

	@PostMapping("/crea")
	@PreAuthorize("hasRole('ADMIN')")
	ResponseEntity<Dispositivo> postDevice(@RequestBody Dispositivo dispositivo) {

		return ResponseEntity.ok(dispositivoService.postDevice(dispositivo));
	}

	@PutMapping("/modifica/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	ResponseEntity<Dispositivo> putDevice(@PathVariable Long id, @RequestBody Dispositivo dispositivo) {

		return ResponseEntity.ok(dispositivoService.putDevice(id, dispositivo));
	}

	@DeleteMapping("/elimina/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteDevice(@PathVariable Long id) {

		dispositivoService.deleteDevice(id);
		return ResponseEntity.ok("Utente Cancellato");
	}
}
