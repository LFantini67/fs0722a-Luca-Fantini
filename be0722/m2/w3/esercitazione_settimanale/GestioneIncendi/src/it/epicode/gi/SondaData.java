package it.epicode.gi;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SondaData {

	private Long idSonda;
	private double latitude;
	private double longitude;
	private int smokeLevel;

}
