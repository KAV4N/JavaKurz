package day4;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {

       //06. Urob program, ktorý zobrazí k číslu mesiaca jeho slovný ekvivalent a jeho pocet dni.
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        // array variant
        final String months[] = {
                "januar", "februar", "marec",
                "april", "maj", "jun",
                "jul", "august", "september",
                "oktober", "november", "december"
            };

        int days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        String chosen_month = months[num - 1];
        int days_in_month = days[num - 1];

        System.out.println("Array - Vybrany mesiac: " + chosen_month);
        System.out.println("Array - Pocet dni vo vybranom mesiaci: " + days_in_month);

        //switch variant
        String chosen_month2;
        int days_in_month2;

        switch (num) {
            case 1:
                chosen_month2 = "januar";
                days_in_month2 = 31;
                break;
            case 2:
                chosen_month2 = "februar";
                days_in_month2 = 28;
                break;
            case 3:
                chosen_month2 = "marec";
                days_in_month2 = 31;
                break;
            case 4:
                chosen_month2 = "april";
                days_in_month2 = 30;
                break;
            case 5:
                chosen_month2 = "maj";
                days_in_month2 = 31;
                break;
            case 6:
                chosen_month2 = "jun";
                days_in_month2 = 30;
                break;
            case 7:
                chosen_month2 = "jul";
                days_in_month2 = 31;
                break;
            case 8:
                chosen_month2 = "august";
                days_in_month2 = 31;
                break;
            case 9:
                chosen_month2 = "september";
                days_in_month2 = 30;
                break;
            case 10:
                chosen_month2 = "oktober";
                days_in_month2 = 31;
                break;
            case 11:
                chosen_month2 = "november";
                days_in_month2 = 30;
                break;
            case 12:
                chosen_month2 = "december";
                days_in_month2 = 31;
                break;
            default:
                chosen_month2 = "Neznámy mesiac";
                days_in_month2 = -1;
        }

        System.out.println("Switch - Vybrany mesiac: " + chosen_month2);
        System.out.println("Switch - Pocet dni vo vybranom mesiaci: " + days_in_month2);
    }





}
