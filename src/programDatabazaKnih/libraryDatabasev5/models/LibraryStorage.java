package programDatabazaKnih.libraryDatabasev5.models;

import java.io.Serializable;
import java.util.*;

public class LibraryStorage implements Serializable {

	private LinkedList<Book> bookList = new LinkedList<>();
	private LinkedHashMap<Author, ArrayList<Integer>> authorsToBooks = new LinkedHashMap<>();
	private LinkedHashMap<Author, ArrayList<Integer>> backupAuthorsToBooks = new LinkedHashMap<>();

	public LinkedHashMap<Author, ArrayList<Integer>> getAuthorsToBooks() {
		return authorsToBooks;
	}

	public LinkedList<Book> getBookList() {
		return bookList;
	}

	public void setBookList(LinkedList<Book> bookList) {
		this.bookList = bookList;
	}

	public void setAuthorsToBooks(LinkedHashMap<Author, ArrayList<Integer>> authorsToBooks) {
		this.authorsToBooks = authorsToBooks;
	}

	public LinkedHashMap<Author, ArrayList<Integer>> getBackupAuthorsToBooks() {
		return backupAuthorsToBooks;
	}

	public void setBackupAuthorsToBooks(LinkedHashMap<Author, ArrayList<Integer>> backupAuthorsToBooks) {
		this.backupAuthorsToBooks = backupAuthorsToBooks;
	}
}
