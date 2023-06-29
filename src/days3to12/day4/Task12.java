package days3to12.day4;

import java.util.Scanner;

// 11.a naprogramujte kalkulacku, ktora bude vediet +, -, *, /
// na vstupe zadane 2 cisla a znak operacie, ktoru chcete aby sa vykonala
// vypise sa vysledok zvolenej operacie

// 11.b upravte tento program tak, aby fungoval opakovane az kym ako znak zadate .
public class Task12 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String operator;
        double num1, num2;
        while (true) {
            System.out.print("First number: ");
            num1 = scanner.nextDouble();

            System.out.print("Math operator: ");
            scanner.nextLine();
            operator = scanner.nextLine();
            if (operator.equals(".")) {
                break;
            }

            System.out.print("Second number: ");
            num2 = scanner.nextDouble();

            switch (operator) {
                case "+":
                    System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
                    break;
                case "-":
                    System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
                    break;
                case "*":
                    System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
                    break;
                case "/":
                    if (num2 != 0) {
                        System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
                    }
                    else {
                        System.out.println("Division by zero is not allowed");
                    }
                    break;
                default:
                    System.out.println("Invalid operation");
            }
            System.out.println();
        }
    }
/*
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first number:");
        double num1 = Double.parseDouble(scanner.next());

        System.out.println("Enter the second number:");
        double num2 = Double.parseDouble(scanner.next());

        System.out.println("Enter mathematical operator:");
        scanner.nextLine();
        String operator = scanner.nextLine();

        switch (operator) {
            case "+":
                System.out.println(num1 + " + " + num2 + " = "  + (num1 + num2));
                break;
            case "-":
                System.out.println(num1 + " - " + num2 + " = "  + (num1 - num2));
                break;
            case "*":
                System.out.println(num1 + " * " + num2 + " = "  + (num1 * num2));
                break;
            case "/":
                System.out.println(num1 + " / " + num2 + " = "  + (num1 / num2));
                break;
            default:
                System.out.println("This is not mathematical operation");
        }
    }*/
}


