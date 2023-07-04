package programDatabazaKnih.libraryDatabasev4.dao;

import programDatabazaKnih.libraryDatabasev4.models.Author;
import programDatabazaKnih.libraryDatabasev4.models.Book;

import java.util.ArrayList;

public interface BookDatabase {
	void addAuthor(Author author);
	boolean addBook(Book book);

	boolean deleteBook(int token);

	void clearDatabase();

	ArrayList<Book> findBookByTitle(String title);

	Book findBookByIndex(int idx);
}
