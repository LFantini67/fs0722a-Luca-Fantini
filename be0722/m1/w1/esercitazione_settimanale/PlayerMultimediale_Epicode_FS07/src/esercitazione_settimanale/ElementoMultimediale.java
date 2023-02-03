package esercitazione_settimanale;

import java.util.Scanner;

public abstract class ElementoMultimediale {
	
	private String elemento;
	
	public ElementoMultimediale(String elemento) {
		this.elemento = elemento;
	}
	
	public String getElemento() {
		return elemento;
	}
	
	public void setElemento(String elemento) {
		this.elemento = elemento;
	}
	
	public void start() {
		
	}
	
	public void apportaModifiche(Scanner in) {
		
	}

}
