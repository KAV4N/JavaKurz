package days3to12.day4;

import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        //07. Napíšte program, ktorý spočíta prirodzené čísla od 1 po n.
        // n - celociselne cislo, ktore nacitate zo vstupu
        // bonus: okrem vypisania ich aj spocitajte a vypiste vysledok suctu
        Scanner con_in = new Scanner(System.in);
        int num = con_in.nextInt();
        int res = 0;
        for (int i = 1; i <= num; i++ ){
            System.out.println(i);
            res += i;
        }
        System.out.println("Sucet: "+res);

        System.out.println("Sucet je " + (num * (num + 1) / 2 ));
    }
}
