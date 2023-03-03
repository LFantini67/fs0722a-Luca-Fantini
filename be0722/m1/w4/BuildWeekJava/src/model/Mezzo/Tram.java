package model.Mezzo;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Tram extends Mezzo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	public Tram(Long id, int capienza, model.Mezzo.disponibilita disponibilita, int periodoServizio,
			int periodoManutenzione, int bigliettiConvalidati, int numeroGiri, Date partenza) {
		super(id, capienza, disponibilita, periodoServizio, periodoManutenzione, bigliettiConvalidati, numeroGiri, partenza);
		// TODO Auto-generated constructor stub
	}



	public Tram() {
		super();
		// TODO Auto-generated constructor stub
	}

}
