package com.GestionePrenotazioniPostman.models;

import java.util.List;

import com.GestionePrenotazioniPostman.utils.TipoPostazione;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Postazione {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer postazioneId;

	private String descrizione;
	@Enumerated(EnumType.STRING)
	private TipoPostazione tipo;
	private int numeroMassimoOccupanti;

	@ManyToOne
	@JoinColumn(name = "edificioid")
	private Edificio edificio;


}
