package App.Bs.Cordinnateur;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordinateurRepository extends Neo4jRepository<Coordinateur, Long> {
	// Ajoutez des méthodes personnalisées si nécessaire
}

