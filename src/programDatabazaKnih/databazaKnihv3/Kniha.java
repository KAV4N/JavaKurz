package programDatabazaKnih.databazaKnihv3;

import java.io.Serializable;

public class Kniha implements Serializable {

	private String autor = "";
	private String nazov = "";
	private String zaner = "";
	private String vydavatelstvo = "";
	private int rokVydania;
	private double cena = 0;

	public Kniha(String autor, String nazov, String zaner, String vydavatelstvo, int rokVydania) {
		this.autor = autor;
		this.nazov = nazov;
		this.zaner = zaner;
		this.vydavatelstvo = vydavatelstvo;
		this.rokVydania = rokVydania;
	}

	public String getAutor() {
		return autor;
	}

	public String getNazov() {
		return nazov;
	}

	public String getZaner() {
		return zaner;
	}

	public String getVydavatelstvo() {
		return vydavatelstvo;
	}

	public int getRokVydania() {
		return rokVydania;
	}

	public double getCena() {
		return cena;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setNazov(String nazov) {
		this.nazov = nazov;
	}

	public void setZaner(String zaner) {
		this.zaner = zaner;
	}

	public void setVydavatelstvo(String vydavatelstvo) {
		this.vydavatelstvo = vydavatelstvo;
	}

	public void setRokVydania(int rokVydania) {
		this.rokVydania = rokVydania;
	}

	public void setCena(double cena) {
		if (cena < 0){
			cena = 0;
		}
		this.cena = cena;
	}
	public void zobrazKnihu(int idx) {
		System.out.printf("%6d | %-40s | %-30s | %-30s | %-40s | %4d | %.2f €\n",
				idx, getNazov(), getAutor(), getZaner(), getVydavatelstvo(), getRokVydania(), getCena());
	}


	public void zobrazKnihu(){
		System.out.println("\tNazov knihy: " + getNazov());
		System.out.println("\tAutor knihy: " + getAutor());
		System.out.println("\tZaner knihy: " + getZaner());
		System.out.println("\tVydavatelstvo knihy: " + getVydavatelstvo());
		System.out.println("\tRok vydania: " + getRokVydania());
		System.out.printf("\tCena:  %.2f €\n", getCena());

	}
	@Override
	public String toString() {
		return "Kniha{" +
				"autor='" + autor + '\'' +
				", nazov='" + nazov + '\'' +
				", zaner='" + zaner + '\'' +
				", vydavatelstvo='" + vydavatelstvo + '\'' +
				", rokVydania=" + rokVydania +
				'}';
	}

}
