package it.epicode.gi;

public class CentroControlloProxy implements CentroControlloInterface {

	private CentroControlloInterface concreteCentroControllo;

	public CentroControlloProxy() {
		concreteCentroControllo = CentroControlloFactory.creaCentroControllo(1);
	}

	@Override
	public void check(SondaData sondaData) {
		concreteCentroControllo.check(sondaData);
	}

}
