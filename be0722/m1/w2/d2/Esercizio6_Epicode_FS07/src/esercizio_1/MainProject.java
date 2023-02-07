package esercizio_1;

import java.util.Scanner;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainProject {
	
	private static java.util.logging.Logger log = LoggerFactory.getLogger(MainProject.class);
	private static Scanner sc = new Scanner(System.in);
	private static Set<String> parole = new HashSet<String>();
	private static Set<String> paroleDuplicate = new HashSet<String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Inserire un intero N: ");
		int n = Integer.parseInt(sc.nextLine());
		
		if(n > 0) {
			for(int i = 0; i < n; i++) {
				System.out.println("Inserire una parola: ");
				String parola = sc.nextLine();
				boolean agg = parole.add(parola);
				
				if(!agg) {
					paroleDuplicate.add(parola);
				log.info("Parola duplicata: " + agg);
				}
			}
			
			log.info("N° Parole: " + parole.size());
			
			for(String p : parole) {
				log.info("Elenco parole: " + p);
			}

		}

	}

}
