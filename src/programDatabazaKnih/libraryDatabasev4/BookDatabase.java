package programDatabazaKnih.libraryDatabasev4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;


public class BookDatabase {
	protected BookStorage bookData;

	public BookDatabase(){
		bookData = new BookStorage();
	}
	protected void addBook(Book book) {
		bookData.addBook(book);
	}

	protected void deleteBook(int index) {
		if (isBookStored(index)) {
			bookData.removeBook(index);
		}
	}
	protected void clearDatabase(){
		bookData.setBookMap(new LinkedHashMap<>());
		bookData.setMissingKeys(new LinkedList<>());
	}

	protected LinkedHashMap<Integer,Book> findBook(String title) {
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
	public Book getBookByIndex(int index) {
		Book book = null;
		if (index >= 0 && index < bookData.getDatabaseSize()) {
			book = bookData.getBookMap().get(index);
		}
		return book;
	}

	public int getSize() {
		return bookData.getDatabaseSize();
	}

	protected boolean isBookStored(int index) {
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
