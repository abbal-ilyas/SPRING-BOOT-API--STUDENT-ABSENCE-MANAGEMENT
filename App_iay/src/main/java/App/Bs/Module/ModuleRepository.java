package App.Bs.Module;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends Neo4jRepository<module, Long> {
	// Ajouter des méthodes personnalisées si nécessaire
}

