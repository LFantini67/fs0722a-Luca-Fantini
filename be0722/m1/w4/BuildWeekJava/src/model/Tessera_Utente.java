package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import model.Ticket.Ticket;

@Entity
public class Tessera_Utente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_tessera;
	
	private Date dataEmissione;
	
	private Date dataScadenza;
	
	
	private boolean attiva = true;
	
	@OneToOne(cascade = { CascadeType.REMOVE})
	@JoinColumn(name = "id_utente")
	private Utente utente;
	
	@OneToMany(mappedBy = "tessera_utente",cascade = {CascadeType.REMOVE})
	private List<Ticket> tickets = new ArrayList<>();

	
	public Tessera_Utente(Long id_tessera, Date dataEmissione, Date dataScadenza, Utente utente, List<Ticket> tickets) {
		super();
		this.id_tessera = id_tessera;
		this.dataEmissione = dataEmissione;
		this.dataScadenza = dataScadenza;
		this.utente = utente;
		this.tickets = tickets;
	}
	
	
	public Tessera_Utente() {
		super();
		// TODO Auto-generated constructor stub
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

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Long getId_tessera() {
		return id_tessera;
	}

	public void setId(Long u) {
		this.id_tessera = u;
	}


	public boolean isAttiva() {
		return attiva;
	}

	public void setAttiva(boolean attiva) {
		this.attiva = attiva;
	}

}
