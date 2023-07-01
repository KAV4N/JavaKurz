package programDatabazaKnih.libraryDatabasev4.service;

import programDatabazaKnih.libraryDatabasev4.BookDatabase;
import programDatabazaKnih.libraryDatabasev4.BookStorage;

import java.io.*;

public class BookDatabaseSerializationService {
	private BookDatabase database;
	final private String backupPath = "libraryDatabaseData/bookDatabaseState/database.ser";
	public BookDatabaseSerializationService(BookDatabase database){
		this.database = database;
	}
	private boolean createBackupPath(){
		boolean isCreated = false;
		try {
			File myObj = new File(backupPath);
			myObj.createNewFile();
			isCreated = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return isCreated;
	}

	public boolean saveState() {
		boolean isSaved = false;
		createBackupPath();
		try {
			FileOutputStream fileOut = new FileOutputStream(backupPath);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(database.getBookData());
			objectOut.close();
			fileOut.close();
			isSaved = true;
			System.out.println("Database state saved successfully!");
		} catch (IOException e) {
			System.out.println("An error occurred while saving the database state.");
			e.printStackTrace();
		}
		return isSaved;
	}

	public boolean loadState() {
		boolean isLoaded = false;
		createBackupPath();
		try {
			FileInputStream fileIn = new FileInputStream(backupPath);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			database.setBookData((BookStorage) objectIn.readObject());
			objectIn.close();
			fileIn.close();
			isLoaded = true;
			System.out.println("Database state loaded successfully!");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("An error occurred while loading the database state.");
			e.printStackTrace();
		}
		return isLoaded;
	}
};