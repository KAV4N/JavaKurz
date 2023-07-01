package rieseniaUloh.day3;

public class Task7 {
    public static void main(String[] args) {

        int rows = 9;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println();
        for (int i = rows; i >= 1; i--) {
            for (int j = 1; j <= rows - i; j++) {
                System.out.print("  ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows-i; j++) {
                System.out.print(" ");
            }
            for (int n = 0; n <= i; n++) {
                System.out.print(i+" ");
            }
            System.out.println();
        }


        for (int i = rows; i > 0; i--) {
            for (int j = 0; j <= rows-i; j++) {
                System.out.print(" ");
            }
            for (int n = 0; n < i; n++) {
                System.out.print(i+" ");
            }
            System.out.println("");
        }
    }
}