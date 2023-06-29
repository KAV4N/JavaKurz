package DatabazaKnihDay13.databazaKnihv2;

import java.util.Scanner;

public final class DatabazaKnih extends JadroDatabazyKnih{

    public DatabazaKnih(Scanner scanner) {
        super(scanner);
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
}
