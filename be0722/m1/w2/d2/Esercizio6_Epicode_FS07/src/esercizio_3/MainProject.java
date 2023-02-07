package esercizio_3;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainProject {
	
	private static java.util.logging.Logger log = LoggerFactory.getLogger(MainProject.class);
	private static Scanner sc = new Scanner(System.in);
	private static Random rdm = new Random();
	private static List<Integer> numeri;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Inserire un intero N: ");
		int n = Integer.parseInt(sc.nextLine());
		numeri = creaListaNumeri(n);
		stampaLista(numeri);
		log.info("------------");
		List<Integer> numeriSpeculari = listaSpeculare(numeri);
		stampaLista(numeriSpeculari);
		log.info("------------");
		stampaValori(numeri, true);

	}
	
	private static List<Integer> creaListaNumeri(int n) {
		List<Integer> lista = new ArrayList<Integer>;
		for(int i = 0; i < n; i++) {
			lista.add(rdm.nextInt(101));
		}
		return lista;
	}
	
	private static List<Integer> listaSpeculare(List<Integer> listaOriginale) {
		List<Integer> lista = new ArrayList<Integer>(listaOriginale);
		for(int i = listaOriginale.size() - 1; i >= 0; i--) {
			lista.add(listaOriginale.get(i));
		}
		return lista;
		
	}
	
	private static void stampaValori(List<Integer> lista, boolean b) {
		if(b) {
			//true
			for(int i = 0; i < lista.size(); i = i + 2) {
				log.info("Key: " + i + "Valore: " + lista.get(i));
			}
		} else {
			//false
			for(int i = 0; i < lista.size(); i++) {
				if(i % 2 != 0) {
					log.info("Key: " + i + "Valore: " + lista.get(i));
				}
			}
		}
		
	}
	
	private static void stampaLista(List<Integer> lista) {
		for(Integer num : lista) {
			log.info("Valore: " + num);
		}
	}

}
