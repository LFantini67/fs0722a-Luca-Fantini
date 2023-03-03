package model.Ticket;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import model.Tessera_Utente;
import model.Biglietteria.Biglietteria;
import model.Mezzo.Mezzo;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Ticket implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Boolean convalidato = false;
	
	private Date dataEmissione;
	
	private Date dataScadenza;
	
	private Date dataConvalida;
	
	@ManyToOne(cascade = { CascadeType.REMOVE})
	@JoinColumn(name="tessera_utente")
	private Tessera_Utente tessera_utente;
	
	@ManyToOne(cascade = { CascadeType.REMOVE})
	@JoinColumn(name= "biglietteria")
	private Biglietteria biglietteria;
	
	@ManyToOne(cascade = { CascadeType.REMOVE})
	@JoinColumn(name= "mezzo_id")
	private Mezzo mezzo_id;

	public Boolean getConvalidato() {
		return convalidato;
	}

	public void setConvalidato(Boolean convalidato) {
		this.convalidato = convalidato;
	}

	public Date getDataEmissione() {
		return dataEmissione;
	}

	public void setDataEmissione(Date dataEmissione) {
		this.dataEmissione = dataEmissione;
	}

	public Date getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public Tessera_Utente getTessera_utente() {
		return tessera_utente;
	}

	public void setTessera_utente(Tessera_Utente tessera_utente) {
		this.tessera_utente = tessera_utente;
	}

	public Biglietteria getBiglietteria() {
		return biglietteria;
	}

	public void setBiglietteria(Biglietteria biglietteria) {
		this.biglietteria = biglietteria;
	}

	public Long getId() {
		return id;
	}

	public Mezzo getMezzo_id() {
		return mezzo_id;
	}

	public void setMezzo_id(Mezzo mezzo_id) {
		this.mezzo_id = mezzo_id;
	}

	public Date getDataConvalida() {
		return dataConvalida;
	}

	public void setDataConvalida(Date dataConvalida) {
		this.dataConvalida = dataConvalida;
	}
	

	
	
}
