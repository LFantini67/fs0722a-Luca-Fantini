package esercizio_2;

import java.util.Scanner;

public class MainProject {
	
	static Scanner sc = new Scanner(System.in);
	static int km;
	static int litri;
	static int distanza;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Inserisci i km percorsi: ");
		km = Integer.parseInt(sc.nextLine());
		System.out.println("Inserisci i litri di benzina consumati: ");
		litri = Integer.parseInt(sc.nextLine());
		try {
		distanza = km / litri;
		} catch (ArithmeticException e) {
			System.out.println("Non puoi dividere per 0");
		} catch (NumberFormatException e) {
			System.out.println("Numero non valido");
		} catch (Exception e) {
			System.out.println("Altro problema");
		}
		
		System.out.println(distanza);

	}

}
