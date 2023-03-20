package eserciziospringcore.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/be")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PersonaControllerConsumer {
	
	String url = "http://localhost:8084/api/persone";
	
	@GetMapping("/persone")
	public Object listaPersone() {
		
		RestTemplate rt = new RestTemplate();
		return rt.getForObject(url, Object.class);
		
	}
	
	@DeleteMapping("/persone/{id}")
	public void cancellaPersona(@PathVariable Long id) {
//		System.out.println(id);
		RestTemplate rt = new RestTemplate();
		rt.delete(url+"/"+id);
	}

}
