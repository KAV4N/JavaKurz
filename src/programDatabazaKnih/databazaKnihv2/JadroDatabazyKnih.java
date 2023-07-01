package programDatabazaKnih.databazaKnihv2;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class JadroDatabazyKnih {
    protected final Scanner scanner;
    protected final ArrayList<Kniha> zoznamKnih = new ArrayList<>();
    public JadroDatabazyKnih(Scanner scanner) {
        this.scanner = scanner;

    }
    protected int vstup(String vyzva) {
        int vstupUzivatela;
        while (true) {
            try {
                System.out.print(vyzva);
                vstupUzivatela = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Nesprávny formát vstupu. Zadajte celé číslo.");
                scanner.nextLine();
            }
        }
        return vstupUzivatela;
    }

    protected void vypisUlozeneKnihy() {
        System.out.printf("%6s | %-40s | %-30s | %-30s | %-40s | %4s | %-30s\n\n",
                "INDEX", "NÁZOV", "AUTOR", "ŽÁNER", "VYDAVATEĽSTVO", "ROK", "CENA");
        for (int i = 0; i < zoznamKnih.size(); i++){
            zoznamKnih.get(i).zobrazKnihu(i);
        }
        System.out.println();
    }

    protected boolean jeKnihaUlozena(int index) {
        return index >= 0 && index < zoznamKnih.size();
    }

    protected void vypisKnihu() {
        int index = vstup("Zadajte poradie knihy: ");
        if (jeKnihaUlozena(index)) {
            zoznamKnih.get(index).zobrazKnihu();
        } else {
            System.out.println("Nepodarilo sa vypísať informácie o knihe\n");
        }
    }
    protected void vstupHladanieNazvuKnihy(){
        System.out.print("Zadajte názov hľadanej knihy: ");
        String nazov = scanner.nextLine().trim();
        najdiKnihu(nazov).forEach(Kniha::zobrazKnihu);
        System.out.println();

    }

    protected ArrayList<Kniha> najdiKnihu(String nazov) {
        ArrayList<Kniha> najdeneKnihy = new ArrayList<>();
        if (!nazov.isBlank()) {
            nazov = nazov.toLowerCase();

            for (Kniha kniha : zoznamKnih) {
                if (kniha.getNazov().toLowerCase().contains(nazov)) {
                    najdeneKnihy.add(kniha);
                }
            }
        }
        return najdeneKnihy;
    }

    protected void pridajKnihu() {
        Kniha novaKniha = vytvorKnihu();
        zoznamKnih.add(novaKniha);
        System.out.println("\nPridanie knihy " + novaKniha.getNazov() + " prebehlo úspešne.\n");
    }

    protected Kniha vytvorKnihu() {
        System.out.println("Tvorba knihy: ");
        System.out.print("\tZadajte názov: ");
        String nazov = scanner.nextLine().trim();
        System.out.print("\tZadajte autora: ");
        String autor = scanner.nextLine().trim();
        System.out.print("\tZadajte žáner: ");
        String zaner = scanner.nextLine().trim();
        System.out.print("\tZadajte vydavateľstvo: ");
        String vydavatelstvo = scanner.nextLine().trim();
        int rokVydania = vstup("\tZadajte rok vydania: ");
        return new Kniha(autor, nazov, zaner, vydavatelstvo, rokVydania);
    }

    protected void vymazKnihu() {
        int index = vstup("Zadajte poradie knihy na vymazanie: ");

        if (jeKnihaUlozena(index)) {
            zoznamKnih.remove(index);
            System.out.println("Kniha bola úspešne vymazaná.");
        } else {
            System.out.println("Nepodarilo sa vymazať knihu s indexom: " + index);
        }
    }

    protected void zmazKniznicuKnih() {
        System.out.print("!!! Naozaj chcete zmazať všetky knihy v knižnici? (y/n) ");
        String vstup = scanner.nextLine().toLowerCase().trim();
        if (vstup.equals("y")) {
            zoznamKnih.clear();
            System.out.println("Všetky knihy v knižnici boli úspešne zmazané!");
        }
        System.out.println();
    }
    public int getPocetKnih() {
        return zoznamKnih.size();
    }
}
