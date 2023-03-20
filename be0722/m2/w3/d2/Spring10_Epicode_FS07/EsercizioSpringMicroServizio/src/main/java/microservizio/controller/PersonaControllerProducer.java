package microservizio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import microservizio.model.Persona;
import microservizio.service.PersonaService;

@RestController
@RequestMapping("/api")
public class PersonaControllerProducer {
	
	@Autowired
	PersonaService perServ;
	
	@GetMapping(value = "/persone", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Persona>> getAllPersone() {
		List<Persona> listaPersone = perServ.visualizzaPersone();
//		return new ResponseEntity<List<Persona>>(listaPersone, HttpStatus.OK);
		return ResponseEntity.ok(listaPersone);
	}
	
	@DeleteMapping("/persone/{id}")
	public void cancellaPersona(@PathVariable Long id) {
		perServ.cancPers(id);
	}

}
