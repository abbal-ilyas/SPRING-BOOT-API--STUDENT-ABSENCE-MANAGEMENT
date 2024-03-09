package App.Bs.Professeur;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesseurRepository extends Neo4jRepository<Professeur, Long> {
	// Ajouter des méthodes personnalisées si nécessaire
}

