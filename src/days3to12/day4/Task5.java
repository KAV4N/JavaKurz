package days3to12.day4;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner con_in = new Scanner(System.in);
        /*
        String mark = con_in.nextLine().toUpperCase();
        int mark_change;
        switch (mark){
            case ("A"):
                mark_change = 1;
                break;
            case ("B"):
                mark_change = 2;
                break;
            case ("C"):
                mark_change = 3;
                break;
            case ("D"):
                mark_change = 4;
                break;
            default:
                mark_change = 5;
        }*/

        int mark = con_in.nextInt();
        char mark_change;
        switch (mark){
            case (1):
                mark_change = 'A';
                break;
            case (2):
                mark_change = 'B';
                break;
            case (3):
                mark_change = 'C';
                break;
            case (4):
                mark_change = 'D';
                break;
            default:
                mark_change = 'E';
        }
        System.out.println(mark + " == "+ mark_change);

    }
}
