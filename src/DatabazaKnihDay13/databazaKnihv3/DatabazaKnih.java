package DatabazaKnihDay13.databazaKnihv3;

import java.io.*;
import java.util.ArrayList;

public class DatabazaKnih {
    protected ArrayList<Kniha> zoznamKnih = new ArrayList<>();
    protected ArrayList<Kniha> zalohaZoznamKnih = null;
    final String cestaZalohy = "stavDatabazyKnih/databaza.ser";

    protected void pridajKnihu(Kniha kniha) {
        zoznamKnih.add(kniha);
    }

    protected void vymazKnihu(int index) {
        if (jeKnihaUlozena(index)) {
            zoznamKnih.remove(index);
        }
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

    private void vytvorDatabazaSer(){
        try {
            File myObj = new File(cestaZalohy);
            myObj.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected boolean ulozStavDatabazy(){
        boolean uspech = false;
        vytvorDatabazaSer();
        try {
            File subor = new File(cestaZalohy);
            FileOutputStream vystupSubor = new FileOutputStream(subor);
            ObjectOutputStream vystupData = new ObjectOutputStream(vystupSubor);
            vystupData.writeObject(zoznamKnih);
            vystupData.close();
            vystupSubor.close();
            uspech = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return uspech;
    }

    protected boolean nacitajStavDatabazy() {
        boolean uspech = false;
        vytvorDatabazaSer();
        try {
            File subor = new File(cestaZalohy);
            if (subor.length()!=0){
                FileInputStream vstupnySubor = new FileInputStream(subor);
                ObjectInputStream vstup = new ObjectInputStream(vstupnySubor);
                zoznamKnih = (ArrayList<Kniha>) vstup.readObject();
                zalohaZoznamKnih = new ArrayList<>(zoznamKnih);
                vstup.close();
                vstupnySubor.close();
            }
            else{
                zoznamKnih = new ArrayList<Kniha>();
            }
            uspech = true;
        } catch (Exception e) {
            zoznamKnih = new ArrayList<Kniha>();
            e.printStackTrace();
        }
        return uspech;
    }



    protected boolean jeKnihaUlozena(int index) {
        return index >= 0 && index < zoznamKnih.size();
    }
    public int getPocetKnih() {
        return zoznamKnih.size();
    }
    protected ArrayList<Kniha> getZoznamKnih() {
        return zoznamKnih;
    }



}
