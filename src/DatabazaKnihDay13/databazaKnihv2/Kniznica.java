package DatabazaKnihDay13.databazaKnihv2;

import java.util.Scanner;

public class Kniznica {

	public static void main(String[] args) {
		String vstupUzivatela;
		System.out.println("Program pre zadávanie kníh.");
		try (Scanner scanner = new Scanner(System.in)) {
			DatabazaKnih databazaKnih1 = new DatabazaKnih(scanner);
			while (true) {
				DatabazaKnih.vypisMoznosti();
				System.out.print("# ");
				vstupUzivatela = scanner.nextLine().trim().toLowerCase();
				if (vstupUzivatela.equals("koniec")) {
					break;
				} else{
					databazaKnih1.vyberMoznosti(vstupUzivatela);
				}
			}
		}
	}
}
