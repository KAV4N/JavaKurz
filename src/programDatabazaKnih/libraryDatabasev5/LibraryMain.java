package programDatabazaKnih.libraryDatabasev5;

import programDatabazaKnih.libraryDatabasev5.controller.LibraryConsoleController;

public class LibraryMain {
	public static void main(String[] args) {
		LibraryConsoleController controller = new LibraryConsoleController();
//		controller.insertStockLibrary();
		controller.start();
	}
}
