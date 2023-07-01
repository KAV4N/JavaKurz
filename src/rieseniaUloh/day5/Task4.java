package rieseniaUloh.day5;


import java.util.Scanner;

public class Task4 {
    //7. urobte funkciu, ktora dostane na vstupe cislo n
    // a vykresli hviezdicky
    // *****
    // ****
    // ***
    // **
    // *
    public static void create_pyramid(int rows) {
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < rows - i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner con_in = new Scanner(System.in);

        int rows = con_in.nextInt();
        create_pyramid(rows);

    }
}
