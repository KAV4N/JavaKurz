package rieseniaUloh.day4;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {

        // (int) (Math.random() * (max - min + 1) + min)

        Scanner con_in = new Scanner(System.in);
        double a = con_in.nextDouble();
        if (a > 5 && a < 10){
            System.out.println("je v intervale");
        }
        else {
            System.out.println("nie je v intervale");
        }

    }
}
