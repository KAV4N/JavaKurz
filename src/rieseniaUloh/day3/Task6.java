package rieseniaUloh.day3;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner con_in = new Scanner(System.in);

        int plat = con_in.nextInt();
        int plat_trieda;
        if (plat > 2000) {
            plat_trieda = 1;
        }

        else if (plat < 2000 && plat > 1200) {
            plat_trieda = 2;
        }

        else if (plat < 1200) {
            plat_trieda = 3;
        }
        else {
            plat_trieda = -1;
        }

        switch (plat_trieda) {
            case 1:
                System.out.println("Napriemerný plat");
                break;
            case 2:
                System.out.println("Priemerný plat");
                break;
            case 3:
                System.out.println("Podpriemerný plat");
                break;
            default:
                System.out.println("Neplatná hodnota");
                break;
        }
    }
}