package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Biglietteria.RivenditoreAutomatico;
import model.Biglietteria.Stato;

public class Automatico_Dao {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("BuildWeekJava1");
	static EntityManager em = emf.createEntityManager();
	
	public static void cambiaStato(RivenditoreAutomatico au) {
		
		try {			
			if(au.getStato()== Stato.ATTIVO) {
				au.setStato(Stato.FUORI_SERVIZIO);
			}else if(au.getStato() == Stato.FUORI_SERVIZIO) {
				au.setStato(Stato.ATTIVO);
			}
			em.getTransaction().begin();
			em.merge(au);
			em.getTransaction().commit();
			
			System.out.println("Stato biglietteria cambiato correttamente");
		}catch(Exception err) {
			em.getTransaction().rollback();
			System.out.println(err.getMessage());
		}finally {
			em.close();
		}
	}
	
	public static RivenditoreAutomatico crea() {
		try {
			em.getTransaction().begin();
			RivenditoreAutomatico ra= new RivenditoreAutomatico();
			em.persist(ra);
			em.getTransaction().commit();
			return ra;
		}finally {
			em.close();
		}
	}
}
