package programDatabazaKnih.libraryDatabasev4.controller;


import programDatabazaKnih.libraryDatabasev4.dao.BookDatabaseImpl;
import programDatabazaKnih.libraryDatabasev4.models.Author;
import programDatabazaKnih.libraryDatabasev4.models.Book;
import programDatabazaKnih.libraryDatabasev4.services.BookDatabaseSerializationService;
import programDatabazaKnih.libraryDatabasev4.services.BookPdfExporterService;
import programDatabazaKnih.libraryDatabasev4.view.LibraryConsoleView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryConsoleController {
	private final BookDatabaseImpl bookDatabase;
	private final LibraryConsoleView view;
	private final BookDatabaseSerializationService bookDatabaseSerializationService;
	private final BookPdfExporterService pdfExporterService;
	private final Scanner scanner;

	public LibraryConsoleController() {
		this.bookDatabase = new BookDatabaseImpl();
		this.view = new LibraryConsoleView();
		this.scanner = new Scanner(System.in);
		this.bookDatabaseSerializationService = new BookDatabaseSerializationService(this.bookDatabase);
		this.pdfExporterService = new BookPdfExporterService(this.bookDatabase);
	}

	public void start() {
		view.displayMenu();
		String option = getUserOption();
		while (!option.equalsIgnoreCase("EXIT")) {
			performAction(option);
			option = getUserOption();
		}

		exitProgramUI();
	}

	private String getUserOption() {
		System.out.print(">> ");
		return scanner.nextLine();
	}

	private void performAction(String option) {
		switch (option) {
			case "0":
				addAuthor();
				break;
			case "1":
				addBook();
				break;
			case "2a":
				view.displayAuthorDatabase(bookDatabase.getBookData());
				break;
			case "2b":
				view.displayBookDatabase(bookDatabase.getBookData().getBookList());
				break;
			case "3":
				findBookByIndex();
				break;
			case "4":
				findBookByName();
				break;
			case "5":
				deleteBookByIndex();
				break;
			case "6":
				view.displayBookDatabaseSize(bookDatabase.getSize());
				break;
			case "7":
				saveState();
				break;
			case "8":
				loadState();
				break;
			case "9":
				createPdfReport();
				break;
			case "10":
				openPdfReport();
				break;
			case "x0x":
				clearDatabase();
				break;
			default:
				view.displayMenu();
				break;
		}
	}
	public void insertStockLibrary() {
		bookDatabase.insertStockLibrary();
	}
	private void addAuthor() {
		view.displayPromptAddAuthor();
		String name = scanner.nextLine();
		Author author = new Author(name);
		bookDatabase.addAuthor(author);
	}

	private void addBook() {
		view.displayPromptAddBook();

		System.out.print("\tTitle: ");
		String title = scanner.nextLine();

		System.out.print("\tAuthor: ");
		String authorName = scanner.nextLine();

		System.out.print("\tGenre: ");
		String genre = scanner.nextLine();

		System.out.print("\tPublisher: ");
		String publisher = scanner.nextLine();

		int year = integerInput("\tYear: ");

		Book newBook = new Book(title, authorName, genre, publisher, year);
		bookDatabase.addBook(newBook);

		view.displayBookAddedSuccessfully();
	}

	private void findBookByIndex() {
		int index = integerInput(LibraryConsoleView.PROMPT_FIND_BOOK_IDX);
		Book foundBook = bookDatabase.findBookByIndex(index);
		if (foundBook != null) {
			view.displayBook(index, foundBook);
		} else {
			view.displayBookNotFound();
		}
	}

	private void findBookByName() {
		view.displayFindBookByNamePrompt();
		String title = scanner.nextLine();
		view.displayBookDatabase(bookDatabase.findBookByTitle(title));
	}

	private void deleteBookByIndex() {
		view.displayPromptDeleteBook();
		int index = Integer.parseInt(scanner.nextLine());
		boolean bookDeleted = bookDatabase.deleteBook(index);
		if (bookDeleted) {
			view.displayBookDeletedSuccessfully();
		} else {
			view.displayInvalidIndex();
		}
	}

	private void clearDatabase() {
		view.displayClearDatabasePrompt();
		String response = scanner.nextLine();

		if (response.equalsIgnoreCase("y")) {
			bookDatabase.clearDatabase();
			view.displayDatabaseCleared();
		}
	}

	private void saveState() {
		view.displaySaveStatePrompt();
		bookDatabaseSerializationService.saveState();
	}

	private void loadState() {
		view.displayLoadStatePrompt();
		bookDatabaseSerializationService.loadState();
	}

	private void createPdfReport() {
		view.displayPdfReportCreated();
		pdfExporterService.createPdfReport();
	}

	private void openPdfReport() {
		pdfExporterService.openPdfReport();
	}

	private void exitProgramUI() {
		int exitCode = 0;
		view.displayExitPrompt();
		if (!bookDatabase.getBookData().getAuthorsToBooks().equals(bookDatabase.getBookData().getBackupAuthorsToBooks())) {
			view.displaySaveChangesPrompt();
			boolean response = scanner.nextLine().trim().equals("y");
			if (response && !bookDatabaseSerializationService.saveState()) {
				exitCode = 1;
			}
		}
		System.exit(exitCode);
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
