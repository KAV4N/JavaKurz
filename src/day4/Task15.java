package day4;


import java.util.Scanner;

public class Task15 {
    //14.Napíšte metodu, ktora ako parameter dostane cenu tovaru bez DPH
    // a na výstupe vypíše cenu tovaru s DPH.
    public static double get_price_with_vat(double price_without_vat) {
        final double VAT = 0.2;
        double price_with_vat = price_without_vat * (1 + VAT);
        return price_with_vat;

    }

    public static void main(String[] args) {
        Scanner con_in = new Scanner(System.in);
        double price_without_vat = con_in.nextDouble();

        System.out.println(get_price_with_vat(price_without_vat));
    }
}
