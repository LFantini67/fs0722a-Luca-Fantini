package it.epicode.gi.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.function.Executable;

import it.epicode.gi.CentroControlloInterface;
import it.epicode.gi.CentroControlloProxy;
import it.epicode.gi.ControlloSonda;
import it.epicode.gi.Sonda;

public class GestioneIncendiTest {

	CentroControlloInterface centroControllo;

	@Before
	public void setUp() {
		this.centroControllo = new CentroControlloProxy();
	}

	@Test
	public void testRegistraControlloSonda() {

		ControlloSonda controllo1 = new ControlloSonda(1L, centroControllo);

		Sonda sonda1 = new Sonda(1L, 11.22, 24.22);

		sonda1.addObserver(controllo1);

		assertTrue(sonda1.getObservers().contains(controllo1));

	}

	@Test
	public void testDeRegistraControlloSonda() {

		ControlloSonda controllo1 = new ControlloSonda(1L, centroControllo);
		Sonda sonda1 = new Sonda(1L, 11.22, 24.22);
		sonda1.addObserver(controllo1);
		assertTrue(sonda1.getObservers().contains(controllo1));

		sonda1.removeObserver(controllo1);
		assertTrue(!sonda1.getObservers().contains(controllo1));

	}

	@Test
	public void testFumoSopraSoglia() {
		CentroControlloInterface centroControlloTest = new CentroControlloTest();

		ControlloSonda controllo1 = new ControlloSonda(1L, centroControlloTest);
		Sonda sonda1 = new Sonda(1L, 11.22, 24.22);
		sonda1.addObserver(controllo1);

		Executable execute = new org.junit.jupiter.api.function.Executable() {

			@Override
			public void execute() throws Throwable {
				sonda1.setSmokeLevel(7);

			}
		};

		assertThrows(RuntimeException.class, execute);

	}

	@Test
	public void testFumoSottoSoglia() {
		CentroControlloInterface centroControlloTest = new CentroControlloTest();

		ControlloSonda controllo1 = new ControlloSonda(1L, centroControlloTest);
		Sonda sonda1 = new Sonda(1L, 11.22, 24.22);
		sonda1.addObserver(controllo1);

		Executable execute = new org.junit.jupiter.api.function.Executable() {

			@Override
			public void execute() throws Throwable {
				sonda1.setSmokeLevel(4);

			}
		};

		assertDoesNotThrow(execute);

	}

}
