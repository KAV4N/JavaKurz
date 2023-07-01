package rieseniaUloh.day4;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {

        // (int) (Math.random() * (max - min + 1) + min)

        Scanner con_in = new Scanner(System.in);
        double a = con_in.nextDouble();
        if (a < 0){
            System.out.println("zaporne");
        }
        else {
            System.out.println("kladne");
        }

    }
}
