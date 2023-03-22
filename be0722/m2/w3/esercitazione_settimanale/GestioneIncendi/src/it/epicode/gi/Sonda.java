package it.epicode.gi;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sonda extends Subject {

	private Long id;
	private double latitude;
	private double longitude;
	private int smokeLevel = 0;

	public Sonda(Long id, double latitude, double longitude) {
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public void setSmokeLevel(int smokeLevel) {
		this.smokeLevel = smokeLevel;

		if (smokeLevel > 5) {
			super.notifyObservers();
		}
	}

}
