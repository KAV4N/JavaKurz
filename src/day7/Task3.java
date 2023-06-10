package day7;

//Fizz buzz je skupinová slovná hra pre deti, ktorej účelom je naučiť ich delenie čísel. Hráči postupne vymenúvajú čísla, pričom nahrádzajú každé číslo deliteľné tromi slovom "fizz" a každé číslo deliteľné piatimi slovom "buzz".
//
//		Hra
//		Hráči zvyčajne sedia v kruhu. Prvý hráč povie číslo "1" a každý ďalší hráč povie číslo o jedno vyššie od predošlého. Akékoľvek číslo deliteľné tromi musí hráč nahradiť slovom fizz a akékoľvek číslo deliteľné piatimi slovom buzz. Čísla deliteľné oboma sa nahrádzajú slovami fizz buzz. Hráč, ktorý zaváha alebo urobí chybu je vylúčený z hry.
//		Typická hra fizz buzz môže začínať takto:
//
//		1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, Fizz Buzz, 16, 17, Fizz, 19, Buzz, Fizz, 22, 23, Fizz, Buzz, 26, Fizz, 28, 29, Fizz Buzz, 31, 32, Fizz, 34, Buzz, Fizz, …

public class Task3 {

	public static void main(String[] args) {
		boolean isDivisible3;
		boolean isDivisible5;
		String result;
		String fullResult = "";
		for (int i = 1; i < 101; i++){
			// 1. pokus
//            if (i%3==0 && i%5==0){
//                System.out.println("FizzBuzz");
//            }
//            else if (i%3==0){
//                System.out.println("Fizz");
//            }
//            else if (i%5==0){
//                System.out.println("Buzz");
//            }
//            else{
//                System.out.println(i);
//            }

			// 2. pokus
//            isDivisible3 = (i%3==0);
//            isDivisible5 = (i%5==0);
//            if (isDivisible3 && isDivisible5){
//               System.out.println("FizzBuzz");
//            }
//            else if (isDivisible3){
//                System.out.println("Fizz");
//            }
//            else if (isDivisible5){
//                System.out.println("Buzz");
//            }
//            else{
//               System.out.println(i);
//            }

			// 3. pokus
			result = "";
			if (i%3==0){
				result+="Fizz";
			}
			if (i%5==0){
				result = (result+" Buzz").trim();
			}
			if (result.isEmpty()){
				result = Integer.toString(i);
			}
			fullResult += (result+", ");
		}
		fullResult = fullResult.substring(0, fullResult.length() - 2);
		System.out.println(fullResult);
	}
}