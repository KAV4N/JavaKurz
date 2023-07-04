package programDatabazaKnih.libraryDatabasev4.dao;
import programDatabazaKnih.libraryDatabasev4.models.Author;
import programDatabazaKnih.libraryDatabasev4.models.Book;
import programDatabazaKnih.libraryDatabasev4.models.LibraryStorage;

import java.util.ArrayList;
import java.util.LinkedHashMap;



public class BookDatabaseImpl implements BookDatabase {
	private LibraryStorage bookData;
	public BookDatabaseImpl(){
		bookData = new LibraryStorage();
	}

	public void insertStockLibrary(){
		Author author1 = new Author("J.R.R. Tolkien");
		Author author2 = new Author("George Orwell");
		Author author3 = new Author("Harper Lee");

		Book book1 = new Book( "Pán prsteňov: Spoločenstvo prsteňa",author1, "Fantasy", "Albatros", 1954);
		Book book2 = new Book("1984",author2,  "Fikcia", "Secker & Warburg", 1949);
		Book book3 = new Book( "Neznesiteľná ľahkosť bytia",author3, "Román", "J.B. Lippincott & Co.", 1960);

		addAuthor(author1);
		addAuthor(author2);
		addAuthor(author3);

		addBook(book1);
		addBook(book2);
		addBook(book3);

	}
	@Override
	public void addAuthor(Author author){
		bookData.getAuthorsToBooks().put(author, new ArrayList<Book>());
	}

	@Override
	public boolean addBook(Book book){
		boolean authorFound = false;
		Author author = getAuthor(book.getAuthorName());
		if (author != null) {
			book.setAuthor(author);
			bookData.getAuthorsToBooks().get(getAuthor(book.getAuthorName())).add(book);
			bookData.getBookList().add(book);
			authorFound = true;
		}
		return authorFound;
	}

	@Override
	public boolean deleteBook(int token){
		boolean bookDeleted = false;
		if (isBookStored(token)) {
			Book book = bookData.getBookList().get(token);
			bookData.getBookList().remove(token);
			bookData.getAuthorsToBooks().get(book.getAuthor()).remove(book);
			bookDeleted = true;
		}
		return bookDeleted;
	}

	@Override
	public void clearDatabase(){
		bookData.setBookList(new ArrayList<>());
		for (Author a: bookData.getAuthorsToBooks().keySet()){
			bookData.getAuthorsToBooks().get(a).clear();
		}
	}

	@Override
	public ArrayList<Book> findBookByTitle(String title) {
		ArrayList<Book> foundBooks = new ArrayList<>();
		if (!title.isBlank()) {
			for (Book book: bookData.getBookList()) {
				if (book.getTitle().contains(title)){
					foundBooks.add(book);
				}
			}
		}
		return foundBooks;
	}

	@Override
	public Book findBookByIndex(int index) {
		Book book = null;
		if (index >= 0 && index < bookData.getDatabaseSize()) {
			book = bookData.getBookList().get(index);
		}
		return book;
	}

	public Author getAuthor(String name){
		Author author = null;
		if (!name.isBlank()) {
			for (Author a: bookData.getAuthorsToBooks().keySet()) {
				if (a.getName().contains(name)){
					author = a;
				}
			}
		}
		return author;
	}

	public int getSize() {
		return bookData.getBookList().size();
	}

	public boolean isBookStored(int index) {
		return index >= 0 && index < bookData.getBookList().size();
	}
	public LibraryStorage getBookData(){
		return bookData;
	}
	public void setBookData(LibraryStorage bookData){
		this.bookData = bookData;
		this.bookData.setBackupAuthorsToBooks(new LinkedHashMap<>(this.bookData.getAuthorsToBooks()));
	}
}
