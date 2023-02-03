package esercitazione_settimanale;

import java.util.Scanner;

public class MainProject {

	static Scanner sc = new Scanner(System.in);
	static ElementoMultimediale[] elementi = new ElementoMultimediale[5];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		caricamentoArray(elementi);
		readArray(elementi);

	}

	public static ElementoMultimediale[] caricamentoArray(ElementoMultimediale[] arrX) {

		int i = 0;
		while (i < elementi.length) {
			System.out.print("Quale elemento multimediale vuoi inserire?");
			String r = sc.nextLine();

			switch (r) {
			case "immagine": {
				arrX[i] = inserisciImmagine();
				i++;
				break;
			}
			case "audio": {
				arrX[i] = inserisciAudio();
				i++;
				break;
			}
			case "video": {
				arrX[i] = inserisciVideo();
				i++;
				break;
			}
			default:
				System.out.println("Scelta non valida... (immagine-audio-video)");
				break;
			}

		}

		System.out.println("Caricamento completato");
		return arrX;

	}

	public static void readArray(ElementoMultimediale[] arrY) {

		System.out.println("Quale elemento multimediale vuoi riprodurre? da 1 a 5");

		int res = Integer.parseInt(sc.nextLine());
		while (res != 0) {
			if (res == 1) {
				if (arrY[res - 1] instanceof Video && arrY[res - 1] instanceof RegistrazioneAudio) {
					arrY[res - 1].start();

					System.out.println("Quale elemento multimediale vuoi riprodurre? da 1 a 5");

					res = Integer.parseInt(sc.nextLine());
				} else if (arrY[res - 1] instanceof Immagine) {
					((Immagine) arrY[res - 1]).show();
					System.out.println("Quale elemnto multimediale vuoi riprodurre? da 1 a 5");

					res = Integer.parseInt(sc.nextLine());
				}
			} else if (res == 2) {
				if (arrY[res - 1] instanceof Video && arrY[res - 1] instanceof RegistrazioneAudio) {
					arrY[res - 1].start();
					System.out.println("Quale elemnto multimediale vuoi riprodurre? da 1 a 5");

					res = Integer.parseInt(sc.nextLine());
			} else if (arrY[res - 1] instanceof Immagine) {
					((Immagine) arrY[res - 1]).show();
					System.out.println("Quale elemnto multimediale vuoi riprodurre? da 1 a 5");

					res = Integer.parseInt(sc.nextLine());
				}
			} else if (res == 3) {
				if (arrY[res - 1] instanceof Video && arrY[res - 1] instanceof RegistrazioneAudio) {
					arrY[res - 1].start();
					System.out.println("Quale elemnto multimediale vuoi riprodurre? da 1 a 5");

					res = Integer.parseInt(sc.nextLine());
				} else if (arrY[res - 1] instanceof Immagine) {
					((Immagine) arrY[res - 1]).show();
					System.out.println("Quale elemnto multimediale vuoi riprodurre? da 1 a 5");

					res = Integer.parseInt(sc.nextLine());
				}
			} else if (res == 4) {
				if (arrY[res - 1] instanceof Video && arrY[res - 1] instanceof RegistrazioneAudio) {
					arrY[res - 1].start();
					System.out.println("Quale elemnto multimediale vuoi riprodurre? da 1 a 5");

					res = Integer.parseInt(sc.nextLine());
				} else if (arrY[res - 1] instanceof Immagine) {
					((Immagine) arrY[res - 1]).show();
					System.out.println("Quale elemnto multimediale vuoi riprodurre? da 1 a 5");

					res = Integer.parseInt(sc.nextLine());
				}
			} else if (res == 5) {
				if (arrY[res - 1] instanceof Video && arrY[res - 1] instanceof RegistrazioneAudio) {
					arrY[res - 1].start();
					System.out.println("Quale elemnto multimediale vuoi riprodurre? da 1 a 5");

					res = Integer.parseInt(sc.nextLine());
				} else if (arrY[res - 1] instanceof Immagine) {
					((Immagine) arrY[res - 1]).show();
					System.out.println("Quale elemnto multimediale vuoi riprodurre? da 1 a 5");

					res = Integer.parseInt(sc.nextLine());
				}
			} else {

				System.out.println("Numero inserito non valido, Inserisci un numero valido da 1 a 5");

				res = Integer.parseInt(sc.nextLine());

			}
		}

		System.out.println("FINE");

	}

	public static ElementoMultimediale inserisciImmagine() {

		System.out.print("Inserisci il titolo dell'immagine: ");
		String elemento = sc.nextLine();
		System.out.print("Inserisci la luminosità per l'immagine: ");
		int luminosita = Integer.parseInt(sc.nextLine());
		Immagine x = new Immagine(elemento, luminosita);
		return x;

	}

	public static ElementoMultimediale inserisciAudio() {

		System.out.print("Inserisci il titolo dell'audio: ");
		String elemento = sc.nextLine();
		System.out.print("Inserisci il volume per l'audio: ");
		int volume = Integer.parseInt(sc.nextLine());
		System.out.print("Inserisci la durata per l'audio: ");
		int durata = Integer.parseInt(sc.nextLine());
		RegistrazioneAudio x = new RegistrazioneAudio(elemento, volume, durata);
		return x;

	}

	public static ElementoMultimediale inserisciVideo() {

		System.out.print("Inserisci il titolo del video: ");
		String elemento = sc.nextLine();
		System.out.print("Inserisci il volume per il video: ");
		int volume = Integer.parseInt(sc.nextLine());
		System.out.print("Inserisci la durata per il video: ");
		int durata = Integer.parseInt(sc.nextLine());
		System.out.print("Inserisci la luminosità per il video: ");
		int luminosita = Integer.parseInt(sc.nextLine());
		Video x = new Video(elemento, luminosita, volume, durata);
		return x;
	}

}
