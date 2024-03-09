package App.Bs.Files;

import App.Bs.Etudiant.Etudiant;
import App.Bs.Etudiant.EtudiantRepository;
import com.google.gson.Gson;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
@Service
public class ExcelFileService1 {
	private final EtudiantRepository etudiantRepository;


     @Autowired
	public ExcelFileService1(EtudiantRepository etudiantRepository) {
		this.etudiantRepository = etudiantRepository;
	}


	public String removeDecimal(double value){

		// Convertir le double en chaîne
		String stringValue = Double.toString(value);
		// Vérifier si la chaîne se termine par ".0"
		if (stringValue.endsWith(".0")) {
			// Supprimer ".0" de la fin de la chaîne
			return stringValue.substring(0, stringValue.length() - 2);
		}
		return stringValue;
	}
	public void Reader(String pathFile) {

		String excelFilePath = pathFile;

		try (FileInputStream file = new FileInputStream(new File(excelFilePath))) {
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			int sheetIndex = 0; // Assuming that the data is in the first sheet

			// Read the first sheet
			Iterator<Row> rowIterator = workbook.getSheetAt(sheetIndex).iterator();

			// Map to store JSON objects
			Map<String, String> headers = new HashMap<>();
			Map<String, String> jsonData = new HashMap<>();

			// Iterate through each row of the Excel file
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();

				if (headers.isEmpty()) { // Extract headers from the first row
					for (int cellIndex = 0; cellIndex < row.getLastCellNum(); cellIndex++) {
						Cell cell = row.getCell(cellIndex);
						String header = (cell == null) ? "" : cell.toString();
						// Replace "date naissance" with "birth"
						if (header.equals("date naissance")) {
							header = "birth";
						}
						headers.put("Column " + (cellIndex + 1), header);
					}
				} else { // Extract data from subsequent rows
					for (int cellIndex = 0; cellIndex < row.getLastCellNum(); cellIndex++) {
						Cell cell = row.getCell(cellIndex);
						String cellValue = (cell == null) ? "" : cell.toString();
						// Use headers as keys
						String header = headers.get("Column " + (cellIndex + 1));
						jsonData.put(header, cellValue);
					}
					// Convert the rowData to JSON using Gson
					Gson gson = new Gson();
					String jsonString = gson.toJson(jsonData);
					// Convertir la chaîne JSON en un objet JSONObject
					JSONObject jsonObject = new JSONObject(jsonString);

					// Accéder aux valeurs individuelles en utilisant les clés
					String nom = jsonObject.getString("nom");
					String ville = jsonObject.getString("ville");
					String  email = jsonObject.getString("email");
					String birth = jsonObject.getString("birth");
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
					LocalDate date = LocalDate.parse(birth, formatter);

					String prenom = jsonObject.getString("prenom");
					String numero = removeDecimal(jsonObject.getDouble("numero"));
					String apogee = removeDecimal(jsonObject.getDouble("apogee"));

					Etudiant etudiant = new Etudiant(numero,nom,prenom,email,date,apogee,ville);

					if(etudiantRepository.existsByApogee(apogee)){
						etudiantRepository.deleteByApogee(apogee);
					}
					etudiantRepository.save(etudiant);

					jsonData.clear();

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
