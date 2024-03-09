package App.Bs.Seance;


import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeanceRepository extends Neo4jRepository<Seance, Long> {
	// Ajoutez des méthodes personnalisées si nécessaire
}
