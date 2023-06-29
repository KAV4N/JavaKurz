package days3to12.day3;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {

        Scanner con_in = new Scanner(System.in);
        double a = con_in.nextDouble();
        double b = con_in.nextDouble();
        /*
        if (a==b){
            System.out.println("Cisla su rovnake");
        }
        else if (a > b){
            System.out.println(a);
        }
        else{
            System.out.println(b);
        }
        */
        if (a!=b){
            if (a > b){
                System.out.println(a);
            }
            else{
                System.out.println(b);
            }
        }
        else{
            System.out.println("Cisla su rovnake");
        }


    }
}