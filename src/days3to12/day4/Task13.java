package days3to12.day4;

import java.util.Scanner;

// 12. Zostavte program, ktorý zistí, či sa číslo n nachádza v postupnosti čísel.
// nacitat cislo n zo vstupu
// prejst cele pole {v cykle} a porovnat jednotlive cisla s cislom n
// vypisat ci sa tam nachadza - v tom vasom poli

public class Task13 {

    public static void main(String[] args) {
        Scanner con_in = new Scanner(System.in);
        int numbers[] = {35,79,92,1,50,17,86,96,7,65,85,32,29,50,16,59,98,84,77,41,14,38,40,48,64,100,18,34,97,74,92,85,38,50,59,62,17,26,78,43,99,38,79,21,81,31,14,32,54,23,12,88,46,6,73,39,71,68,79,31,46,53,1,91,27,59,53,100,57,39,70,58,2,53,43,68,31,15,86,97,71,61,73,43,13,39,26,6,74,73,99,48,2,83,54,22,81,23};
        int num  = con_in.nextInt();
        int count_num = 0;

        for (int x : numbers){
            if (x==num){
                count_num++;
            }
        }
        System.out.println("Cislo "+num+" sa nachadza v poli " +count_num+" krat");
    }

}


