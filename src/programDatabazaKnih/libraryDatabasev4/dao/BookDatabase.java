package programDatabazaKnih.libraryDatabasev4.dao;

import programDatabazaKnih.libraryDatabasev4.models.Book;

import java.util.LinkedHashMap;

public interface BookDatabase {
	void addBook(Book book);

	boolean deleteBook(int token);

	void clearDatabase();

	LinkedHashMap<Integer, Book> findBookByTitle(String title);

	Book findBookByIndex(int idx);
}
