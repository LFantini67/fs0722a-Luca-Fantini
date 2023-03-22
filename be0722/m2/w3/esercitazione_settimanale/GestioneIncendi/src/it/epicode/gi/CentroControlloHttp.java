package it.epicode.gi;

public class CentroControlloHttp implements CentroControlloInterface {
	private CanaleComunicazioneHttp canaleComunicazione;
	private static final String baseUrlNotifica = "http://host/alarm";

	public CentroControlloHttp() {
		this.canaleComunicazione = new CanaleComunicazioneHttp(baseUrlNotifica);
	}

	@Override
	public void check(SondaData sondaData) {

		canaleComunicazione.sendUrl(sondaData.getIdSonda(), sondaData.getLatitude(), sondaData.getLongitude(), sondaData.getSmokeLevel());

	}

}
