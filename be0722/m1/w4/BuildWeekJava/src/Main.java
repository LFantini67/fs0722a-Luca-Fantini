

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.Automatico_Dao;
import dao.Biglietteria_Dao;
import dao.Mezzo_Dao;
import dao.Tessera_Dao;
import dao.Utente_Dao;
import model.Tessera_Utente;
import model.Utente;
import model.Biglietteria.Biglietteria;
import model.Biglietteria.RivenditoreAutomatico;
import model.Biglietteria.RivenditoreAutorizzato;
import model.Biglietteria.Stato;
import model.Mezzo.Autobus;
import model.Mezzo.Mezzo;
import model.Mezzo.Tram;
import model.Mezzo.Tratta;
import model.Mezzo.disponibilita;
import model.Ticket.Abbonamento;
import model.Ticket.Biglietto;
import model.Ticket.Periodicita;
import model.Ticket.Ticket;

public class Main {
	
	//static EntityManagerFactory emf= Persistence.createEntityManagerFactory("BuildWeekJava1");
    //static EntityManager em=emf.createEntityManager();
	static List<Ticket> ti = new ArrayList<>();

	   
	    public static void main(String[] args) {
	    	//CREAZIONE UTENTE
	    	Utente u = Utente_Dao.creaUtente("Mario", "Gialli");
	    	Utente u1 = Utente_Dao.creaUtente("Franco", "Rossi");
	    	//CREAZIONE RIVENDITORI
	    	RivenditoreAutomatico ra= Automatico_Dao.crea();
	    	RivenditoreAutorizzato rb= Biglietteria_Dao.creaAutorizzato();
	    	//CREAZIONE TRATTA
	    	Tratta t=Mezzo_Dao.creaTratta("Termini","Colosseo",30);
	    	Tratta t1=Mezzo_Dao.creaTratta("Colombo","Piramide",60);
	    	//CREAZIONE MEZZI
	    	Autobus a= Mezzo_Dao.creaAutobus(t);
	    	Tram tra = Mezzo_Dao.creaTram(t1);
	    	//CREAZIONE TESSERA UTENTI
	    	Tessera_Utente tr= Biglietteria_Dao.creaTessera(ra, u);
	    	Tessera_Utente tr2= Biglietteria_Dao.creaTessera(rb, u1);
	    	//CREAZIONE BIGLIETTI
	    	Biglietto b= Biglietteria_Dao.creaBiglietto(ra, tr);
	    	Biglietto b1= Biglietteria_Dao.creaBiglietto(rb, tr);
	    	Biglietto b2= Biglietteria_Dao.creaBiglietto(ra, tr);

	    	//CREAZIONE ABBONAMENTI
	    	Abbonamento abb = Biglietteria_Dao.creaAbbonamento(rb, tr, Periodicita.MENSILE);
	    	Abbonamento abb1 = Biglietteria_Dao.creaAbbonamento(ra, tr2, Periodicita.SETTIMANALE);
	    	//CONTROLLO VALIDITA ABBONAMENTO
	    	Biglietteria_Dao.controllaAbbonamento(tr2);
	    	Biglietteria_Dao.controllaAbbonamento(tr);
	    	//CONTROLLA SE é IN SERVIZIO E CAMBIA STATUS
	    	System.out.println("L'autobus è "+a.getDisponibilita());
	    	System.out.println("Il tram è "+tra.getDisponibilita());
	    	Mezzo_Dao.cambiaStatus(tra, 100);
	    	//CONVALIDAZIONE BIGLIETTO
	    	Mezzo_Dao.convalidaTicket(b, a);
	    	Mezzo_Dao.convalidaTicket(b1, tra);
	    	Mezzo_Dao.convalidaTicket(b2, tra);
	    	//BIGLIETTI CONVALIDATI
	    	String d1 = "2022-10-10";
	    	Date dd1=null;
	    	Date dd2=null;

	    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	    	try {
				dd1= sdf.parse(d1);
				System.out.println(dd1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	String d2 = "2023-04-04";
	    	SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd");
	    	try {
				dd2= sdf.parse(d2);
				System.out.println(dd2);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    	Mezzo_Dao.ticketControllatiTempo(tra, dd1, dd2);;
	    	//BIGLIETTI CONVALIDATI TOTALI
	    	Mezzo_Dao.ticketTotali();
	    	//PARTENZE VEICOLI
	    	
	    	Mezzo_Dao.partenzaMezzo(tra, "2023-02-20");
	    	//CONTA QUANTI GIRI SONO STATI FATTI
	    	Mezzo_Dao.contaGiri(tra);
	    	

	    	
	    	
	    	
	    	
	    	
	}
	
	
}
