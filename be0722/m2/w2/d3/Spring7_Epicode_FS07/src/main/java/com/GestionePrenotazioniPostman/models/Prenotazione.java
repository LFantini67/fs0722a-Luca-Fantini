package com.GestionePrenotazioniPostman.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Prenotazione {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer prenotazioneId;

	@ManyToOne
	@JoinColumn(name = "utenteid")
	private Utente utente;

	@ManyToOne
	@JoinColumn(name = "postazioneid")
	private Postazione postazione;

	private LocalDate dataPrenotazione;

}
