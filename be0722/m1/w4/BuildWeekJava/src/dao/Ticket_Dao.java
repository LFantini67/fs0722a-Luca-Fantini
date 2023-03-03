package dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Ticket.Ticket;

public class Ticket_Dao {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("BuildWeekJava1");
	static EntityManager em = emf.createEntityManager();

	public static void aggiungiTicket(Ticket ticket) {
		EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("BuildWeekJava1");
		EntityManager em1 = emf1.createEntityManager();
		try {
			em1.getTransaction().begin();
			em1.persist(ticket);
			em1.getTransaction().commit();

			System.out.println("Ticket aggiunto con successo");
		} catch (Exception err) {
			em1.getTransaction().rollback();
			System.out.println(err.getMessage());
		} finally {
			em1.close();
		}
	}

	public static Ticket controllaTicketbyId(List<Ticket> t, Long identificativo) {
		Ticket risultato = null;
		for (int i = 0; i < t.size(); i++) {
			Ticket ticket = t.get(i);
			if (ticket.getId() == identificativo) {
				risultato = ticket;
				break;
			} else {
				System.out.println("biglietto non trovato");
			}
		}
		return risultato;
	}

	public static void scadenza(Ticket tu) {
		EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("BuildWeekJava1");
		EntityManager em1 = emf1.createEntityManager();
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(tu.getDataEmissione());
			cal.add(Calendar.MINUTE, 90);
			Date data2 = cal.getTime();
			tu.setDataScadenza(data2);
			em1.getTransaction().begin();
			em1.merge(tu);
			em1.getTransaction().commit();
			System.out.println("Il biglietto scade tra 90 minuti " + tu.getDataScadenza());
		} catch (Exception err) {
			em1.getTransaction().rollback();
			System.out.println(err.getMessage());
		} finally {
			em1.close();
		}
	}

}
