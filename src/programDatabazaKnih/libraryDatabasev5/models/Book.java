package programDatabazaKnih.libraryDatabasev5.models;

import java.io.Serializable;

public class Book implements Serializable {
	public int getToken() {
		return token;
	}

	public void setToken(int token) {
		this.token = token;
	}

	private int token = 0;
	private Author author = null;
	private String authorName = "";
	private String title = "";
	private String genre = "";
	private String publisher = "";
	private int publicationYear;
	private double price = 0;


	public Book(String title, String genre, String publisher, int publicationYear) {
		this.title = title;
		this.genre = genre;
		this.publisher = publisher;
		this.publicationYear = publicationYear;
	}

	public Book(String title, String authorName, String genre, String publisher, int publicationYear) {
		this.title = title;
		this.authorName = authorName;
		this.genre = genre;
		this.publisher = publisher;
		this.publicationYear = publicationYear;
	}

	public Book(String title, Author author, String genre, String publisher, int publicationYear) {
		this.author = author;
		this.authorName = author.getName();
		this.title = title;
		this.genre = genre;
		this.publisher = publisher;
		this.publicationYear = publicationYear;
	}

	public Book(String title, Author author, String genre, String publisher, int publicationYear, double price) {
		this.author = author;
		this.authorName = author.getName();
		this.title = title;
		this.genre = genre;
		this.publisher = publisher;
		this.publicationYear = publicationYear;
		this.price = price;
	}

	public Author getAuthor() {
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

	public void setAuthor(Author author) {
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
		System.out.printf("\t%6d | %-40s | %-30s | %-30s | %-40s | %4d | %.2f €\n",
				idx, getTitle(), getAuthor().getName(), getGenre(), getPublisher(), getPublicationYear(), getPrice());
	}

	public void displayBook() {
		System.out.println("\tTitle: " + getTitle());
		System.out.println("\tAuthor: " + getAuthor().getName());
		System.out.println("\tGenre: " + getGenre());
		System.out.println("\tPublisher: " + getPublisher());
		System.out.println("\tPublication Year: " + getPublicationYear());
		System.out.printf("\tPrice: %.2f €\n", getPrice());
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
}
