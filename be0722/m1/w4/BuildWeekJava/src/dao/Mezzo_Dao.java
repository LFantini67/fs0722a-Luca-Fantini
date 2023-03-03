package dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Mezzo.Autobus;
import model.Mezzo.Mezzo;
import model.Mezzo.Tram;
import model.Mezzo.Tratta;
import model.Mezzo.disponibilita;
import model.Ticket.Ticket;

public class Mezzo_Dao {
	static EntityManagerFactory emf= Persistence.createEntityManagerFactory("BuildWeekJava1");
    static EntityManager em=emf.createEntityManager();
    
    public static void convalidaTicket(Ticket t, Mezzo m) {
    	EntityManagerFactory emf1= Persistence.createEntityManagerFactory("BuildWeekJava1");
        EntityManager em1=emf1.createEntityManager();
    	try {    		
    		em1.getTransaction().begin();
    	if(t.getConvalidato()== false) {
    		t.setConvalidato(true);
    		Ticket_Dao.scadenza(t);
    		m.setBigliettiConvalidati(m.getBigliettiConvalidati()+1);
    		t.setMezzo_id(m);
    		t.setDataConvalida(new Date());
    		List<Ticket> tt= m.getTicketes();
    		tt.add(t);
    		m.setTicketes(tt);
    		em1.merge(t);
    		em1.merge(m);
    		  em1.getTransaction().commit();
    		 
    	}else {
    		System.out.println("Biglietto già convalidato");
    	}
     	}finally {
     		em1.close();
     	}
    }
    public static void cambiaStatus(Mezzo m, int i) {
    	EntityManagerFactory emf1= Persistence.createEntityManagerFactory("BuildWeekJava1");
        EntityManager em1=emf1.createEntityManager();
    	try {
    		em1.getTransaction().begin();
    	if(m.getDisponibilita() == disponibilita.MANUTENZIONE) {
    		m.setDisponibilita(disponibilita.OPERATIVO);
    		m.setPeriodoManutenzione(i);
    		System.out.println("Il veicolo è in servizio, è stato in manutenzione per: " + i + "ore");
    		em1.merge(m);
    		  em1.getTransaction().commit();
    	}else if(m.getDisponibilita() == disponibilita.OPERATIVO){
    		m.setDisponibilita(disponibilita.MANUTENZIONE);
    		System.out.println("Il veicolo è in manutenzione, è rimasto in servizio per:" + i + "ore");
    		m.setPeriodoServizio(i);
    		em1.merge(m);
    		  em1.getTransaction().commit();
    	}
    	}
    	finally {
    		em1.close();
    	}
    }
    public static void cambiaTratta(Mezzo m, Tratta t) {
    	EntityManagerFactory emf1= Persistence.createEntityManagerFactory("BuildWeekJava1");
        EntityManager em1=emf1.createEntityManager();
    	try {
    		em1.getTransaction().begin();
    		Long x = (long) m.getId();
    		em1.getTransaction().begin();
    		Query q = em1.createQuery("UPDATE Mezzo m SET m.idTratta = :id WHERE m.id = :id2");
    		q.setParameter("id", t);
    		q.setParameter("id2", x);
    		q.executeUpdate();
    		em1.getTransaction().commit();
    	}
    	finally {
    		em1.close();
    	}
    	}
    public static void contaGiri(Mezzo m) {
    	EntityManagerFactory emf1= Persistence.createEntityManagerFactory("BuildWeekJava1");
        EntityManager em1=emf1.createEntityManager();
    	try {
    		em1.getTransaction().begin();
    	Long x = (long) m.getId();
    	//Query q = em.createQuery("SELECT t.tempoPercorrenza FROM Tratta t WHERE t.mezzi = :id");
    	//SELECT i.citta FROM Utente u JOIN Indirizzo i ON u.indirizzoId = i.id WHERE u.id = :userId
    	
    	Query q = em1.createQuery("SELECT t.tempoPercorrenza FROM Tratta t JOIN Mezzo m ON t.id = m.idTratta WHERE m.id = :id");
    	q.setParameter("id", x);
    	int l = (int) q.getSingleResult();
    	Date o = new Date();
    	int o2 = (int) (o.getTime()- m.getPartenza().getTime());
    	int o3 = o2/3600000;  
    	double l2=l;
    	double y=l2/60;
    	double risultato = o3/y;
    	System.out.println("giri effettuati: " + risultato+ " per ogni giro: "+m.getIdTratta().getTempoPercorrenza() + " min");
    	m.setNumeroGiri(risultato);
		em1.merge(m);
		em1.getTransaction().commit();
    	}
    	finally {
    		em1.close();
    	}
	
	}
    public static void partenzaMezzo(Mezzo m,String v) {
    	EntityManagerFactory emf1= Persistence.createEntityManagerFactory("BuildWeekJava1");
        EntityManager em1=emf1.createEntityManager();
    	try {
    		em1.getTransaction().begin();
    		
	    	Date dd1=null;
	    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	    	try {
				dd1= sdf.parse(v);
				System.out.println(v);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		m.setPartenza(dd1);
		em1.merge(m);
		  em1.getTransaction().commit();
    	}finally {
    		em1.close();
    	}
	}
   
    public static Autobus creaAutobus(Tratta t) {
    	EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("BuildWeekJava1");
		EntityManager em1 = emf1.createEntityManager();
    	try {
    		
    		Autobus a= new Autobus();
    		a.setIdTratta(t);
    		a.setPartenza(new Date());
    		a.setDisponibilita(disponibilita.OPERATIVO);
    		em1.getTransaction().begin();
    		em1.persist(a);
    		em1.getTransaction().commit();
    		return a;
    	}
    	finally {
    		em1.close();
    	}
    }
    
    public static Tratta creaTratta(String zonaPartenza, String capolinea,int tempoPercorrenza) {
    	EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("BuildWeekJava1");
		EntityManager em1 = emf1.createEntityManager();
    	try {
    		em1.getTransaction().begin();
    		Tratta t= new Tratta();
    		t.setCapolinea(capolinea);
    		t.setTempoPercorrenza(tempoPercorrenza);
    		t.setZonaPartenza(zonaPartenza);
    		em1.persist(t);
    		em1.getTransaction().commit();
    		return t;
    	}finally {
    		em1.close();
    	}
    }
    
    public static Tram creaTram(Tratta t) {
    	EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("BuildWeekJava1");
		EntityManager em1 = emf1.createEntityManager();
    	try {
    		
    		Tram a= new Tram();
    		a.setIdTratta(t);
    		a.setDisponibilita(disponibilita.OPERATIVO);
    		a.setPartenza(new Date());
    		em1.getTransaction().begin();
    		em1.persist(a);
    		em1.getTransaction().commit();
    		return a;
    	}
    	finally {
    		em1.close();
    	}
    }
    public static void ticketControllatiTempo(Mezzo m,Date d,Date d2) {
    	int x=0;
    	for(Ticket t : m.getTicketes()) {
    		if(t.getDataConvalida().getTime()<d2.getTime() && t.getDataConvalida().getTime()>d.getTime()) {
    			x++;
    			
    		}
    	}
    	System.out.println("biglietti convalidati: "+x);
    	
    }
    public static void ticketTotali() {
     		EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("BuildWeekJava1");
    		EntityManager em1 = emf1.createEntityManager();
    		
    	TypedQuery<Mezzo> q = em1.createQuery("SELECT m FROM Mezzo m",Mezzo.class);
    	List<Mezzo> mezzi = q.getResultList();
    	int x=0;
    	for(Mezzo m: mezzi) {
    		x+=m.getBigliettiConvalidati();
    	}
    	System.out.println("Biglietti convalidati in totale: "+ x);
    }
}
