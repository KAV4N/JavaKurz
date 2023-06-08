package day5;


import java.util.Scanner;

public class Task3 {
    // 6. naprogramujte funkciu kalkulacka, ktora dostane na vstupe
    // 2 cisla a znak operacie {+, -, /} a vrati nam vysledok tejto operacie
    public static double calculate(double num1, double num2, String operator) {
        double result = 0;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Division by zero");
                }
                break;
            default:
                System.out.println("Invalid operator.");
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner con_in = new Scanner(System.in);
        double num1, num2;
        String operator;

        num1 = con_in.nextDouble();
        operator = con_in.next();
        num2 = con_in.nextDouble();

        double result = calculate(num1, num2, operator);
        System.out.println("Result: " + result);


    }
}
