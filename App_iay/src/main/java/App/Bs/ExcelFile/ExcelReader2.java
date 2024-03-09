package App.Bs.ExcelFile;



import App.Bs.Etudiant.Etudiant;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReader2 {

	public static void main(String[] args) {
		String excelFilePath = "C:\\Users\\bouar\\IdeaProjects\\App_iay\\FilesUpload\\liste_absence.xlsx";

		try (FileInputStream file = new FileInputStream(new File(excelFilePath))) {
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			int sheetIndex = 0; // Assuming that the data is in the first sheet

			// Read the first sheet
			Iterator<Row> rowIterator = workbook.getSheetAt(sheetIndex).iterator();

			// List to store JSON objects
			List<Object> jsonList = new ArrayList<>();

			// Iterate through each row of the Excel file
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();

				// Create a map to store the values of each row
				List<String> rowData = new ArrayList<>();

				// Iterate through each cell of the row
				for (int cellIndex = 0; cellIndex < row.getLastCellNum(); cellIndex++) {
					Cell cell = row.getCell(cellIndex);
					rowData.add((cell == null) ? "" : cell.toString());
				}

				// Add the rowData to the JSON list
				jsonList.add(rowData);
			}

			// Convert the JSON list to a JSON string
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonString = objectMapper.writeValueAsString(jsonList);
			// Print the JSON string
			System.out.println(jsonString);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
