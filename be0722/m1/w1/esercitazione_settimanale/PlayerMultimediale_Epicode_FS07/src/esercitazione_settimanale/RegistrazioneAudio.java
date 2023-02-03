package esercitazione_settimanale;

import java.util.Scanner;

public class RegistrazioneAudio extends ElementoMultimediale implements Volume {
	
	private int volume;
	private int durata;
	
	public RegistrazioneAudio(String elemento, int volume, int durata) {
		
		super(elemento);
		this.volume = volume;
		this.durata = durata;
		
	}
	
	public void start() {
		play();
	}
	
	public void apportaModifiche(Scanner in) {
		int volume = 0;
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
		String puntoEsclamativo = "";
		String durata = "";
		
		for(int i = 0; i < this.volume; i++) {
			puntoEsclamativo += "!";
		}
		for(int i = 0; i < this.durata; i++) {
			durata += getElemento();
		}
		
		System.out.println(durata + " " + puntoEsclamativo);
		
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
