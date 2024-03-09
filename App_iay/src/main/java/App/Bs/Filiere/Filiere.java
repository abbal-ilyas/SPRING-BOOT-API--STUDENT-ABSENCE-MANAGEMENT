package App.Bs.Filiere;

import App.Bs.Departement.Departement;
import App.Bs.Etudiant.Etudiant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Optional;
import java.util.Set;

@Node(primaryLabel = "Filiere")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Filiere {

	@Id
	@GeneratedValue
	private Long id;

	@Property
	private String nom;

	@Property
	private NomSemstre semestre;


	// Autres propriétés de l'entité

	@Relationship(type = "CONTIENT_ETUD", direction = Relationship.Direction.INCOMING)
	private Set<Etudiant> etudiants;

	@Relationship(type = "APPARTIENT_A_DEP", direction = Relationship.Direction.OUTGOING)
	private Departement departement;

	@Relationship(type = "CONTIENT_MOD", direction = Relationship.Direction.INCOMING)
	private Set<Module> modules;

	public Filiere(String nom, NomSemstre semestre, Departement departement) {
		this.nom = nom;
		this.semestre = semestre;
		this.departement = departement;
	}

	// Constructeurs, getters, setters
}
