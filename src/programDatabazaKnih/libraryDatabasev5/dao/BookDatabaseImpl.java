package programDatabazaKnih.libraryDatabasev5.dao;
import programDatabazaKnih.libraryDatabasev5.models.Author;
import programDatabazaKnih.libraryDatabasev5.models.Book;
import programDatabazaKnih.libraryDatabasev5.models.LibraryStorage;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;


public class BookDatabaseImpl implements BookDatabase {
	private LibraryStorage bookData;
	public BookDatabaseImpl(){
		bookData = new LibraryStorage();
	}

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
	@Override
	public boolean addAuthor(Author author){
		boolean succes = false;
		if (!bookData.getAuthorsToBooks().containsKey(author)) {
			bookData.getAuthorsToBooks().put(author, new ArrayList<Integer>());
			succes = true;
		}
		return succes;
	}

	@Override
	public boolean addBook(Book book){
		boolean authorFound = false;
		Author author = getAuthor(book.getAuthorName());
		if (author != null) {
			int token = 0;
			if (!bookData.getBookList().isEmpty()) {
				token = bookData.getBookList().getLast().getToken()+1;
			}
			book.setAuthor(author);
			book.setToken(token);
			bookData.getBookList().add(book);
			bookData.getAuthorsToBooks().get(author).add(token);
			authorFound = true;
		}
		return authorFound;
	}



	@Override
	public boolean deleteBook(int token){
		boolean bookDeleted = false;
		if (findBookByToken(token) != null){
			bookData.getAuthorsToBooks().get(bookData.getBookList().get(token).getAuthor()).remove(token);
			bookData.getBookList().remove(token);
			bookDeleted = true;
		}
		return bookDeleted;
	}

	@Override
	public Book findBookByToken(int token) {
		Book newBook = null;
		for (Book book : bookData.getBookList()) {
			if (book.getToken() == token) {
				newBook = book;
				break;
			}
		}
		return newBook;
	}

	@Override
	public boolean deleteAuthor(String name){
		boolean authorFound = false;
		for (Author author : bookData.getAuthorsToBooks().keySet()){
			if(author.getName().equals(name)){
				authorFound = true;
				ArrayList<Integer> bookList = bookData.getAuthorsToBooks().get(author);
				for (int token : bookList){
					deleteBook(token);
				}
				bookData.getAuthorsToBooks().remove(author);
				break;
			}
		}
		return authorFound;
	}

	@Override
	public void clearDatabase(){
		bookData.setBookList(new LinkedList<>() );
		bookData.setAuthorsToBooks(new LinkedHashMap<>());
	}

	@Override
	public ArrayList<Book>  findBookByTitle(String title) {
		ArrayList<Book>  foundBooks = new ArrayList<>();
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
		if (index >= 0 && index < bookData.getBookList().size()) {
			book = bookData.getBookList().get(index);
		}
		return book;
	}

	@Override
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

	@Override
	public int getSize() {
		return bookData.getBookList().size();
	}

	@Override
	public LibraryStorage getBookData(){
		return bookData;
	}
	@Override
	public void setBookData(LibraryStorage bookData){
		this.bookData = bookData;
		this.bookData.setBackupAuthorsToBooks(new LinkedHashMap<>(this.bookData.getAuthorsToBooks()));
	}
}
