package day4;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

        // (int) (Math.random() * (max - min + 1) + min)

        Scanner con_in = new Scanner(System.in);
        double a = con_in.nextDouble();
        double b = con_in.nextDouble();
        double c = con_in.nextDouble();
        double d = con_in.nextDouble();

        double max = a;

        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        if (d > max) {
            max = d;
        }

        System.out.println(max);



    }
}
