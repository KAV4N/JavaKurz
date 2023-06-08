package day4;

import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        Scanner con_in = new Scanner(System.in);
        int rows = con_in.nextInt();

        for (int i = rows; i > 0; i--) {
            for (int k = 0; k < i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
