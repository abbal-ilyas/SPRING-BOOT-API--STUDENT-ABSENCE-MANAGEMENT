package App.Bs.Files;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilesRepository extends Neo4jRepository<AppFiles, Long> {
	// Vous pouvez ajouter des méthodes personnalisées si nécessaire
	AppFiles findByFileName(String filename);


	boolean existsByFileName(String filename);
}

