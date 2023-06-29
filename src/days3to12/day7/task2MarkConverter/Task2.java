package days3to12.day7.task2MarkConverter;


import java.text.Normalizer;
import java.util.Scanner;
//https://github.com/janzitniak/javadeveloperjunior3/blob/main/src/ZakladneMatematickeOperacie.java
//https://github.com/janzitniak/javadeveloperjunior3


// Vytvorte program, ktorý na základe textového zadania známky, napr. výborný, chválitebný, dobrý, dostatočný, nedostatočný vypíše zodpovedajúcu známku čiže 1, 2, 3, 4, 5.

public class Task2 {

//	public static int convert_mark(String mark){
//		int mark_change = 0;
//		switch (mark) {
//			case ("výborný"):
//				mark_change = 1;
//				break;
//			case ("chválitebný"):
//				mark_change = 2;
//				break;
//			case ("dobrý"):
//				mark_change = 3;
//				break;
//			case ("dostatočný"):
//				mark_change = 4;
//				break;
//			case ("nedostatočný"):
//				mark_change = 5;
//				break;
//			default:
//				System.out.println("Nepodporovaný formát známky");
//		}
//		return mark_change;
//	}

	public static void main(String[] args) {
		String mark;
		int markChange;
		Scanner conIn = new Scanner(System.in);

		while (true){
			System.out.print("Zadajte známku: ");
			mark = conIn.nextLine().toLowerCase();

			mark = Normalizer.normalize(mark, Normalizer.Form.NFD);
			mark = mark.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");

			if (mark.equals("koniec")) {
				break;
			}

			markChange = Task2Convertor.convert_mark(mark);

			if (markChange!=0){
				System.out.println(mark + " == " + markChange);
			}
			else{
				System.out.println("Nepodporovaný formát známky");
			}
		}
		conIn.close();
	}
}