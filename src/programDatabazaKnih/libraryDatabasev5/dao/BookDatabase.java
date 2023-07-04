package programDatabazaKnih.libraryDatabasev5.dao;

import programDatabazaKnih.libraryDatabasev5.models.Author;
import programDatabazaKnih.libraryDatabasev5.models.Book;
import programDatabazaKnih.libraryDatabasev5.models.LibraryStorage;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public interface BookDatabase {
	//	public void insertStockLibrary(){
	//		Author author1 = new Author("J.R.R. Tolkien");
	//		Author author2 = new Author("George Orwell");
	//		Author author3 = new Author("Harper Lee");
	//
	//		Book book1 = new Book( "Pán prsteňov: Spoločenstvo prsteňa",author1, "Fantasy", "Albatros", 1954);
	//		Book book2 = new Book("1984",author2,  "Fikcia", "Secker & Warburg", 1949);
	//		Book book3 = new Book( "Neznesiteľná ľahkosť bytia",author3, "Román", "J.B. Lippincott & Co.", 1960);
	//
	//		addAuthor(author1);
	//		addAuthor(author2);
	//		addAuthor(author3);
	//
	//		addBook(book1);
	//		addBook(book2);
	//		addBook(book3);
	//
	//	}
	boolean addAuthor(Author author);

	boolean addBook(Book book);

	boolean deleteBook(int token);

	boolean deleteAuthor(String name);

	void clearDatabase();

	ArrayList<Book> findBookByTitle(String title);

	Book findBookByIndex(int index);

	Author getAuthor(String name);

	int getSize();

	Book findBookByToken(int token);
	LibraryStorage getBookData();

	void setBookData(LibraryStorage bookData);
}
