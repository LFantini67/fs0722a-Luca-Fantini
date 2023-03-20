package microservizio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import microservizio.model.Persona;
import microservizio.repository.PersonaRepository;

@Service
public class PersonaService {
	
	@Autowired
	PersonaRepository perRepo;
	
	public String insertPersona(Persona per) {
		perRepo.save(per);
		return "Persona inserita";
	}
	
	public List<Persona> visualizzaPersone() {
		return perRepo.findAll();
	}
	
	public String cancPers(Long id) {
		Persona p = perRepo.findById(id).get();
		perRepo.delete(p);
		return "Persona eliminata";
	}

}
