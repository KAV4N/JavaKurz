package programDatabazaKnih.databazaKnih;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DatabazaKnih {
    private final ArrayList<Kniha> zoznamKnih = new ArrayList<>();
    private final Scanner scanner;

    public DatabazaKnih(Scanner scanner) {
        this.scanner = scanner;
        naplnKniznicu();
    }

    private void naplnKniznicu(){
        zoznamKnih.add(new Kniha("J.R.R. Tolkien", "Pán prsteňov: Spoločenstvo prsteňa", "Fantasy", "Albatros", 1954));
        zoznamKnih.add(new Kniha("George Orwell", "1984", "Fikcia", "Secker & Warburg", 1949));
        zoznamKnih.add(new Kniha("Harper Lee", "Neznesiteľná ľahkosť bytia", "Román", "J.B. Lippincott & Co.", 1960));
        zoznamKnih.add(new Kniha("F. Scott Fitzgerald", "Veľký Gatsby", "Román", "Charles Scribner's Sons", 1925));
        zoznamKnih.add(new Kniha("Gabriel García Márquez", "Sto rokov samoty", "Magický realizmus", "Editorial Sudamericana", 1967));
        zoznamKnih.add(new Kniha("Leo Tolstoy", "Vojna a mier", "Historický román", "The Russian Messenger", 1869));
        zoznamKnih.add(new Kniha("Jane Austen", "Hrdinka románu", "Román", "Thomas Egerton", 1813));
        zoznamKnih.add(new Kniha("Markus Zusak", "Zlodejka kníh", "Historický román", "Picador", 2005));
        zoznamKnih.add(new Kniha("J.D. Salinger", "Kto chytá v žite", "Román", "Little, Brown and Company", 1951));
        zoznamKnih.add(new Kniha("J.K. Rowling", "Harry Potter a Kameň mudrcov", "Fantasy", "Bloomsbury", 1997));
        zoznamKnih.add(new Kniha("Ray Bradbury", "451 stupňov Fahrenheita", "Sci-fi", "Ballantine Books", 1953));
        zoznamKnih.add(new Kniha("Ernest Hemingway", "Starí a more", "Román", "Charles Scribner's Sons", 1952));
        zoznamKnih.add(new Kniha("Hermann Hesse", "Stepný vlk", "Román", "S. Fischer Verlag", 1927));
        zoznamKnih.add(new Kniha("Emily Brontë", "Veterný vrch", "Román", "Thomas Cautley Newby", 1847));
        zoznamKnih.add(new Kniha("Aldous Huxley", "Nová odveta", "Sci-fi", "Chatto & Windus", 1932));
        zoznamKnih.add(new Kniha("Victor Hugo", "Biedny vrah", "Román", "A. Lacroix, Verboeckhoven & Cie.", 1869));
        zoznamKnih.add(new Kniha("Lewis Carroll", "Alenka v kraji zázrakov", "Detská literatúra", "Macmillan", 1865));
        zoznamKnih.add(new Kniha("Terry Pratchett", "Farma zvierat", "Fantasy", "Gollancz", 1984));
        zoznamKnih.add(new Kniha("John Steinbeck", "Hrozny hnevu", "Román", "The Viking Press", 1939));
        zoznamKnih.add(new Kniha("Charlotte Brontë", "Jana Eyrová", "Román", "Smith, Elder & Co.", 1847));
    }

    public static void vypisMoznosti() {
        System.out.println("""
                1. Zadaj novú knihu
                2. Zobraz všetky knihy
                3. Zobraz konkrétnu knihu (podľa indexu)
                4. Vymaž konkrétnu knihu (podľa indexu)
                5. Zobraz počet všetkých kníh
                6. Hľadanie knihy v knižnici pomocou názvu
                9. Vymaž všetky knihy
                koniec = skončí zadávanie novej knihy
                """);
    }
    private int vstup(String vyzva) {
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

    private void vypisUlozeneKnihy() {
        System.out.printf("%6s | %-40s | %-30s | %-30s | %-40s | %4s | %-30s\n\n",
                "INDEX", "NÁZOV", "AUTOR", "ŽÁNER", "VYDAVATEĽSTVO", "ROK", "CENA");
        for (int i = 0; i < zoznamKnih.size(); i++){
            zoznamKnih.get(i).zobrazKnihu(i);
        }
        System.out.println();
    }

    private boolean jeKnihaUlozena(int index) {
        return index >= 0 && index < zoznamKnih.size();
    }

    private void vypisKnihu() {
        int index = vstup("Zadajte poradie knihy: ");
        if (jeKnihaUlozena(index)) {
            zoznamKnih.get(index).zobrazKnihu();
        } else {
            System.out.println("Nepodarilo sa vypísať informácie o knihe\n");
        }
    }
    private void vstupHladanieNazvuKnihy(){
        System.out.print("Zadajte názov hľadanej knihy: ");
        String nazov = scanner.nextLine().trim();
        najdiKnihu(nazov).forEach(Kniha::zobrazKnihu);
        System.out.println();

    }

    private ArrayList<Kniha> najdiKnihu(String nazov) {
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

    private void pridajKnihu() {
        Kniha novaKniha = vytvorKnihu();
        zoznamKnih.add(novaKniha);
        System.out.println("\nPridanie knihy " + novaKniha.getNazov() + " prebehlo úspešne.\n");
    }

    private Kniha vytvorKnihu() {
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

    private void vymazKnihu() {
        int index = vstup("Zadajte poradie knihy na vymazanie: ");

        if (jeKnihaUlozena(index)) {
            zoznamKnih.remove(index);
            System.out.println("Kniha bola úspešne vymazaná.");
        } else {
            System.out.println("Nepodarilo sa vymazať knihu s indexom: " + index);
        }
    }

    private void zmazKniznicuKnih() {
        System.out.print("!!! Naozaj chcete zmazať všetky knihy v knižnici? (y/n) ");
        String vstup = scanner.nextLine().toLowerCase().trim();
        if (vstup.equals("y")) {
            zoznamKnih.clear();
            System.out.println("Všetky knihy v knižnici boli úspešne zmazané!");
        }
        System.out.println();
    }

    public void vyberMoznosti(String moznost) {
        switch (moznost) {
            case "1":
                pridajKnihu();
                break;
            case "2":
                vypisUlozeneKnihy();
                break;
            case "3":
                vypisKnihu();
                break;
            case "4":
                vymazKnihu();
                break;
            case "5":
                System.out.println("Počet kníh v knižnici: " + getPocetKnih());
                break;
            case "6":
                vstupHladanieNazvuKnihy();
                break;
            case "9":
                zmazKniznicuKnih();
                break;
            default:
                System.out.println("Vyberte voľbu z menu!");
                break;
        }
    }

    public int getPocetKnih() {
        return zoznamKnih.size();
    }
}
