package model.Mezzo;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Autobus extends Mezzo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	public Autobus(Long id, int capienza, model.Mezzo.disponibilita disponibilita, int periodoServizio,
			int periodoManutenzione, int bigliettiConvalidati, int numeroGiri, Date partenza) {
		super(id, capienza, disponibilita, periodoServizio, periodoManutenzione, bigliettiConvalidati, numeroGiri, partenza);
		// TODO Auto-generated constructor stub
	}



	public Autobus() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
