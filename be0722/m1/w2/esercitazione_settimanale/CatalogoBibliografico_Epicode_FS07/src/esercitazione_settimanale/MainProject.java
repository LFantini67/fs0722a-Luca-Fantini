package esercitazione_settimanale;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainProject {
	
	private static Map<String, String> elemento = new HashMap<String, String>();
	private static Scanner sc = new Scanner(System.in);
	private static Logger log = LoggerFactory.getLogger(MainProject.class);
	static List<CatalogoBibliotecario> catalogoBibliotecario = new ArrayList<CatalogoBibliotecario>();
	static File file = new File ("elementi/catalogoBibliotecario.txt");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		while(true) {
			System.out.println("Aggiungi elemento (si / no)");
			String scelta = sc.nextLine();
			if(scelta.equals("no")) {
				break;
			}
			System.out.print("Codice ISBN: ");
			String codiceUnivoco = sc.nextLine();
			System.out.print("Titolo: ");
			String titolo = sc.nextLine();
			System.out.print("Anno pubblicazione: ");
			String annoPubblicazione = sc.nextLine();
			System.out.print("Numero pagine: ");
			String numeroPagine = sc.nextLine();
			System.out.print("Autore: ");
			String autore = sc.nextLine();
			System.out.print("Genere: ");
			String genere = sc.nextLine();
			
			try {
				aggiungiElemento(codiceUnivoco, titolo, annoPubblicazione, 0, autore, genere);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
			
		}
		
		stampaElementi();
		
		System.out.print("Rimuovi elemento da ISBN (si/no)");
		String scelta = sc.nextLine();
		if(scelta.equals("si")) {
			System.out.print("Inserire codice ISBN: ");
			String codiceElemento = sc.nextLine();
			try {
				rimuoviElemento(codiceElemento);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
			stampaElementi();
		}
		
		try {
			leggiElementi();
			CatalogoBibliotecario e =  new CatalogoBibliotecario("AB5678", "Java", "1995", 285);
			catalogoBibliotecario.add(e);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Errore");
		}

	}
	
	private static void aggiungiElemento(String codiceUnivoco, String titolo, String annoPubblicazione, int numeroPagine, String autore, String genere) throws Exception {
		if(elemento.containsKey(codiceUnivoco)) {
			throw new Exception("Codice univoco già presente nel catalogo");
		} else {
			elemento.put(codiceUnivoco, titolo);
		}
	}
	
	private static void rimuoviElemento(String codiceUnivoco) throws Exception {
		if(elemento.containsKey(codiceUnivoco)) {
			elemento.remove(codiceUnivoco);
		} else {
			throw new Exception("Codice univoco non presente nel catalogo");
		}
	}
	
	private static String ricercaxIsbn(String codiceUnivoco) {
		return elemento.get(codiceUnivoco);
	}
	
	private static String ricercaxPubblicazione(String annoPubblicazione) {
		Set<String> listaKey = elemento.keySet();
		String annopTrovata = null;
		for(String key : listaKey) {
		String pubblicazioneElemento = elemento.get(key);
			if(annoPubblicazione.equals(pubblicazioneElemento)) {
				annopTrovata = key;
					break;
			}
		
		} return annopTrovata;
	}

	private static String ricercaxAutore(String autore) {
		Set<String> listaKey = elemento.keySet();
		String autoreTrovato = null;
		for(String key : listaKey) {
		String autoreElemento = elemento.get(key);
			if(autore.equals(autoreElemento)) {
				autoreTrovato = key;
					break;
			}
			
		} return autoreTrovato;

	}
	
	private static void stampaElementi() {
		System.out.println("Catalogo Bibliotecario");
		for (String key : elemento.keySet()) {
			System.out.println("ISBN: " + key + "Titolo: " + key + "Anno pubblicazione: " + key + "Numero pagine: " + key);
		}
	}
	
	public static void registraElementi(List<CatalogoBibliotecario> catalogoBibliotecario) throws IOException {
		String elementoTxt = "";
		for(CatalogoBibliotecario e : catalogoBibliotecario) {
			elementoTxt += (e.getCodiceUnivoco() + " " + e.getTitolo() + " " + e.getAnnoPubblicazione() + " " + e.getNumeroPagine());
		}
		FileUtils.writeStringToFile(file, elementoTxt, "UTF-8");
		System.out.println("Elementi correttamente salvati nel catalogo");
	}
	
	public static void leggiElementi() throws IOException {
		catalogoBibliotecario.clear();
		String codiceUnivoco = "";
		String titolo = "";
		String annoPubblicazione = "";
		int numeroPagine = 0;
		String txtFile = FileUtils.readFileToString(file, "UTF-8");
		String[] objTxt = txtFile.split(" ");
		CatalogoBibliotecario e =  new CatalogoBibliotecario(codiceUnivoco, titolo, annoPubblicazione, numeroPagine);
		catalogoBibliotecario.add(e);
	}
	
}
