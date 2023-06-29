package days3to12.day12.databazaKnih;

public class Kniha {
	private String autor;
	private String nazov;
	private String zaner;
	private String vydavatelstvo;
	private int rokVydania;


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
	public void printInformacie(){
		System.out.println("\tNazov knihy: " + nazov);
		System.out.println("\tAutor knihy: " + autor);
		System.out.println("\tZaner knihy: " + zaner);
		System.out.println("\tVydavatelstvo knihy: " + vydavatelstvo);
		System.out.println("\tRok vydania: " + rokVydania);

	}

}
