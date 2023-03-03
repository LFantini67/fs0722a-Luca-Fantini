package dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Tessera_Utente;
import model.Utente;
import model.Biglietteria.Biglietteria;
import model.Biglietteria.RivenditoreAutomatico;
import model.Biglietteria.RivenditoreAutorizzato;
import model.Ticket.Abbonamento;
import model.Ticket.Biglietto;
import model.Ticket.Periodicita;
import model.Ticket.Ticket;

public class Biglietteria_Dao {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("BuildWeekJava1");
	static EntityManager em = emf.createEntityManager();

	public static void aggiungiBiglietteria(Biglietteria big) {
		try {
			em.getTransaction().begin();
			em.persist(big);
			em.getTransaction().commit();
			System.out.println("Biglietteria aggiunta con successo");
		}
		finally {
			em.close();
		}
	
	}
	public static void contaBiglietti(Biglietteria biglietteria) {
		Query q = em.createQuery("SELECT b FROM Biglietto b WHERE b.biglietteria = :id");
		q.setParameter("id", biglietteria.getId());
		List<Biglietto> biglietti = q.getResultList();
		System.out.println("Biglietti emessi dalla biglietteria n°: " + biglietteria.getId());		
		for(Biglietto b : biglietti) {
			System.out.println(b);
		}
	}
	public static void contaAbbonamenti(Biglietteria biglietteria) {
		Query q = em.createQuery("SELECT a FROM Biglietto a WHERE a.biglietteria = :id");
		q.setParameter("id", biglietteria.getId());
		List<Abbonamento> abbonamenti = q.getResultList();
		System.out.println("Abbonamenti emessi dalla biglietteria n°: " + biglietteria.getId());		
		for(Abbonamento b : abbonamenti) {
			System.out.println(b);
		}
	}
		public static Biglietto creaBiglietto(Biglietteria big, Tessera_Utente id) {
			EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("BuildWeekJava1");
			EntityManager em1 = emf1.createEntityManager();
			
				Biglietto b = new Biglietto();
				b.setBiglietteria(big);
				b.setDataEmissione(new Date());
				b.setTessera_utente(id);
				big.setContaBigliettiEmessi(big.getContaBigliettiEmessi()+1);
				em1.getTransaction().begin();
				em1.persist(b);
				em1.getTransaction().commit();

				System.out.println("Biglietto creato con successo");
				em1.close();
				return b;
		
		}
		public static Abbonamento creaAbbonamento(Biglietteria big, Tessera_Utente id, Periodicita p) {
			EntityManagerFactory emf1= Persistence.createEntityManagerFactory("BuildWeekJava1");
		    EntityManager em1=emf1.createEntityManager();
			try {
				Abbonamento a = new Abbonamento();
				a.setBiglietteria(big);
				a.setDataEmissione(new Date());
				a.setTessera_utente(id);
				a.setPeriodicita(p);
				big.setContaBigliettiEmessi(big.getContaAbbonamentiEmessi()+1);
				if(a.getPeriodicita()==(Periodicita.SETTIMANALE)) {
					Calendar cal = Calendar.getInstance();
		    		cal.setTime(a.getDataEmissione());
		            cal.add(Calendar.HOUR, 168);
		            Date data2 = cal.getTime();
		            a.setDataScadenza(data2);
				}else if(a.getPeriodicita()==(Periodicita.MENSILE)) {
					Calendar cal = Calendar.getInstance();
		    		cal.setTime(a.getDataEmissione());
		            cal.add(Calendar.MONTH, 1);
		            Date data2 = cal.getTime();
		            a.setDataScadenza(data2);
				}
				em1.getTransaction().begin();
				em1.persist(a);
				em1.getTransaction().commit();
				
				System.out.println("Abbonamento creato con successo");
				return a;
			} catch (Exception err) {
				em1.getTransaction().rollback();
				System.out.println(err.getMessage());
			} finally {
				em1.close();
			}
			return null;
		}

		public static Tessera_Utente creaTessera(Biglietteria big, Utente u){
			EntityManagerFactory emf1= Persistence.createEntityManagerFactory("BuildWeekJava1");
		    EntityManager em1=emf1.createEntityManager();
			try {
				Tessera_Utente tu = new Tessera_Utente();
				tu.setUtente(u);
				tu.setDataEmissione(new Date());
				u.setTessera(tu);
				em1.getTransaction().begin();
				em1.persist(tu);
				em1.getTransaction().commit();
				Tessera_Dao.scadenza(tu);
				System.out.println("Tessera Creata con successo");
				return tu;
			}
			finally {
				em.close();
			}

		}
		public static RivenditoreAutorizzato creaAutorizzato() {
			EntityManagerFactory emf1= Persistence.createEntityManagerFactory("BuildWeekJava1");
		    EntityManager em1=emf1.createEntityManager();
			try {
				em1.getTransaction().begin();
				RivenditoreAutorizzato ra= new RivenditoreAutorizzato();
				em1.persist(ra);
				em1.getTransaction().commit();
				return ra;
			}finally {
				em1.close();
			}
		}
		
		public static void controllaAbbonamento(Tessera_Utente t) {
			EntityManagerFactory emf1= Persistence.createEntityManagerFactory("BuildWeekJava1");
		    EntityManager em1=emf1.createEntityManager();
		    em1.getTransaction().begin();
			TypedQuery<Abbonamento> q = (TypedQuery<Abbonamento>) em1.createQuery("SELECT  a FROM Abbonamento a WHERE a.tessera_utente = :id");
			q.setParameter("id",t);
			Abbonamento a = q.getSingleResult();
			long res= a.getDataScadenza().getTime()-a.getDataEmissione().getTime();
			if(res<=0) {
				System.out.println("Il tuo abbonamento è scaduto!");
			}else {
				System.out.println("Il tuo abbonamento scadrà il :" + a.getDataScadenza());

			}
			em1.close();
			}
		}


