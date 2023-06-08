package day4;


import java.util.Scanner;

public class Task16 {
    //15. Napíšte metodu, ktora zistí, koľko kilometrov prejde automobil,
    // ak zadáme množstvo natankovaného benzínu a spotrebu na 100 km.
    public static double calculateMileage(double fuel_amount, double fuel_comsumption) {
        double mileage = (fuel_amount / fuel_comsumption) * 100;
        return mileage;
    }

    public static void main(String[] args) {
        Scanner con_in = new Scanner(System.in);
        double fuelAmount = con_in.nextDouble();
        double fuelConsumption = con_in.nextDouble();

        double mileage = calculateMileage(fuelAmount, fuelConsumption);
        System.out.println("Automobil prejde " + mileage + " kilometrov.");
    }
}
