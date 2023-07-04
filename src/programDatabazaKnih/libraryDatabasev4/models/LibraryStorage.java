package programDatabazaKnih.libraryDatabasev4.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class LibraryStorage implements Serializable {
	private ArrayList<Book> bookList = new ArrayList<>();

	private LinkedHashMap<Integer, Book> bookList2 = new LinkedHashMap<>();
	private LinkedHashMap<Author, ArrayList<Book>> authorsToBooks = new LinkedHashMap<>();
	private LinkedHashMap<Author, ArrayList<Book>> backupAuthorsToBooks = new LinkedHashMap<>();

	public LinkedHashMap<Author, ArrayList<Book>> getAuthorsToBooks() {
		return authorsToBooks;
	}

	public ArrayList<Book> getBookList() {
		return bookList;
	}

	public void setBookList(ArrayList<Book> bookList) {
		this.bookList = bookList;
	}

	public LinkedHashMap<Author, ArrayList<Book>> getBackupAuthorsToBooks() {
		return backupAuthorsToBooks;
	}

	public void setBackupAuthorsToBooks(LinkedHashMap<Author, ArrayList<Book>> backupAuthorsToBooks) {
		this.backupAuthorsToBooks = backupAuthorsToBooks;
	}
	public int getDatabaseSize(){
		return bookList.size();
	}
}
