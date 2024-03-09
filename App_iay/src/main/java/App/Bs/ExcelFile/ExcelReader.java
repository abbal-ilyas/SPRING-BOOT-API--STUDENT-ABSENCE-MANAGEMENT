package App.Bs.ExcelFile;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

public class ExcelReader {

	public static void main(String[] args) {


			String excelFilePath = "C:\\Users\\bouar\\IdeaProjects\\App_iay\\FilesUpload\\liste_absence.xlsx";

			try (FileInputStream file = new FileInputStream(new File(excelFilePath))) {
				XSSFWorkbook workbook = new XSSFWorkbook(file);
				int sheetIndex = 0; // Assumant que les données sont dans la première feuille

				// Lire la première feuille
				Iterator<Row> rowIterator = workbook.getSheetAt(sheetIndex).iterator();

				// Parcourir chaque ligne du fichier Excel
				while (rowIterator.hasNext()) {
					Row row = rowIterator.next();

					// Créer un tableau pour stocker les valeurs de chaque ligne
					String[] rowData = new String[row.getLastCellNum()];

					// Parcourir chaque cellule de la ligne
					for (int cellIndex = 0; cellIndex < row.getLastCellNum(); cellIndex++) {
						Cell cell = row.getCell(cellIndex);
						rowData[cellIndex] = (cell == null) ? "" : cell.toString();
					}

					// Utiliser le tableau "rowData" comme nécessaire (affichage, stockage, etc.)
					printRowData(rowData);
			/*	System.out.println(rowData[3]);*/
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}


	private static void printRowData(String[] rowData) {
		// Exemple : Afficher les valeurs de la ligne
		for (String value : rowData) {
			System.out.print(value);
		}
		System.out.println();
	}
}
