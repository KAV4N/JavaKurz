package rieseniaUloh.day7.task2MarkConverter;


//https://github.com/janzitniak/javadeveloperjunior3/blob/main/src/ZakladneMatematickeOperacie.java
//https://github.com/janzitniak/javadeveloperjunior3


// Vytvorte program, ktorý na základe textového zadania známky, napr. výborný, chválitebný, dobrý, dostatočný, nedostatočný vypíše zodpovedajúcu známku čiže 1, 2, 3, 4, 5.

public class Task2Convertor {
	public static int convert_mark(String mark){
		int markChange = 0;
		switch (mark) {
			case ("vyborny"):
				markChange = 1;
				break;
			case ("chvalitebny"):
				markChange = 2;
				break;
			case ("dobry"):
				markChange = 3;
				break;
			case ("dostatocny"):
				markChange = 4;
				break;
			case ("nedostatocny"):
				markChange = 5;
				break;

		}
		return markChange;
	}
}