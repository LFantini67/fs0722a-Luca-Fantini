package it.epicode.gi;

public class CentroControlloFactory {

	public static CentroControlloInterface creaCentroControllo(int type) {

		switch (type) {
		case 0:
			return new CentroControlloHttp();
		default:
			throw new RuntimeException("Tipologia non accettata");
		}

	}

}
