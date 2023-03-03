package model.Biglietteria;

import javax.persistence.Entity;

@Entity
public class RivenditoreAutomatico extends Biglietteria {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Stato stato = Stato.ATTIVO;

	public Stato getStato() {
		return stato;
	}

	public void setStato(Stato stato) {
		this.stato = stato;
	}

	
	
}
