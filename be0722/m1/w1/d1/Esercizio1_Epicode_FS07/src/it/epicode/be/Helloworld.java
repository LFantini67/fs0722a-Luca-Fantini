package it.epicode.be;

import java.util.Scanner;

public class Helloworld {

public static void main (String[] args)
		{
		// Stampa a console  la frase
		System.out.println("This is my first Epicode Java Project!");
		
		Moltiplica(11,5);
		
		Concatena("Quanti anni hai? ", 27);
		
		String arrx = "unoMezzo";
		String[] arry = new String[] {"uno", "due", "tre", "quattro", "cinque"};
		String[] newArray = inserisciInArray(arry, arrx);
		System.out.println("Array: ");
		System.out.println("NewArray: " + newArray.toString());
		
		Scanner sc = new Scanner(System.in);
		System.out.println("1° Stringa: ");
		String uno = sc.nextLine();
		System.out.println("2° Stringa: ");
		String due = sc.nextLine();
		System.out.println("3° Stringa: ");
		String tre = sc.nextLine();
		
		System.out.println(uno + due + tre);
		System.out.println(tre + due + uno);
		
		System.out.println(perimetroRettangolo(5,7));
		
		System.out.println(pariDispari(5));
		
		System.out.println(perimetroTriangolo(20,19,26));
		}


	static void Moltiplica(int x, int y) {
		int prodotto = x * y;
		System.out.println(prodotto);
	}
	
	static void Concatena(String s, int z) {
		String concatenazione = s + z;
		System.out.println(concatenazione);
	}
	
	static String[] inserisciInArray(String[] inputArr, String str) {
		String[] arr = new String[6];
		arr[0] = inputArr[0];
		arr[0] = inputArr[1];
		arr[0] = str;
		arr[0] = inputArr[2];
		arr[0] = inputArr[3];
		arr[0] = inputArr[4];
		return arr;
	}
	
	static double perimetroRettangolo(double b, double h) {
		return (b * 2) + (h * 2);               
	}
	
	static boolean pariDispari(int c) {
		if((c % 2) == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	static double perimetroTriangolo(double a, double b, double c) {
		double semiPerimetro = (a + b + c)/2;
		double areaTriangolo = Math.sqrt(semiPerimetro * (semiPerimetro - a) * (semiPerimetro - b) * (semiPerimetro - c));
		return areaTriangolo;
	}
}



