package programDatabazaKnih.libraryDatabasev4.view;

import programDatabazaKnih.libraryDatabasev4.models.Book;
import java.util.LinkedHashMap;

public class LibraryConsoleView {
	public static final String MENU_PROMPT = "\nPlease select an option:";
	public static final String MENU_OPTIONS =
			"\tWrite \"EXIT\" to leave the program\n" +
					"\t1. Add Book\n" +
					"\t2. Display Database\n" +
					"\t3. Find Book (by index)\n" +
					"\t4. Find Book (by name)\n" +
					"\t5. Delete Book (by index)\n" +
					"\t6. Display database size\n" +
					"\t7. Save State\n" +
					"\t8. Load State\n" +
					"\t9. Create PDF Report\n" +
					"\t10. Open PDF Report\n" +
					"\tx0x - Delete All Books\n";
	public static final String PROMPT_DATABASE_SIZE = "Database size:";

	public static final String PROMPT_ADD_BOOK = "Enter the book details:";
	public static final String PROMPT_DELETE_BOOK = "Enter the index of the book to delete:";
	public static final String PROMPT_FIND_BOOK = "Enter the title of the book to find:";
	public static final String PROMPT_SAVE_STATE = "Saving the database state...";
	public static final String PROMPT_LOAD_STATE = "Loading the database state...";
	public static final String PROMPT_REPORT_CREATED = "PDF report created!";
	public static final String PROMPT_EXIT = "Exiting the program...";
	public static final String PROMPT_FIND_BOOK_IDX = "Enter the index of book:";
	public static final String PROMPT_CLEAR_DATABASE = "Are you sure you want to delete all the books from the database? (y/n)";
	public static final String PROMPT_SAVE_CHANGES = "Do you want to save changes? (y/n)";

	public void displayMenu() {
		System.out.println(MENU_PROMPT);
		System.out.println(MENU_OPTIONS);
	}

	public void displayBookDatabase(LinkedHashMap<Integer, Book> bookMap) {
		System.out.printf("%6s | %-40s | %-30s | %-30s | %-40s | %4s | %6s\n",
				"Index", "Title", "Author", "Genre", "Publisher", "Year", "Price (€)");

		for (Integer key : bookMap.keySet()) {
			bookMap.get(key).displayBook(key);
		}
	}
	public void displayBook(int idx, Book book){
		book.displayBook(idx);
	}

	public void displayBookNotFound() {
		System.out.println("No books found with the given index or title.");
	}

	public void displayBookAddedSuccessfully() {
		System.out.println("Book added successfully!");
	}

	public void displayBookDeletedSuccessfully() {
		System.out.println("Book deleted successfully!");
	}

	public void displayInvalidIndex() {
		System.out.println("Invalid index. Book not found.");
	}

	public void displayNoBooksFoundWithTitle() {
		System.out.println("No books found with the given title.");
	}

	public void displayDatabaseCleared() {
		System.out.println("Database was successfully cleared!");
	}

	public void displayChangesNotSaved() {
		System.out.println("Changes were not saved.");
	}

	public void displayPromptAddBook(){
		System.out.println(PROMPT_ADD_BOOK);
	}

	public void displayBookDatabaseSize(int size){
		System.out.print(PROMPT_DATABASE_SIZE);
		System.out.println(size);
	}

	public void displaySaveStatePrompt() {
		System.out.println(PROMPT_SAVE_STATE);
	}

	public void displayLoadStatePrompt() {
		System.out.println(PROMPT_LOAD_STATE);
	}

	public void displayPdfReportCreated() {
		System.out.println(PROMPT_REPORT_CREATED);
	}

	public void displayExitPrompt() {
		System.out.println(PROMPT_EXIT);
	}

	public void displayFindBookByIndexPrompt() {
		System.out.println(PROMPT_FIND_BOOK_IDX);
	}

	public void displayClearDatabasePrompt() {
		System.out.println(PROMPT_CLEAR_DATABASE);
	}

	public void displaySaveChangesPrompt() {
		System.out.println(PROMPT_SAVE_CHANGES);
	}
	public void displayFindBookByNamePrompt() {
		System.out.println(PROMPT_FIND_BOOK);
	}
	public void displayPromptDeleteBook() {
		System.out.println(PROMPT_DELETE_BOOK);
	}
}
