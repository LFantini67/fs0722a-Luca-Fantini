package esercitazione_settimanale;

public class Libri extends CatalogoBibliotecario {
	
	private String autore;
	private String genere;
	
	public Libri(String codiceUnivoco, String titolo, String annoPubblicazione, int numeroPagine) {
		super(codiceUnivoco, titolo, annoPubblicazione, numeroPagine);
		// TODO Auto-generated constructor stub
		this.autore = autore;
		this.genere = genere;
	}

	public String getAutore() {
		return autore;
	}

	public String getGenere() {
		return genere;
	}

	@Override
	public String toString() {
		return "Libri [autore=" + autore + ", genere=" + genere + "]";
	}
	
}
