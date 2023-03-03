package model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity 
public class Utente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_utente;
	
	@OneToOne(mappedBy = "utente", cascade = { CascadeType.REMOVE})
	@JoinColumn(name="id_tessera")
	private Tessera_Utente tessera;
	
	private String nome;
	
	private String cognome;

	
	public Utente(Long id_utente, Tessera_Utente tessera, String nome, String cognome) {
		super();
		this.id_utente = id_utente;
		this.tessera = tessera;
		this.nome = nome;
		this.cognome = cognome;
	}

	
	public Utente() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Tessera_Utente getTessera() {
		return tessera;
	}

	public void setTessera(Tessera_Utente tessera) {
		this.tessera = tessera;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Long getId_utente() {
		return id_utente;
	}

	public void setId(Long t) {
		this.id_utente = t;
	}


	@Override
	public String toString() {
		return "Utente [id_utente=" + id_utente + ", tessera=" + tessera + ", nome=" + nome + ", cognome=" + cognome
				+ "]";
	}
	

	
	
}
