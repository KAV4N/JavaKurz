package programDatabazaKnih.libraryDatabasev4;

import programDatabazaKnih.libraryDatabasev4.service.BookDatabaseSerializationService;
import programDatabazaKnih.libraryDatabasev4.service.BookPdfExporterService;

import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class LibraryConsole {
	private static final String OPTION_ADD_BOOK = "1";
	private static final String OPTION_DISPLAY_DATABASE = "2";
	private static final String OPTION_FIND_BOOK_BY_IDX = "3";
	private static final String OPTION_FIND_BOOK_BY_NAME = "4";
	private static final String OPTION_DELETE_BOOK_BY_IDX = "5";
	private static final String OPTION_DISPLAY_DATABASE_SIZE = "6";
	private static final String OPTION_SAVE_STATE = "7";
	private static final String OPTION_LOAD_STATE = "8";
	private static final String OPTION_CREATE_PDF_REPORT = "9";
	private static final String OPTION_OPEN_PDF_REPORT = "10";
	private static final String OPTION_DELETE_ALL_BOOKS = "x0x";
	private static final String OPTION_EXIT = "EXIT";

	private static final String MENU_PROMPT = "\nPlease select an option:";
	private static final String MENU_OPTIONS =
					"\tWrite \"" + OPTION_EXIT + "\" to leave the program\n" +
					"\t"+OPTION_ADD_BOOK+". Add Book\n" +
					"\t"+OPTION_DISPLAY_DATABASE+". Display Database\n" +
					"\t"+OPTION_FIND_BOOK_BY_IDX+". Find Book (by index)\n" +
					"\t"+OPTION_FIND_BOOK_BY_NAME+". Find Book (by name)\n" +
					"\t"+OPTION_DELETE_BOOK_BY_IDX+". Delete Book (by index)\n" +
					"\t"+OPTION_DISPLAY_DATABASE_SIZE+". Display database size\n" +
					"\t"+OPTION_SAVE_STATE+". Save State\n" +
					"\t"+OPTION_LOAD_STATE+". Load State\n" +
					"\t"+OPTION_CREATE_PDF_REPORT+". Create PDF Report\n" +
					"\t"+OPTION_OPEN_PDF_REPORT+". Open PDF Report\n" +
					"\t"+OPTION_DELETE_ALL_BOOKS+" - Delete All Books\n";

	private static final String PROMPT_ADD_BOOK = "Enter the book details:";
	private static final String PROMPT_DELETE_BOOK = "Enter the index of the book to delete:";
	private static final String PROMPT_FIND_BOOK = "Enter the title of the book to find:";
	private static final String PROMPT_SAVE_STATE = "Saving the database state...";
	private static final String PROMPT_LOAD_STATE = "Loading the database state...";
	private static final String PROMPT_REPORT_CREATED = "PDF report created!";
	private static final String PROMPT_EXIT = "Exiting the program...";
	private static final String PROMPT_FIND_BOOK_IDX = "Enter the index of book:";
	private static final String PROMPT_CLEAR_DATABASE = "Are you sure you want to delete all the books from the database? (y/n)";
	private static final String PROMPT_SAVE_CHANGES = "Do you want to save changes? (y/n)";

	private BookDatabase database;
	private BookDatabaseSerializationService bookSerializationService;
	private BookPdfExporterService bookPdfExporterService;
	private Scanner scanner;

	public LibraryConsole() {
		scanner = new Scanner(System.in);
	}

	public void start() {
		String userOption = "";
		database = new BookDatabase();
		bookSerializationService = new BookDatabaseSerializationService(database);
		bookPdfExporterService = new BookPdfExporterService(database);
//		stockLibrary();
		while (!userOption.equals(OPTION_EXIT)) {
			displayMenu();
			userOption = getUserOption();
			performAction(userOption);
		}
		scanner.close();
	}

	private void displayMenu() {
		System.out.println(MENU_PROMPT);
		System.out.println(MENU_OPTIONS);
	}

	private void stockLibrary(){
		database.addBook(new Book("J.R.R. Tolkien", "Pán prsteňov: Spoločenstvo prsteňa", "Fantasy", "Albatros", 1954));
		database.addBook(new Book("George Orwell", "1984", "Fikcia", "Secker & Warburg", 1949));
		database.addBook(new Book("Harper Lee", "Neznesiteľná ľahkosť bytia", "Román", "J.B. Lippincott & Co.", 1960));
		database.addBook(new Book("F. Scott Fitzgerald", "Veľký Gatsby", "Román", "Charles Scribner's Sons", 1925));
		database.addBook(new Book("Gabriel García Márquez", "Sto rokov samoty", "Magický realizmus", "Editorial Sudamericana", 1967));
		database.addBook(new Book("Leo Tolstoy", "Vojna a mier", "Historický román", "The Russian Messenger", 1869));
		database.addBook(new Book("Jane Austen", "Hrdinka románu", "Román", "Thomas Egerton", 1813));
		database.addBook(new Book("Markus Zusak", "Zlodejka kníh", "Historický román", "Picador", 2005));
		database.addBook(new Book("J.D. Salinger", "Kto chytá v žite", "Román", "Little, Brown and Company", 1951));
		database.addBook(new Book("J.K. Rowling", "Harry Potter a Kameň mudrcov", "Fantasy", "Bloomsbury", 1997));
		database.addBook(new Book("Ray Bradbury", "451 stupňov Fahrenheita", "Sci-fi", "Ballantine Books", 1953));
		database.addBook(new Book("Ernest Hemingway", "Starí a more", "Román", "Charles Scribner's Sons", 1952));
		database.addBook(new Book("Hermann Hesse", "Stepný vlk", "Román", "S. Fischer Verlag", 1927));
		database.addBook(new Book("Emily Brontë", "Veterný vrch", "Román", "Thomas Cautley Newby", 1847));
		database.addBook(new Book("Aldous Huxley", "Nová odveta", "Sci-fi", "Chatto & Windus", 1932));
		database.addBook(new Book("Victor Hugo", "Biedny vrah", "Román", "A. Lacroix, Verboeckhoven & Cie.", 1869));
		database.addBook(new Book("Lewis Carroll", "Alenka v kraji zázrakov", "Detská literatúra", "Macmillan", 1865));
		database.addBook(new Book("Terry Pratchett", "Farma zvierat", "Fantasy", "Gollancz", 1984));
		database.addBook(new Book("John Steinbeck", "Hrozny hnevu", "Román", "The Viking Press", 1939));
		database.addBook(new Book("Charlotte Brontë", "Jana Eyrová", "Román", "Smith, Elder & Co.", 1847));
	}

	private String getUserOption() {
		System.out.print("Your option: ");
		return scanner.nextLine();
	}

	private void performAction(String option) {
		switch (option) {
			case OPTION_ADD_BOOK:
				addBook();
				break;
			case OPTION_DISPLAY_DATABASE:
				displayDatabase();
				break;
			case OPTION_FIND_BOOK_BY_IDX:
				findBookByIdx();
				break;
			case OPTION_FIND_BOOK_BY_NAME:
				findBookByName();
				break;
			case OPTION_DELETE_BOOK_BY_IDX:
				deleteBook();
				break;
			case OPTION_DISPLAY_DATABASE_SIZE:
				database.getSize();
				break;
			case OPTION_SAVE_STATE:
				saveStateUI();
				break;
			case OPTION_LOAD_STATE:
				loadStateUI();
				break;
			case OPTION_CREATE_PDF_REPORT:
				createPdfReportUI();
				break;
			case OPTION_OPEN_PDF_REPORT:
				bookPdfExporterService.openPdfReport();
				break;
			case OPTION_DELETE_ALL_BOOKS:
				clearDatabase();
				break;
			case OPTION_EXIT:
				exitProgramUI();
				break;
		}
	}

	private void addBook() {
		System.out.println(PROMPT_ADD_BOOK);
		System.out.print("\tAuthor: ");
		String author = scanner.nextLine();
		System.out.print("\tTitle: ");
		String title = scanner.nextLine();
		System.out.print("\tGenre: ");
		String genre = scanner.nextLine();
		System.out.print("\tPublisher: ");
		String publisher = scanner.nextLine();
		int publicationYear = integerInput("Publication Year: ");
		Book book = new Book(author, title, genre, publisher, publicationYear);
		database.addBook(book);

		System.out.println("Book added successfully!");
	}

	private void deleteBook() {
		int index = integerInput(PROMPT_DELETE_BOOK);
		if (database.isBookStored(index)) {
			database.deleteBook(index);
			System.out.println("Book deleted successfully!");
		} else {
			System.out.println("Invalid index. Book not found.");
		}
	}
	private void clearDatabase() {
		System.out.print(PROMPT_CLEAR_DATABASE);
		String vstup = scanner.nextLine().toLowerCase().trim();
		if (vstup.equals("y")) {
			database.clearDatabase();
			System.out.println("Database was successfully cleared!");
		}
		System.out.println();
	}

	private void findBookByName() {
		System.out.print(PROMPT_FIND_BOOK);
		String title = scanner.nextLine();
		LinkedHashMap<Integer,Book> foundBooks = database.findBook(title);
		if (foundBooks.isEmpty()) {
			System.out.println("No books found with the given title.");
		} else {
			System.out.println("Found books:");
			System.out.printf("%6s | %-40s | %-30s | %-30s | %-40s | %4s | %6s\n",
					"Index", "Title", "Author", "Genre", "Publisher", "Year", "Price (€)");
			for (Integer token: foundBooks.keySet()) {
				foundBooks.get(token).displayBook(token);
			}
		}
	}
	private void findBookByIdx() {
		Book book;
		int idx = integerInput(PROMPT_FIND_BOOK_IDX);
		book = database.getBookByIndex(idx);
		if (book != null) {
			book.displayBook();
		} else {
			System.out.println("No books found with the given index.");
		}
	}

	protected void displayDatabase() {
		System.out.printf("%6s | %-40s | %-30s | %-30s | %-40s | %4s | %6s\n",
				"Index", "Title", "Author", "Genre", "Publisher", "Year", "Price (€)");

		for (Integer key : database.bookData.getBookMap().keySet()){
			database.bookData.getBookMap().get(key).displayBook(key);

		}
	}

	protected boolean saveStateUI() {
		System.out.println(PROMPT_SAVE_STATE);
		return  bookSerializationService.saveState();

	}

	protected void loadStateUI() {
		System.out.println(PROMPT_LOAD_STATE);
		bookSerializationService.loadState();
	}

	protected void createPdfReportUI() {
		bookPdfExporterService.createPdfReport();
		System.out.println(PROMPT_REPORT_CREATED);
	}

	private void exitProgramUI() {
		int status = 0;
		System.out.println(PROMPT_EXIT);
		if (!database.bookData.getBookMap().equals(database.bookData.getBackupBookMap())){
			System.out.println(PROMPT_SAVE_CHANGES);
			boolean ask = scanner.nextLine().equalsIgnoreCase("y");
			if (ask && !saveStateUI()){
				status = 1;
			}
		}
		System.exit(status);
	}
	private int integerInput(String text) {
		int userInput;
		while (true) {
			try {
				System.out.print(text);
				userInput = scanner.nextInt();
				scanner.nextLine();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Wrong number format!");
				scanner.nextLine();
			}
		}
		return userInput;
	}
}
