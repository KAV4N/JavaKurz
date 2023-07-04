package programDatabazaKnih.libraryDatabasev5.services;

import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPTable;

public interface BookPdfExporter {
	boolean openPdfReport();

	boolean createPdfReport();

	void addTableHeader(PdfPTable table, Font font);

	void addRows(PdfPTable table, Font font);
}
