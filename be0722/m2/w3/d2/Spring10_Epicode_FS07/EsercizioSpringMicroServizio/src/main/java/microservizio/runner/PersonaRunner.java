package microservizio.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import microservizio.model.Persona;
import microservizio.service.PersonaService;

@Component
public class PersonaRunner implements ApplicationRunner {
	
	@Autowired
	PersonaService perServ;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
//		insertPersona();
		
	}
	
	private void insertPersona() {
		Persona p1 = Persona.builder().nome("Damiano").cognome("Tiberi").eta(18).build();
		Persona p2 = Persona.builder().nome("Stefano").cognome("Gavioli").eta(118).build();
		Persona p3 = Persona.builder().nome("Manuel").cognome("Ferrucci").eta(31).build();
		
		perServ.insertPersona(p1);
		perServ.insertPersona(p2);
		perServ.insertPersona(p3);
		
		
	}

}
