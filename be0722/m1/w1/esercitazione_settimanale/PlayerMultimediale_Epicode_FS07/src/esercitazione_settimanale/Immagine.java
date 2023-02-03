package esercitazione_settimanale;

import java.util.Scanner;

public class Immagine extends ElementoMultimediale implements Luminosita {
	
	private int luminosita;
	
	public Immagine(String elemento, int luminosita) {
		super(elemento);
		this.luminosita = luminosita;
		
	}
	
	public void apportaModifiche(Scanner in) {
		int luminosita;
		System.out.println("Imposta la nuova luminosità per: " + getElemento());
		luminosita = in.nextInt();
		in.nextLine();
		if(this.luminosita > luminosita) {
			diminuisciLuminosita(luminosita);
		} else {
			aumentaLuminosita(luminosita);
		}
		
	}
	
	public void show() {
		String asterisco = "";
		
		for(int i = 0; i < this.luminosita; i++) {
			asterisco += "*";
		}
		
		System.out.println(getElemento() + " " + asterisco);
		
	}

	@Override
	public void aumentaLuminosita(int aumenta) {
		// TODO Auto-generated method stub
		
		if(aumenta > this.luminosita) {
			this.luminosita = aumenta;
		} else {
			
			System.out.println("Hai inserito una luminosità minore o uguale");
			
		}
		
	}

	@Override
	public void diminuisciLuminosita(int diminuisci) {
		// TODO Auto-generated method stub
		
		if(diminuisci > this.luminosita) {
			this.luminosita = diminuisci;
		} else {
			
			System.out.println("Hai inserito una luminosità maggiore o uguale");
			
		}
		
	}

}
