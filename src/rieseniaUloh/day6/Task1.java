package rieseniaUloh.day6;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task1 {

    public static void main(String[] args) {
        /*
         Vypíšte do konzoly nasledujúci text:

         Študent Jozef Mrkvička sa narodil 03.04.2000, z maturitnej skúšky má známku
         1.5 a od septembra 2022 nastúpi do nového zamestnania ako Java programátor. V
         Bratislave dňa 18.06.2022 Poznámka: Dátum narodenia, známku a rok + aktuálny
         dátum nastavte tak, aby sa dali meniť v zdrojovom kóde (t.j. cez premenné).
        */

        double studentGrade = 1.5;
        int year = 2022;
        String birthDate = "03.04.2000";
        Date today = new Date();
        SimpleDateFormat format_date = new SimpleDateFormat("dd.MM.yyyy");

        String textToShow = "Študent Jozef Mrkvička sa narodil " + birthDate + ", z maturitnej skúšky má známku "
                + studentGrade + " a od septembra " + year + " nastúpi do nového zamestnania ako Java programátor. \r\n"
                + "V Bratislave dňa " + format_date.format(today);

        System.out.println(textToShow);

    }
}