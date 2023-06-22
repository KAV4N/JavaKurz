package day9;

import java.util.Arrays;

public class Task1 {

	public static int pocet(double[] polePreZistenieDlzky) {
		return polePreZistenieDlzky.length;
	}

	public static double scitaj(double[] polePreScitanie) {
		double sucetPola = 0;

		for (int i = 0; i < pocet(polePreScitanie); i++) {
			sucetPola += polePreScitanie[i];
		}
		return sucetPola;
	}

	public static double priemeruj(double[] polePrePriemer) {
		return scitaj(polePrePriemer) / pocet(polePrePriemer);
	}

	public static double max(double[] polePreNajdenieMax) {
		return Arrays.stream(polePreNajdenieMax).max().getAsDouble();
	}

	public static double min(double[] polePreNajdenieMin) {
		return Arrays.stream(polePreNajdenieMin).min().getAsDouble();
	}

	public static void main(String[] args) {

		double[] vstupnePole = {20.8, 30.7, 58.5, 64.45, 98.87, 10.5, 25, 45, 21, 1, 5, 9, 1, 36, 99};

		System.out.println("VSTUPNÉ POLE");
		for (int i = 0; i < vstupnePole.length; i++) {
			System.out.printf("%9.2f", vstupnePole[i]);
			if ((i + 1) % 5 == 0) {
				System.out.println();
			}
		}

		System.out.println();

		System.out.println("TEST \"EXCEL\" METÓD");
		System.out.printf("Počet prvkov poľa je: %d%n", pocet(vstupnePole));
		System.out.printf("Súčet poľa je: %.1f%n", scitaj(vstupnePole));
		System.out.printf("Priemer poľa je: %.1f%n", priemeruj(vstupnePole));
		System.out.printf("Maximum poľa je: %.1f%n", max(vstupnePole));
		System.out.printf("Minimum poľa je: %.1f%n", min(vstupnePole));
		System.out.println();

		System.out.println("VÝPIS MATICE 1 - 25");
		for (int i = 1; i <= 25; i++) {
			System.out.printf("%-5d", i);
			if (i % 5 == 0) {
				System.out.println();
			}
		}
		System.out.println();

		System.out.println("VÝPIS MATICE \"MOCNINY 2\"");
		int dvojnasobok = 1;
		for (int i = 1; i <= 25; i++) {
			System.out.printf("%-10d", dvojnasobok);
			dvojnasobok *= 2;
			if (i % 5 == 0) {
				System.out.println();
			}
		}
	}
}
