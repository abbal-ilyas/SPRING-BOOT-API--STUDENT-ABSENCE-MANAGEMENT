package App.Bs.Filiere;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FiliereRepository extends Neo4jRepository<Filiere, Long> {

	// Ajoutez des méthodes personnalisées si nécessaire
}

