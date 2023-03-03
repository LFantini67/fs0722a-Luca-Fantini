package model.Ticket;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Abbonamento extends Ticket {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Enumerated(EnumType.STRING)
	private Periodicita periodicita;
	

	public Periodicita getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Periodicita periodicita) {
		this.periodicita = periodicita;
	}
	
}
