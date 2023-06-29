package days3to12.day7;
import java.util.Scanner;


/*
Úloha 1: Základné matematické operácie


Vytvorte jednoduchý program, ktorého cieľom bude výpočet 5 základných matematických operácií a to sčítanie (+), odčítanie (-), násobenie (*) a delenie (/), modulo (%).
Matematické operácie budú “narábať” s dvoma hodnotami, ktoré budú zadané v premenných, napr. cislo1  a cislo2.


Pozn.: Nezabúdať na to, že sa môže jednať o desatinné čísla.
Program nám zároveň vypíše takýto text:
Výsledkom sčítania hodnôt 2 a 3 je 5.
Výsledkom odčítania hodnôt 2 a 3 je -1.
atď.
Bonusová úloha: Vedeli by ste v prípade desatinných miest nahradiť desatinnú bodku za čiarku?
Pomôcka:
// Ako naformatovat cislo v SK formate na 2 desatinne miesta, pouzijeme %.2f
System.out.printf("Desatinné číslo naformátované ako desatinná čiarka %.2f", desatinneCislo);
Bonusová úloha č.2: Vstup hodnôt by mohol byť cez konzolu, čiže Scanner.

*/

public class Task1 {
	public static double sum(double num1, double num2) {
		return num1 + num2;
	}

	public static double subtract(double num1, double num2) {
		return num1 - num2;
	}

	public static double multiply(double num1, double num2) {
		return num1 * num2;
	}

	public static double divide(double num1, double num2) {
		double res;
		if (num2 != 0) {
			res =  num1 / num2;
		}
		else {
			System.out.println("Division by zero");
			res =  Double.NaN;
		}
		return res;
	}

	public static double modulo(double num1, double num2) {
		double res;
		if (num2 != 0) {
			res =  num1 % num2;
		}
		else {
			System.out.println("Division by zero");
			res =  Double.NaN;
		}
		return res;
	}

	public static double calculate(double num1, double num2, String operator){
		double result = 0;
		switch (operator) {
			case "+":
				result = sum(num1, num2);
				break;
			case "-":
				result = subtract(num1, num2);
				break;
			case "*":
				result = multiply(num1, num2);
				break;
			case "/":
				result = divide(num1, num2);
				break;
			case "%":
				result = modulo(num1, num2);
				break;
			default:
				System.out.println("Invalid operator.");
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		scanner.useLocale(Locale.GERMAN);
//		scanner.useLocale(Locale.forLanguageTag("sk-SK"));
//		scanner.useDelimiter("[,\\.]");

		System.out.print("Enter number 1: ");
		double num1 = scanner.nextDouble();

		System.out.print("Enter operator: ");
		String operator = scanner.next();

		System.out.print("Enter number 2: ");
		double num2 = scanner.nextDouble();

		double result = calculate(num1,num2,operator);


		if (Double.isNaN(result)) {
			System.out.println("Cannot calculate the result");
		}
		else {
			System.out.printf("Result: %.2f %s %.2f = %.2f", num1, operator, num2, result);
		}

		scanner.close();
	}
}
