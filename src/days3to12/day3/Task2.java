package days3to12.day3;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

        Scanner con_in = new Scanner(System.in);
        double a = con_in.nextDouble();
        double b = con_in.nextDouble();
        double max;
        if (a > b){
            max = a;
        }
        else{
            max = b;
        }
        System.out.println(max);
    }
}