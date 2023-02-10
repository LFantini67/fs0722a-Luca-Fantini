package esercitazione_settimanale;

public class CatalogoBibliotecario {
	
	private String codiceUnivoco;
	private String titolo;
	private String annoPubblicazione;
	private int numeroPagine;
	
	public CatalogoBibliotecario(String codiceUnivoco, String titolo, String annoPubblicazione, int numeroPagine) {
		super();
		this.codiceUnivoco = codiceUnivoco;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroPagine = numeroPagine;
	}

	public String getCodiceUnivoco() {
		return codiceUnivoco;
	}

	public String getTitolo() {
		return titolo;
	}

	public String getAnnoPubblicazione() {
		return annoPubblicazione;
	}

	public int getNumeroPagine() {
		return numeroPagine;
	}

	@Override
	public String toString() {
		return "CatalogoBibliotecario [codiceUnivoco=" + codiceUnivoco + ", titolo=" + titolo + ", annoPubblicazione="
				+ annoPubblicazione + ", numeroPagine=" + numeroPagine + "]";
	}
	
}
