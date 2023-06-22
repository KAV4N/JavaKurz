package day11.databazaKnih;

public class Kniha {
	private String autor;
	private String nazov;
	private String zaner;
	private String vydavatelstvo;
	private String rokVydania;


	public Kniha(String autor, String nazov, String zaner, String vydavatelstvo, String rokVydania) {
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

	public String getRokVydania() {
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

	public void setRokVydania(String rokVydania) {
		this.rokVydania = rokVydania;
	}
}
