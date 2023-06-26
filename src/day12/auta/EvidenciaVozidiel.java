package day12.auta;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EvidenciaVozidiel {
    private static void vypisGaraz(ArrayList<Auto> garaz) {
        System.out.println("\nZoznam aut v garazi:");
        for (int i = 0; i < garaz.size(); i++){
            System.out.println("Auto cislo " + (i+1) + " : ");
            garaz.get(i).printInformacie();
            System.out.println();
        }
    }
    private static Auto vytvorAuto(Scanner scanner) {
        String znacka;
        String farba;
        double maxRychlost;

        System.out.println("Pridavanie auta do garaze: ");

        System.out.print("\tZadajte znacku auta: ");
        znacka = scanner.nextLine().trim();

        System.out.print("\tZadajte farbu auta: ");
        farba = scanner.nextLine().trim();

        while (true) {
            try {
                System.out.print("\tZadajte maximalnu rychlost auta: ");
                maxRychlost = scanner.nextDouble();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Nespravny format maximalnej rychlosti. Zadajte cele cislo.");
                scanner.nextLine();
            }
        }
        System.out.println();
        return new Auto(znacka, farba, maxRychlost);
    }
    public static void main(String[] args) {
        ArrayList<Auto> garaz = new ArrayList<>();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Pre pridanie auta stlacte lubovolnu klavesu.\nPre ukoncenie programu zadajte 'koniec'.");

                String userInput = scanner.nextLine().trim().toLowerCase();
                if (userInput.equals("koniec")) {
                    break;
                } else {
                    Auto noveAuto = vytvorAuto(scanner);
                    garaz.add(noveAuto);
                }
            }
        }
        vypisGaraz(garaz);
    }
}
