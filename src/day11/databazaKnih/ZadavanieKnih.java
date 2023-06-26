package day11.databazaKnih;

import java.util.*;



/*
*
* Skuska vytvorenia vlastneho objektu :)
*
* */

public class ZadavanieKnih {

	private static void vypisUlozeneKnihy(ArrayList<Kniha> zoznamKnih) {
		System.out.println("\nZoznam ulozenych knih:");
		for (int i = 0; i < zoznamKnih.size(); i++) {
			System.out.println("Kniha cislo " + (i+1) + " : " + zoznamKnih.get(i).getNazov());
		}
	}
	private static void vlozKnihu(ArrayList<Kniha> zoznamKnih) {
		String autor;
		String nazov;
		String zaner;
		String vydavatelstvo;
		int rokVydania;

		Scanner inputScan = new Scanner(System.in);
		inputScan.useLocale(Locale.forLanguageTag("sk-SK"));

		try{
			System.out.println("Tvorba knihy: ");

			System.out.print("\tZadajte nazov: ");
			nazov = inputScan.nextLine();

			System.out.print("\tZadajte autora: ");
			autor = inputScan.nextLine();

			System.out.print("\tZadajte zaner: ");
			zaner = inputScan.nextLine();

			System.out.print("\tZadajte vydavatelstvo: ");
			vydavatelstvo = inputScan.nextLine();

			System.out.print("\tZadajte rok vydania: ");
			rokVydania = inputScan.nextInt();

			Kniha novaKniha = new Kniha(autor,nazov,zaner,vydavatelstvo,rokVydania);
			zoznamKnih.add(novaKniha);
		}
		catch (InputMismatchException e){
			System.out.print("\nNastala chyba pri vstupe, kniha sa neulozila!\n\n");
		}
		catch (NoSuchElementException e) {
			System.out.print("\nNastala chyba pri vstupe, kniha sa neulozila!\n\n");
		}
	}

	public static void main(String[] args) {
		ArrayList<Kniha> zoznamKnih = new ArrayList<>();
		System.out.println("Program pre zadavanie knih.");
		Scanner vstup = new Scanner(System.in);

		while(true){
			System.out.println("Pre pridanie knihy stlacte lubovolnu klavesu. \nPre ukoncenie zadavania zadajte \'koniec\'.");
			if (vstup.nextLine().toLowerCase().trim().equals("koniec")){
				break;
			}
			else{
				vlozKnihu(zoznamKnih);
			}
		}
		vypisUlozeneKnihy(zoznamKnih);

	}
}
