package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Utente;

public class Utente_Dao {
	static EntityManagerFactory emf= Persistence.createEntityManagerFactory("BuildWeekJava1");
    static EntityManager em=emf.createEntityManager();
    
    public static void aggiungiUtente(Utente utente) {
		try {			
			em.getTransaction().begin();
			em.persist(utente);
			em.getTransaction().commit();
			
			System.out.println("Utente aggiunto con successo");
		}catch(Exception err) {
			em.getTransaction().rollback();
			System.out.println(err.getMessage());
		}finally{
			em.close();
		}
		}
    public static Utente getUtente(Long id) {
			Query q = em.createQuery("SELECT u FROM Utente u WHERE u.id_utente = :id");
			q.setParameter("id",id);
			Utente r = (Utente) q.getSingleResult();
			
			System.out.println("Utente trovato con successo" + r);
			return r;
	
		}

    
    public static void deleteFromIsbn(Long id) {
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
    
    public static Utente creaUtente(String nome, String cognome) {
    	EntityManagerFactory emf1= Persistence.createEntityManagerFactory("BuildWeekJava1");
        EntityManager em1=emf1.createEntityManager();
    	try {
    		em1.getTransaction().begin();
    		Utente u= new Utente();
    		u.setCognome(cognome);
    		u.setNome(nome);
    		em1.persist(u);
    		em1.getTransaction().commit();
    		return u;
    	}finally {
    		em1.close();
    	}
    
    }
    
}
