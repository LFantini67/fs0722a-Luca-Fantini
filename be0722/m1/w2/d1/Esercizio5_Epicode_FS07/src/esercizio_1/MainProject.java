package esercizio_1;

import java.util.Random;
import java.util.Scanner;

public class MainProject {
	
	static int[] arr = new int[5];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		numeroCasuale();
		stampaArray();
		inserisciDaScanner();
		System.out.print("FINE");

	}
	
	public static void numeroCasuale() {
		Random n = new Random();
		for(int i = 0; i < arr.length; i++) {
			arr[i] = n.nextInt(11);
		}
	}
	
	public static void stampaArray() {
		System.out.print("Stampa Array");
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void inserisciDaScanner() {
		Scanner sc = new Scanner(System.in);
		do {
			try {
		System.out.print("Inserisci un numero: ");
		int numero = Integer.parseInt(sc.nextLine());
		System.out.print("Scegline la posizione: ");
		int posizione = Integer.parseInt(sc.nextLine());
		if(numero == 0) {
			return;
		}
		arr[posizione] = numero;
		stampaArray();
			} catch (NumberFormatException e) {
				System.out.println("Numero non valido");
			}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Indice Array non valido");
			}
		} while(true);
		
	}

}
