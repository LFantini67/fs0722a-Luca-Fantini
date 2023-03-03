package model.Biglietteria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import model.Ticket.Ticket;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Biglietteria implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int contaBigliettiEmessi = 0;
	
	private int contaAbbonamentiEmessi = 0;
	
	private int contaTicketTotali = 0;
	
	@OneToMany(mappedBy = "biglietteria" ,cascade = { CascadeType.REMOVE})
	private List<Ticket> tickets = new ArrayList<>();

	public int getContaBigliettiEmessi() {
		return contaBigliettiEmessi;
	}

	public void setContaBigliettiEmessi(int contaBigliettiEmessi) {
		this.contaBigliettiEmessi = contaBigliettiEmessi;
	}

	public int getContaAbbonamentiEmessi() {
		return contaAbbonamentiEmessi;
	}

	public void setContaAbbonamentiEmessi(int contaAbbonamentiEmessi) {
		this.contaAbbonamentiEmessi = contaAbbonamentiEmessi;
	}

	public int getContaTicketTotali() {
		return contaTicketTotali;
	}

	public void setContaTicketTotali(int contaTicketTotali) {
		this.contaTicketTotali = contaTicketTotali;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Long getId() {
		return id;
	}

	
	
}
