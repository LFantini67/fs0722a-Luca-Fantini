package com.epicode.gestione.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostazioneAziendale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String descrizione;
	@NonNull
	private Enum <Tipo> Tipo;
	@NonNull
	private Long numeroOccupanti;
	
	@OneToOne
	private Edificio edificio;
}
