package App.Bs.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FilesService {

	private final FilesRepository filesRepository;

	@Autowired
	public FilesService(FilesRepository filesRepository) {

		this.filesRepository = filesRepository;
	}

	public AppFiles saveFileInformation(AppFiles fileEntity)
	{


		return filesRepository.save(fileEntity);
	}
	public AppFiles getFilesByFilename(String filename) {
		return filesRepository.findByFileName(filename);
	}

	// Méthode pour récupérer les informations d'un fichier par son ID
	public Optional<AppFiles> getFileInformationById(Long fileId) {
		return filesRepository.findById(fileId);
	}
}

