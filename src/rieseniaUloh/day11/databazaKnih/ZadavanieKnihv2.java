package rieseniaUloh.day11.databazaKnih;

import java.util.*;

public class ZadavanieKnihv2 {

	private static void vypisUlozeneKnihy(LinkedList<Kniha> zoznamKnih) {
		System.out.println("\nZoznam ulozenych knih:\n");
		for (int i = 0; i < zoznamKnih.size(); i++){
			System.out.println("Kniha cislo " + (i+1) + " : ");
			zoznamKnih.get(i).printInformacie();
		}

	}

	private static Kniha vytvorKnihu(Scanner scanner) {
		String autor;
		String nazov;
		String zaner;
		String vydavatelstvo;
		int rokVydania;

		System.out.println("Tvorba knihy: ");

		System.out.print("\tZadajte nazov: ");
		nazov = scanner.nextLine().trim();

		System.out.print("\tZadajte autora: ");
		autor = scanner.nextLine().trim();

		System.out.print("\tZadajte zaner: ");
		zaner = scanner.nextLine().trim();

		System.out.print("\tZadajte vydavatelstvo: ");
		vydavatelstvo = scanner.nextLine().trim();

		while (true) {
			try {
				System.out.print("\tZadajte rok vydania: ");
				rokVydania = scanner.nextInt();
				scanner.nextLine();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Nespravny format roku vydania. Zadajte cele cislo.");
				scanner.nextLine();
			}
		}
		System.out.println("\nPridanie knihy "+ nazov + " prebehlo uspesne\n");
		return new Kniha(autor, nazov, zaner, vydavatelstvo, rokVydania);
	}

	public static void main(String[] args) {
		LinkedList<Kniha> zoznamKnih = new LinkedList<>();
		String userInput;
		System.out.println("Program pre zadavanie knih.");
		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				System.out.println("Pre pridanie knihy stlacte lubovolnu klavesu. \nPre ukoncenie programu zadajte \'koniec\'.");

				userInput = scanner.nextLine().trim().toLowerCase();
				if (userInput.equals("koniec")) {
					break;
				} else {
					Kniha novaKniha = vytvorKnihu(scanner);
					zoznamKnih.add(novaKniha);
				}
			}
		}
		vypisUlozeneKnihy(zoznamKnih);
	}
}
