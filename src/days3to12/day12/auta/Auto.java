package days3to12.day12.auta;

public class Auto {
    private String znacka;
    private String farba ;
    private double maxRychlost;

    public Auto(String znacka, String farba, double maxRychlost) {
        this.maxRychlost = maxRychlost;
        this.farba = farba;
        this.znacka = znacka;
    }

    public double getMaxRychlost() {
        return maxRychlost;
    }

    public void setMaxRychlost(double maxRychlost) {
        this.maxRychlost = maxRychlost;
    }

    public String getFarba() {
        return farba;
    }

    public void setFarba(String farba) {
        this.farba = farba;
    }

    public String getZnacka() {
        return znacka;
    }

    public void setZnacka(String znacka) {
        this.znacka = znacka;
    }

    public void printInformacie(){
        System.out.println("\tZnacka auta: " + getZnacka());
        System.out.println("\tFarba auta: " + getFarba());
        System.out.println("\tMaximalna rychlost auta: " + getMaxRychlost() + " km/h");
    }

}
