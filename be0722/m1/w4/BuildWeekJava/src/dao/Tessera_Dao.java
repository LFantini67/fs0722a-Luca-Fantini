package dao;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Tessera_Utente;
import model.Utente;

public class Tessera_Dao {
	static EntityManagerFactory emf= Persistence.createEntityManagerFactory("BuildWeekJava1");
    static EntityManager em=emf.createEntityManager();
    
    public static void aggiungiTessera(Tessera_Utente tu) {
		try {			
			em.getTransaction().begin();
			em.persist(tu);
			em.getTransaction().commit();
			scadenza(tu);
			System.out.println("Tessera aggiunto con successo");
		}catch(Exception err) {
			em.getTransaction().rollback();
			System.out.println(err.getMessage());
		}finally{
			em.close();
		}
    }
    public static void scadenza(Tessera_Utente tu) {
    	EntityManagerFactory emf1= Persistence.createEntityManagerFactory("BuildWeekJava1");
	    EntityManager em1=emf1.createEntityManager();
    	try {
    		Calendar cal = Calendar.getInstance();
    		cal.setTime(tu.getDataEmissione());
            cal.add(Calendar.YEAR, 1);
            Date data2 = cal.getTime();
            tu.setDataScadenza(data2);
			em1.getTransaction().begin();
			em1.merge(tu);
			em1.getTransaction().commit();
			
			System.out.println("Data aggiunta correttamente");

		}finally{
			em1.close();
		}
    }
    public static void rinnova(Tessera_Utente tu) {
    	try {
    		Calendar cal = Calendar.getInstance();
    		cal.setTime(new Date());
            cal.add(Calendar.YEAR, 1);
            Date data2 = cal.getTime();
            tu.setDataScadenza(data2);
			em.getTransaction().begin();
			em.merge(tu);
			em.getTransaction().commit();
			
			System.out.println("Data rinnovata correttamente");
		}catch(Exception err) {
			em.getTransaction().rollback();
			System.out.println(err.getMessage());
		}finally{
			em.close();
		}
    }
    public static Tessera_Utente getTessera(Long id) {
			Query q = em.createQuery("SELECT t FROM Tessera_Utente t WHERE t.id_tessera = :id");
			q.setParameter("id",id);
			Tessera_Utente r = (Tessera_Utente) q.getSingleResult();
			
			System.out.println("tessera trovata con successo" + r);
			return r;
	
		}
    public static void eliminaDaId(Long id) {
    	try {
    		
			em.getTransaction().begin();
			Utente u = em.find(Utente.class, id);
			em.remove(u);
			em.getTransaction().commit();
			System.out.println("Utente eliminato");
			
		}catch(Exception err) {
			em.getTransaction().rollback();
			System.out.println(err.getMessage());
		}finally{
			em.close();
		}
	}
    
}
