package App.Bs.Files;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;


@Node(primaryLabel = "FilesSys")
@Data
public class AppFiles {

	@Id
	@GeneratedValue
	private Long id;

	@Property
	private String fileName;

	public String getPathDir(AppFiles appFiles) {
		// Obtenez le répertoire de travail actuel de l'application
		String currentWorkingDir = System.getProperty("user.dir");
		//rediriger vers dossier FilesUpload
		currentWorkingDir+="/FilesUpload/"+ appFiles.getFileName();

		return currentWorkingDir;
	}

	@Property
	private String filePath; // Le chemin du fichier sur le serveur ou le système de fichiers

	@Property
	private String type;


}

