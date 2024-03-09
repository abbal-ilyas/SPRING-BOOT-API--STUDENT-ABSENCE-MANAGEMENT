package App.Bs.Etudiant;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Optional;

public interface EtudiantRepository extends Neo4jRepository<Etudiant, Long> {

	Optional<Etudiant> findByNumero(String numero);
	void deleteEtudiantByNumeroAndNom(String numero, String nom);
	boolean existsByApogee(String apogee);

	void deleteByApogee(String apogee);
}

