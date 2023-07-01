package rieseniaUloh.day3;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {

        Scanner con_in = new Scanner(System.in);
        double a = con_in.nextDouble();
        double b = con_in.nextDouble();
        double c = con_in.nextDouble();

        // 1. sposob
        double max;

        if (a > b){
            max = a;
        }
        else{
            max = b;
        }
        if (c > max){
            max = c;
        }
        System.out.println(max);

        // 2. sposob
        if (a > b){
            if (a > c){
                System.out.println(a);
            }
            else{
                System.out.println(c);
            }
        }
        else{
            if (b > c){
                System.out.println(b);
            }
            else{
                System.out.println(c);
            }
        }


    }
}