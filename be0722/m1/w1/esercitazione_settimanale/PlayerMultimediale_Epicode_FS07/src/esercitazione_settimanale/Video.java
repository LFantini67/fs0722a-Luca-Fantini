package esercitazione_settimanale;

import java.util.Scanner;

public class Video extends ElementoMultimediale implements Volume, Luminosita {
	
	private int luminosita;
	private int volume;
	private int durata;
	
	public Video(String elemento, int luminosita, int volume, int durata) {
		super(elemento);
		this.luminosita = luminosita;
		this.volume = volume;
		this.durata = durata;
		
	}
	
	public void start() {
		play();
	}
	
	public void apportaModifiche(Scanner in) {
		int luminosita, volume;
		System.out.println("Imposta la nuova luminosità per: " + getElemento());
		luminosita = in.nextInt();
		in.nextLine();
		if(this.luminosita > luminosita) {
			diminuisciLuminosita(luminosita);
		} else {
			aumentaLuminosita(luminosita);
		}
		
		System.out.println("Imposta il nuovo volume per: " + getElemento());
		volume = in.nextInt();
		in.nextLine();
		if(this.volume > volume) {
			abbassaVolume(volume);
		} else {
			alzaVolume(volume);
		}
		
	}
	
	public void play() {
		String asterisco = "";
		String puntoEsclamativo = "";
		String durata = "";
		
		for(int i = 0; i < this.luminosita; i++) {
			asterisco += "*";
		}
		for(int i = 0; i < this.volume; i++) {
			puntoEsclamativo += "!";
		}
		for(int i = 0; i < this.durata; i++) {
			durata += getElemento();
		}
		
		System.out.println(durata + " " + puntoEsclamativo + " " + asterisco);
		
	}

	@Override
	public void aumentaLuminosita(int aumenta) {
		// TODO Auto-generated method stub
		
		this.luminosita = aumenta;
		
	}

	@Override
	public void diminuisciLuminosita(int diminuisci) {
		// TODO Auto-generated method stub
		
		this.luminosita = diminuisci;
		
	}

	@Override
	public void abbassaVolume(int abbassa) {
		// TODO Auto-generated method stub
		
		this.volume = abbassa;
		
	}

	@Override
	public void alzaVolume(int alza) {
		// TODO Auto-generated method stub
		
		this.volume = alza;
		
	}
	
}