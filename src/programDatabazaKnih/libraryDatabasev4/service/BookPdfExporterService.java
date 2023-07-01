package programDatabazaKnih.libraryDatabasev4.service;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import programDatabazaKnih.libraryDatabasev4.Book;
import programDatabazaKnih.libraryDatabasev4.BookDatabase;

import javax.swing.plaf.PanelUI;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class BookPdfExporterService {
	public static final Font TITLE_FONT = new Font(Font.HELVETICA, 24, Font.BOLD);
	public static final Font HEADER_FONT = new Font(Font.HELVETICA, 10,Font.BOLD);
	public static final Font CONTENT_FONT = new Font(Font.HELVETICA, 8);

	private BookDatabase database;
	final private String pdfPath = "libraryDatabaseData/libraryOutput/library.pdf";
	public BookPdfExporterService(BookDatabase database){
		this.database = database;
	}
	public boolean openPdfReport(){
		boolean isOpen = false;
		try{
			File file = new File(pdfPath);
			Desktop desktop = Desktop.getDesktop();
			if (desktop.isSupported(Desktop.Action.OPEN)) {
				desktop.open(file);
				isOpen = true;
			}
		}
		catch (DocumentException | IOException e){
			System.out.println("An error occurred while opening the PDF report.");
			e.printStackTrace();
		}
		return isOpen;
	}
	public boolean createPdfReport() {
		Document document = new Document(PageSize.A4,40f,40f,40f,40f);
		boolean isCreated = false;
		try {
			PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
			document.open();

			Chunk chunk = new Chunk("Book Database Report", TITLE_FONT);
			document.add(new Paragraph(chunk));
			document.add(Chunk.NEWLINE);

			PdfPTable table = new PdfPTable(4);
			table.setWidths(new float[]{40f,40f,25f,20f});

			table.setWidthPercentage(100);

			addTableHeader(table,HEADER_FONT);
			addRows(table,CONTENT_FONT);

			document.add(table);
			document.close();
			isCreated = true;

			System.out.println("\nPDF report generated successfully!");
			System.out.println("Report saved at: " + pdfPath);

		} catch (DocumentException | IOException e) {
			System.out.println("An error occurred while generating the PDF report.");
			e.printStackTrace();
		}
		return isCreated;
	}


	public void addTableHeader(PdfPTable table, Font font) {
		String[] headers = {"Title", "Author", "Genre", "Publication"};
		for (String header : headers) {
			PdfPCell cell = new PdfPCell();
			cell.setPadding(5f);
			cell.setBackgroundColor(Color.cyan);
			cell.setBorderWidth(1);

			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);

			cell.setPhrase(new Phrase(header,font));
			table.addCell(cell);
		}
	}

	private void addRows(PdfPTable table, Font font) {
		Book book;
		PdfPCell cellTitle = new PdfPCell();
		PdfPCell cellAuthor = new PdfPCell();
		PdfPCell cellGenre= new PdfPCell();
		PdfPCell cellYear = new PdfPCell();

		for (Integer key : database.getBookData().getBookMap().keySet()){
			book = database.getBookData().getBookMap().get(key);

			cellTitle.setPadding(5f);
			cellAuthor.setPadding(5f);
			cellGenre.setPadding(5f);
			cellYear.setPadding(5f);

			cellTitle.setPhrase(new Phrase(book.getTitle(),font));
			cellAuthor.setPhrase(new Phrase(book.getAuthor(),font));
			cellGenre.setPhrase(new Phrase(book.getGenre(),font));
			cellYear.setPhrase(new Phrase(Integer.toString(book.getPublicationYear()),font));


			cellYear.setHorizontalAlignment(Element.ALIGN_CENTER);
			cellYear.setVerticalAlignment(Element.ALIGN_MIDDLE);

			table.addCell(cellTitle);
			table.addCell(cellAuthor);
			table.addCell(cellGenre);
			table.addCell(cellYear);
		}

	}

}
