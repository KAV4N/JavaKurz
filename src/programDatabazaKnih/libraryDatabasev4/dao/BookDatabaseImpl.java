package programDatabazaKnih.libraryDatabasev4.dao;
import programDatabazaKnih.libraryDatabasev4.models.Book;
import programDatabazaKnih.libraryDatabasev4.models.BookStorage;

import java.util.LinkedHashMap;
import java.util.LinkedList;


public class BookDatabaseImpl implements BookDatabase {
	private BookStorage bookData;
	public BookDatabaseImpl(){
		bookData = new BookStorage();
	}



	@Override
	public void addBook(Book book){
		int token = bookData.getDatabaseSize();
		if (!bookData.getMissingKeys().isEmpty()){
			token = bookData.getMissingKeys().removeFirst();
		}
		bookData.getBookMap().put(token, book);
	}

	@Override
	public boolean deleteBook(int token){
		boolean bookDeleted = false;
		if (isBookStored(token)) {
			bookData.getBookMap().remove(token);
			bookData.getMissingKeys().add(token);
			bookDeleted = true;
		}
		return bookDeleted;
	}

	@Override
	public void clearDatabase(){
		bookData.setBookMap(new LinkedHashMap<>());
		bookData.setMissingKeys(new LinkedList<>());
	}

	@Override
	public LinkedHashMap<Integer,Book> findBookByTitle(String title) {
		LinkedHashMap<Integer,Book> foundBooks = new LinkedHashMap<>();
		if (!title.isBlank()) {
			Book book;
			for (Integer token: bookData.getBookMap().keySet()) {
				book = bookData.getBookMap().get(token);
				if (book.getTitle().contains(title)){
					foundBooks.put(token, book);
				}
			}
		}
		return foundBooks;
	}

	@Override
	public Book findBookByIndex(int index) {
		Book book = null;
		if (index >= 0 && index < bookData.getDatabaseSize()) {
			book = bookData.getBookMap().get(index);
		}
		return book;
	}

	public int getSize() {
		return bookData.getDatabaseSize();
	}

	public boolean isBookStored(int index) {
		return index >= 0 && index < bookData.getBookMap().size();
	}
	public BookStorage getBookData(){
		return bookData;
	}
	public void setBookData(BookStorage bookData){
		this.bookData = bookData;
		this.bookData.setBackupBookMap(new LinkedHashMap<>(this.bookData.getBookMap()));
	}
}
