package it.epicode.gi.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import it.epicode.gi.CentroControlloProxy;
import it.epicode.gi.SondaData;

public class CentroControlloTest extends CentroControlloProxy {

	@Override
	public void check(SondaData info) {
		assertNotNull(info);
		assertNotNull(info.getIdSonda());
		assertNotNull(info.getLatitude());
		assertNotNull(info.getLongitude());
		assertNotNull(info.getSmokeLevel());
		assertNotEquals(0L, info.getSmokeLevel());
		throw new RuntimeException("Incendio Rilevato");
	}

}
