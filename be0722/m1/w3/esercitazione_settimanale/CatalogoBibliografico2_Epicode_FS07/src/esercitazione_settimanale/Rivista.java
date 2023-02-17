package esercitazione_settimanale;

public class Rivista extends ElementoCartaceo {
	
	private Periodicita periodicita;

	public Rivista(String isbn, String titolo, Integer annoPubblicazione, Integer numeroPagine,
			Periodicita periodicita) {
		super(isbn, titolo, annoPubblicazione, numeroPagine);
		this.periodicita = periodicita;
	}

	public Periodicita getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Periodicita periodicita) {
		this.periodicita = periodicita;
	}
	
	

}
