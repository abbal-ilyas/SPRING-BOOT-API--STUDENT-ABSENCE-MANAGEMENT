package App.Bs.Departement;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepository extends Neo4jRepository<Departement, Long> {
	// Ajoutez des méthodes personnalisées si nécessaire
}

