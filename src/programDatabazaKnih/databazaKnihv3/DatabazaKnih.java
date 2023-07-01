package programDatabazaKnih.databazaKnihv3;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.*;

import java.io.IOException;
import java.io.*;
import java.util.ArrayList;

public class DatabazaKnih {
    protected ArrayList<Kniha> zoznamKnih = new ArrayList<>();
    protected ArrayList<Kniha> zalohaZoznamKnih = new ArrayList<>();
    final private String cestaZalohy = "stavDatabazyKnih/databaza.ser";
    final private String cestaPDF = "vystupKniznice/kniznica.pdf";

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

    protected boolean otvorPDF(){
        boolean uspech = false;
        try{
            File file = new File(cestaPDF);
            Desktop desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.OPEN)) {
                desktop.open(file);
                uspech = true;
            }
        }
        catch (DocumentException | IOException e){
            e.printStackTrace();
        }
        return uspech;
    }

    protected  boolean vytvorPDF() {
        boolean uspech = false;
        try {
            Document dokument = new Document(PageSize.A4,40f,40f,40f,40f);
            PdfPTable tabulka = new PdfPTable(3);
            PdfWriter.getInstance(dokument, new FileOutputStream(cestaPDF));
            dokument.open();

            Paragraph nazov = new Paragraph("Ponuka kníh", new Font(Font.HELVETICA, 24, Font.BOLDITALIC));
            nazov.setAlignment(Element.ALIGN_CENTER);
            nazov.setSpacingAfter(20f);

            dokument.add(nazov);

            tabulka.setWidthPercentage(100);
            tabulka.setWidths(new float[]{40f,40f,20f});
            pridajHlavicku(tabulka);
            for (Kniha kniha : zoznamKnih) {
                pridajRiadok(tabulka, kniha);
            }
            dokument.add(tabulka);
            dokument.close();
            uspech = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return uspech;
    }

    private void pridajHlavicku(PdfPTable table) {
        Font hlavickaFont = new Font(Font.HELVETICA, 12, Font.BOLD);

        PdfPCell nazovHlavicka = new PdfPCell(new Phrase("Názov", hlavickaFont));
        PdfPCell autorHlavicka = new PdfPCell(new Phrase("Autor", hlavickaFont));
        PdfPCell rokVydaniaHlavicka = new PdfPCell(new Phrase("Rok Vydania", hlavickaFont));

        nazovHlavicka.setPadding(10f);
        autorHlavicka.setPadding(10f);
        rokVydaniaHlavicka.setPadding(10f);

        nazovHlavicka.setHorizontalAlignment(Element.ALIGN_CENTER);
        nazovHlavicka.setVerticalAlignment(Element.ALIGN_MIDDLE);
        nazovHlavicka.setBackgroundColor(Color.cyan);

        autorHlavicka.setHorizontalAlignment(Element.ALIGN_CENTER);
        autorHlavicka.setVerticalAlignment(Element.ALIGN_MIDDLE);
        autorHlavicka.setBackgroundColor(Color.cyan);

        rokVydaniaHlavicka.setHorizontalAlignment(Element.ALIGN_CENTER);
        rokVydaniaHlavicka.setVerticalAlignment(Element.ALIGN_MIDDLE);
        rokVydaniaHlavicka.setBackgroundColor(Color.cyan);

        nazovHlavicka.setBorderWidth(1);
        autorHlavicka.setBorderWidth(1);
        rokVydaniaHlavicka.setBorderWidth(1);

        table.addCell(nazovHlavicka);
        table.addCell(autorHlavicka);
        table.addCell(rokVydaniaHlavicka);


    }

    private void pridajRiadok(PdfPTable table, Kniha kniha) {
        Font bunkaFont = new Font(Font.HELVETICA, 10);
        PdfPCell nazovBunka = new PdfPCell(new Phrase(kniha.getNazov(), bunkaFont));
        PdfPCell autorBunka = new PdfPCell(new Phrase(kniha.getAutor(), bunkaFont));
        PdfPCell rokBunka = new PdfPCell(new Phrase(String.valueOf(kniha.getRokVydania()), bunkaFont));

        nazovBunka.setPadding(10f);
        autorBunka.setPadding(10f);
        rokBunka.setPadding(10f);

        rokBunka.setHorizontalAlignment(Element.ALIGN_CENTER);
        rokBunka.setVerticalAlignment(Element.ALIGN_MIDDLE);

        nazovBunka.setBorderWidth(1);
        autorBunka.setBorderWidth(1);
        rokBunka.setBorderWidth(1);

        table.addCell(nazovBunka); // Názov
        table.addCell(autorBunka); // Autor
        table.addCell(rokBunka); // Rok
    }

    private void vytvorDatabazaSer(){
        try {
            File myObj = new File(cestaZalohy);
            myObj.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void vytvorNovyZoznamKnih(){
        zoznamKnih = new ArrayList<Kniha>();
        zalohaZoznamKnih = new ArrayList<Kniha>(zoznamKnih);
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
                vytvorNovyZoznamKnih();
            }
            uspech = true;
        } catch (Exception e) {
            vytvorNovyZoznamKnih();
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
