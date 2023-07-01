package rieseniaUloh.day3;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        Scanner con_in = new Scanner(System.in);
        double num1 = con_in.nextDouble();

        if (num1 < 0){
            num1 = -num1;
        }
        System.out.println(num1);



    }
}