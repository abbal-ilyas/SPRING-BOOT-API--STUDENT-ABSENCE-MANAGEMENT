package App.Bs.Absence;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface AbsenceRepository extends Neo4jRepository<Absence, Long> {
	// Vous pouvez ajouter des méthodes personnalisées de requête si nécessaire

	Optional<Absence> findAbsenceByDateAbsence(LocalDate date);
}

