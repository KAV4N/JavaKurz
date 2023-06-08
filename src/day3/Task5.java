package day3;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {

        Scanner con_in = new Scanner(System.in);
        int day = con_in.nextInt();

        switch (day){
            case 1:
                System.out.println("monday");
                break;
            case 2:
                System.out.println("tuesday");
                break;
            case 3:
                System.out.println("wednesday");
                break;
            case 4:
                System.out.println("thursday");
                break;
            case 5:
                System.out.println("friday");
                break;
            case 6:
                System.out.println("saturday");
                break;
            case 7:
                System.out.println("sunday");
                break;
            default:
                System.out.println("There is not such a day with a number: " + day);

        }


    }
}