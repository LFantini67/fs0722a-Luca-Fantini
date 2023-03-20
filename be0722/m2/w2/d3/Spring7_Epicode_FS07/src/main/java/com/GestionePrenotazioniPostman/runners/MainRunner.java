package com.GestionePrenotazioniPostman.runners;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.GestionePrenotazioniPostman.models.Edificio;
import com.GestionePrenotazioniPostman.models.Postazione;
import com.GestionePrenotazioniPostman.models.Prenotazione;
import com.GestionePrenotazioniPostman.models.Utente;
import com.GestionePrenotazioniPostman.repositories.EdificioRepository;
import com.GestionePrenotazioniPostman.repositories.PostazioneRepository;
import com.GestionePrenotazioniPostman.repositories.PrenotazioneRepository;
import com.GestionePrenotazioniPostman.repositories.UtenteRepository;
import com.GestionePrenotazioniPostman.utils.TipoPostazione;

@Component
public class MainRunner implements ApplicationRunner {

	@Autowired
	EdificioRepository edificioRepository;
	@Autowired
	PostazioneRepository postazioneRepository;
	@Autowired
	PrenotazioneRepository prenotazioneRepository;
	@Autowired
	UtenteRepository utenteRepository;
	@Value("${gestioneprenotazioni.init}")
	private int controllo;

	public void creaDatiIniziali() {
		Edificio ed = new Edificio();
		ed.setCittà("Maranello");
		ed.setIndirizzo("via del bello 4");
		ed.setNome("casa mia");
		edificioRepository.save(ed);

		Postazione pos = new Postazione();
		pos.setDescrizione("bellina");
		pos.setEdificio(ed);
		pos.setNumeroMassimoOccupanti(10);
		pos.setTipo(TipoPostazione.PRIVATO);
		postazioneRepository.save(pos);

		Utente ut = new Utente();
		ut.setNomeCompleto("Stefano Gavioli");
		ut.setUsername("gavvio");
		ut.setEmail("steve.gavvio@gmail.com");
		utenteRepository.save(ut);

		Prenotazione pr = new Prenotazione();
		pr.setPostazione(pos);
		pr.setUtente(ut);
		pr.setDataPrenotazione(LocalDate.of(2023, 03, 8));
		prenotazioneRepository.save(pr);

	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("run");
		if (controllo == 1) {
			creaDatiIniziali();
		}
	}

}
