package day13.databazaKnihv3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


final public class PouzivatelskeRozhranieDatabazyKnih extends DatabazaKnih {
    private final Scanner scanner;

    public PouzivatelskeRozhranieDatabazyKnih(Scanner scanner) {
        this.scanner = scanner;
        naplnKniznicu();
    }
    private void naplnKniznicu(){
        pridajKnihu(new Kniha("J.R.R. Tolkien", "Pán prsteňov: Spoločenstvo prsteňa", "Fantasy", "Albatros", 1954));
        pridajKnihu(new Kniha("George Orwell", "1984", "Fikcia", "Secker & Warburg", 1949));
        pridajKnihu(new Kniha("Harper Lee", "Neznesiteľná ľahkosť bytia", "Román", "J.B. Lippincott & Co.", 1960));
        pridajKnihu(new Kniha("F. Scott Fitzgerald", "Veľký Gatsby", "Román", "Charles Scribner's Sons", 1925));
        pridajKnihu(new Kniha("Gabriel García Márquez", "Sto rokov samoty", "Magický realizmus", "Editorial Sudamericana", 1967));
        pridajKnihu(new Kniha("Leo Tolstoy", "Vojna a mier", "Historický román", "The Russian Messenger", 1869));
        pridajKnihu(new Kniha("Jane Austen", "Hrdinka románu", "Román", "Thomas Egerton", 1813));
        pridajKnihu(new Kniha("Markus Zusak", "Zlodejka kníh", "Historický román", "Picador", 2005));
        pridajKnihu(new Kniha("J.D. Salinger", "Kto chytá v žite", "Román", "Little, Brown and Company", 1951));
        pridajKnihu(new Kniha("J.K. Rowling", "Harry Potter a Kameň mudrcov", "Fantasy", "Bloomsbury", 1997));
        pridajKnihu(new Kniha("Ray Bradbury", "451 stupňov Fahrenheita", "Sci-fi", "Ballantine Books", 1953));
        pridajKnihu(new Kniha("Ernest Hemingway", "Starí a more", "Román", "Charles Scribner's Sons", 1952));
        pridajKnihu(new Kniha("Hermann Hesse", "Stepný vlk", "Román", "S. Fischer Verlag", 1927));
        pridajKnihu(new Kniha("Emily Brontë", "Veterný vrch", "Román", "Thomas Cautley Newby", 1847));
        pridajKnihu(new Kniha("Aldous Huxley", "Nová odveta", "Sci-fi", "Chatto & Windus", 1932));
        pridajKnihu(new Kniha("Victor Hugo", "Biedny vrah", "Román", "A. Lacroix, Verboeckhoven & Cie.", 1869));
        pridajKnihu(new Kniha("Lewis Carroll", "Alenka v kraji zázrakov", "Detská literatúra", "Macmillan", 1865));
        pridajKnihu(new Kniha("Terry Pratchett", "Farma zvierat", "Fantasy", "Gollancz", 1984));
        pridajKnihu(new Kniha("John Steinbeck", "Hrozny hnevu", "Román", "The Viking Press", 1939));
        pridajKnihu(new Kniha("Charlotte Brontë", "Jana Eyrová", "Román", "Smith, Elder & Co.", 1847));
    }

    public void spusti() {
        String volba;
        while (true) {
            zobrazMenu();
            System.out.print("Vyberte možnosť: ");
            volba = scanner.nextLine();
            if (volba.equals("koniec")) {
                break;
            } else{
                vykonajAkciu(volba);
            }
        }
        ukonciProgram();
    }

    private void zobrazMenu() {
        System.out.println("""
        ================================
                     MENU
        ================================
        1. Pridať novú knihu
        2. Zobraziť všetky knihy
        3. Zobraziť konkrétnu knihu (podľa indexu)
        4. Vymazať konkrétnu knihu (podľa indexu)
        5. Zobraziť počet všetkých kníh
        6. Hľadať knihu podľa názvu
        9. Vymazať všetky knihy
        koniec - Skončiť zadávanie nových kníh
        ================================
        """);

        System.out.println();
    }

    private void vykonajAkciu(String volba) {
        switch (volba) {
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

    private void vypisUlozeneKnihy() {
        System.out.printf("%6s | %-40s | %-30s | %-30s | %-40s | %4s | %-30s\n",
                "INDEX", "NÁZOV", "AUTOR", "ŽÁNER", "VYDAVATEĽSTVO", "ROK", "CENA");
        ArrayList<Kniha> knihy = getZoznamKnih();
        for (int i = 0; i < knihy.size(); i++) {
            knihy.get(i).zobrazKnihu(i);
        }
        System.out.println();
    }

    private void vypisKnihu() {
        int index = vstup("Zadajte poradie knihy: ");
        if (jeKnihaUlozena(index)) {
            getZoznamKnih().get(index).zobrazKnihu();
        } else {
            System.out.println("Nepodarilo sa vypísať informácie o knihe\n");
        }
    }

    private void vstupHladanieNazvuKnihy() {
        System.out.print("Zadajte názov hľadanej knihy: ");
        String nazov = scanner.nextLine().trim();
        ArrayList<Kniha> najdeneKnihy = najdiKnihu(nazov);
        najdeneKnihy.forEach(Kniha::zobrazKnihu);
        System.out.println();
    }

    private void pridajKnihu() {
        Kniha novaKniha = vytvorKnihu();
        pridajKnihu(novaKniha);
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
            vymazKnihu(index);
            System.out.println("Kniha bola úspešne vymazaná.");
        } else {
            System.out.println("Nepodarilo sa vymazať knihu s indexom: " + index);
        }
    }

    private void zmazKniznicuKnih() {
        System.out.print("!!! Naozaj chcete zmazať všetky knihy v knižnici? (y/n) ");
        String vstup = scanner.nextLine().toLowerCase().trim();
        if (vstup.equals("y")) {
            getZoznamKnih().clear();
            System.out.println("Všetky knihy v knižnici boli úspešne zmazané!");
        }
        System.out.println();
    }

    private void ukonciProgram() {
        System.out.println("Program sa ukončuje.");
        System.exit(0);
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
}
