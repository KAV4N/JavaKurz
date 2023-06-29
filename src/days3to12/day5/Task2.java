package days3to12.day5;

import java.util.Scanner;

public class Task2 {
    static String get_greetings(String name){
        return "Ahoj, " + name;
    }
    public static void main(String[] args) {
        Scanner con_in = new Scanner(System.in);
        System.out.println(get_greetings(con_in.nextLine()));


    }
}
