package App.Bs.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileUrlResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/app/files")
public class FilesController {

	private final FilesService filesService;
	private final ExcelFileService1 fileExcelService;
	private final FilesRepository filesRepository;

	@Autowired
	public FilesController(FilesService fileEntityService, ExcelFileService1 fileExcelService, FilesRepository filesRepository) {
		this.filesService = fileEntityService;
		this.fileExcelService = fileExcelService;
		this.filesRepository = filesRepository;
	}

	@PostMapping("/upload")
	public ResponseEntity<String> handleFileUpload(@RequestParam("files") List<MultipartFile> files) {
		if (files.isEmpty()) {
			return ResponseEntity.badRequest().body("Aucun fichier n'a été fourni.");
		}

		for (MultipartFile file : files) {
			String fileName = file.getOriginalFilename();

				try {
				// Obtenez le répertoire de travail actuel de l'application
				String currentWorkingDir = System.getProperty("user.dir");
				// Rediriger vers le dossier FilesUpload
				currentWorkingDir += "/FilesUpload";
				// Obtenez le nom d'origine du fichier
				String originalFilename = file.getOriginalFilename();

				// Créez le chemin complet vers le fichier dans le répertoire de travail
				Path filePath = Paths.get(currentWorkingDir, originalFilename);

				if (Files.exists(filePath)) {
					Files.deleteIfExists(filePath);

				}

				AppFiles fileEntity = new AppFiles();
				fileEntity.setFileName(originalFilename);
				fileEntity.setType(file.getContentType());
				fileEntity.setFilePath(fileEntity.getPathDir(fileEntity));
				// Autres propriétés à définir en fonction de vos besoins
					if(!filesRepository.existsByFileName(fileEntity.getFileName())){
						filesService.saveFileInformation(fileEntity);
					}


				// Enregistrez le fichier sur le disque
				Files.write(filePath, file.getBytes());
					if (fileName != null && (fileName.endsWith(".xls") || fileName.endsWith(".xlsx"))){
						fileExcelService.Reader(String.valueOf(filePath));
					}

			} catch (IOException e) {
				e.printStackTrace();
				return ResponseEntity.status(500).body("Une erreur s'est produite lors de l'enregistrement des fichiers.");
			}

		}
		return ResponseEntity.ok("Fichiers bien enregistrés avec succès.");

	}



	@GetMapping("/getByFilename")
	public ResponseEntity<String> getFilesByFilename(@RequestParam String filename) {
		AppFiles filesByFilename = filesService.getFilesByFilename(filename);
		if (filesByFilename == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(filesByFilename.getFilePath());
		}
	}
	@GetMapping("/images/{imageName}")
	public ResponseEntity<Resource> getImage(@PathVariable String imageName) throws IOException {


		String currentWorkingDir = System.getProperty("user.dir")+"/FilesUpload/"+imageName;

		Resource resource = new FileUrlResource(currentWorkingDir);

		if (!resource.exists()) {
			return ResponseEntity.notFound().build();
		}

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG); // Change to appropriate media type for your image
		return new ResponseEntity<>(resource, headers, HttpStatus.OK);
	}


}

