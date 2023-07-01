package programDatabazaKnih.libraryDatabasev4;

import java.io.Serializable;

public class Book implements Serializable {

	private String author = "";
	private String title = "";
	private String genre = "";
	private String publisher = "";
	private int publicationYear;
	private double price = 0;

	public Book(String author, String title, String genre, String publisher, int publicationYear) {
		this.author = author;
		this.title = title;
		this.genre = genre;
		this.publisher = publisher;
		this.publicationYear = publicationYear;
	}

	public String getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}

	public String getGenre() {
		return genre;
	}

	public String getPublisher() {
		return publisher;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public double getPrice() {
		return price;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public void setPrice(double price) {
		if (price < 0) {
			price = 0;
		}
		this.price = price;
	}

	public void displayBook(int idx) {
		System.out.printf("%6d | %-40s | %-30s | %-30s | %-40s | %4d | %.2f €\n",
				idx, getTitle(), getAuthor(), getGenre(), getPublisher(), getPublicationYear(), getPrice());
	}

	public void displayBook() {
		System.out.println("\tTitle: " + getTitle());
		System.out.println("\tAuthor: " + getAuthor());
		System.out.println("\tGenre: " + getGenre());
		System.out.println("\tPublisher: " + getPublisher());
		System.out.println("\tPublication Year: " + getPublicationYear());
		System.out.printf("\tPrice: %.2f €\n", getPrice());
	}
}
