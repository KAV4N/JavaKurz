package days3to12.day4;

import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Scanner con_in = new Scanner(System.in);
        double average;
        double sum_temperature = 0;
        double max = 0;

        int days = 5;
        double days_temperature[] = new double[days];

        for (int i = 0; i < days; i++){
            double temperature = con_in.nextDouble();
            sum_temperature += temperature;
            days_temperature[i] = temperature;

            if (max < temperature){
                max = temperature;
            }

        }
        average = sum_temperature/days;

        double largest_deviation = 0;
        int day_largest_deviation = 0;

        for (int i = 0; i < days_temperature.length; i++) {
            double deviation =  Math.abs(days_temperature[i] - average);
            if (deviation > largest_deviation) {
                largest_deviation = deviation;
                day_largest_deviation = i+1;
            }
        }

        System.out.println("Den s najv. rozdielom: "+day_largest_deviation + " s rozdielom "+largest_deviation);
        System.out.println("Priemer: "+average + " Max: " + max);


    }
}
