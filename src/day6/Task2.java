package day6;


public class Task2 {
    // Fizz Buzz game

    public static void main(String[] args) {
        boolean isDivisible3;
        boolean isDivisible5;
        String result;
        for (int i = 0; i < 101; i++){
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
            System.out.println(result);

        }
    }
}