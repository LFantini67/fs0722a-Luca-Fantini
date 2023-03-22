package it.epicode.gi;

public class ControlloSonda implements Observer {

	private final Long id;

	private CentroControlloInterface centroControllo;

	public ControlloSonda(Long id, CentroControlloInterface centroControllo) {
		this.id = id;
		this.centroControllo = centroControllo;
	}

	@Override
	public void update(Subject obj) {
		SondaData info = createInfoSonda((Sonda) obj);
		centroControllo.check(info);
	}

	private SondaData createInfoSonda(Sonda obj) {
		return new SondaData(obj.getId(), obj.getLatitude(), obj.getLongitude(), obj.getSmokeLevel());
	}

	public Long getId() {
		return id;
	}

}
