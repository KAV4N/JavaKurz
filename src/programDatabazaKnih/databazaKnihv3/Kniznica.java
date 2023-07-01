package programDatabazaKnih.databazaKnihv3;

import java.util.Scanner;

public class Kniznica {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		PouzivatelskeRozhranieDatabazyKnih ui = new PouzivatelskeRozhranieDatabazyKnih(scanner);
		ui.spusti();
	}
}