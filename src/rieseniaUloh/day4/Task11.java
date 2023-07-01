package rieseniaUloh.day4;

import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        Scanner con_in = new Scanner(System.in);
        int rand_num = (int)(Math.random()*100) + 1;
        int player_num, player_tries = 0;
        boolean found = false;

        while(!found){
            player_tries++;
            System.out.print("Pokus cislo " + player_tries+": ");
            player_num = con_in.nextInt();
            if (player_num > rand_num){
                System.out.println("Menej");
            }
            else if (player_num < rand_num){
                System.out.println("Viac");
            }
            else{
                found = true;
            }
        }

        System.out.println("Zasah! Cislo bolo "+ rand_num + ", trafil si ho na "+player_tries+" pokusov");


    }
}
