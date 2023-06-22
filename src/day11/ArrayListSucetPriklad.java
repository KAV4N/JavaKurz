package day11;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ArrayListSucetPriklad {

    /**
     * Načíta pole čísiel do poľa. Zadávanie hodnôt sa ukončí zadaním záporného čísla.
     */
    private static boolean nacitajHodnoty(ArrayList<Double> polePreVstup) {
        double novaHodnotaPrePole = 0;
        boolean koniec = false;
        Scanner inputScan = new Scanner(System.in);
        try{
            inputScan.useLocale(Locale.forLanguageTag("sk-SK"));
            System.out.print("Zadaj hodnotu: ");
            novaHodnotaPrePole = inputScan.nextDouble();
            if (novaHodnotaPrePole < 0){
                koniec = true;

            }
            else{
                polePreVstup.add(novaHodnotaPrePole);
            }

        }
        catch (Exception e) {
            System.out.print("\n\nAko vstup je možné použiť len desatinné čísla!\n\n");
        }
        return koniec;
    }


    /**
     * Metóda pre výpis čísiel v dynamickom poli na konzolu.
     *
     * @param cislaPreVypis
     */
    private static void vypisCisiel(ArrayList<Double> cislaPreVypis) {
        for (int i = 0; i < cislaPreVypis.size(); i++) {
            System.out.println(i + " : " + cislaPreVypis.get(i));
        }
    }

    /**
     * Vráti súčet poľa.
     *
     * @param cislaPreSucet
     * @return double
     */
    private static double sucetCisiel(ArrayList<Double> cislaPreSucet) {
        double sucet = 0;
        for (int i = 0; i < cislaPreSucet.size(); i++) {
            sucet += cislaPreSucet.get(i);
        }
        return sucet;
    }

    public static void main(String[] args) {
        ArrayList<Double> ciselnePole = new ArrayList<>();
        boolean koniec = false;

        System.out.println("Vstup hodnôt pre súčet je možný po výzve \"Zadaj hodnotu:\"");
        System.out.println("Zadávanie hodnôt je možné ukončiť po zadaní záporného čísla.");

        while(!koniec){
            koniec = nacitajHodnoty(ciselnePole);
        }

        if (ciselnePole.size() > 0) {
            vypisCisiel(ciselnePole);
            System.out.println("\nSúčet zadaného poľa je:" + sucetCisiel(ciselnePole));
        }
    }
}
