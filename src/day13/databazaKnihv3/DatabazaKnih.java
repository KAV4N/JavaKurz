package day13.databazaKnihv3;

import java.util.ArrayList;

public class DatabazaKnih {
    protected ArrayList<Kniha> zoznamKnih = new ArrayList<>();

    protected void pridajKnihu(Kniha kniha) {
        zoznamKnih.add(kniha);
    }

    protected void vymazKnihu(int index) {
        if (jeKnihaUlozena(index)) {
            zoznamKnih.remove(index);
        }
    }

    protected ArrayList<Kniha> getZoznamKnih() {
        return zoznamKnih;
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

    protected boolean jeKnihaUlozena(int index) {
        return index >= 0 && index < zoznamKnih.size();
    }
    public int getPocetKnih() {
        return zoznamKnih.size();
    }
}
