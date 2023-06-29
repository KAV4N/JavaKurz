package days3to12.day10.MarkConvertor;

//Úloha 1: Program na priradenie známky
//
//		Vytvorte prostredníctvom vstupu z konzoly rozhodovací test, ktorý vypíše známku A, B alebo C podľa týchto kritérií:
//		Ak je percento nad 90, tak vypíše známku A
//		Ak je percento nad 75, tak vypíše známku B
//		Ak je percento nad 65, tak vypíše známku C
//		Použite metódu pre rozhodovanie.

import java.util.Scanner;

public class MarkConvertor {
	public static char hodnot(double mark){
		char mark_converted = 0;
		if (mark > 90){
			mark_converted = 'A';
		}
		else if (mark > 75){
			mark_converted = 'B';
		}
		else if (mark > 65){
			mark_converted = 'C';
		}
		return mark_converted;
	}


	public static void main(String[] args) {
		double mark = 0;
		char markConverted;
		int count = 0;
		double average = 0;
		double sum = 0;

		try (Scanner conIn = new Scanner(System.in)){
			while (mark >= 0){
				mark = conIn.nextDouble();
				if (mark>=0){
					markConverted = hodnot(mark);
					if (markConverted!=0){
						System.out.println(mark + " == " + markConverted);
					}
					else{
						System.out.println("Neuspel");
					}
					count++;
					sum += mark;
				}

			}
		}
		if (count>0){
			average = sum/count;
			System.out.println("Priemer triedy: "+ average);
		}
	}
}