package App.Bs.Professeur;

import App.Bs.Departement.Departement;
import App.Bs.Etudiant.Etudiant;
import App.Bs.Seance.Seance;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Set;


@Data
@Node(primaryLabel = "Professeur" )
@NoArgsConstructor
@AllArgsConstructor
public class Professeur {

	@Id
	@GeneratedValue
	private Long id;

	@Property
	private String nom;

	@Property
	private String prenom;

	@Property
	private String email;


	// Ajouter la relation avec Module
	@Relationship(type = "ENSEIGNE_ETUD", direction = Relationship.Direction.INCOMING)
	private Set<Etudiant> etudiant;

	@Relationship(type = "APPARTIENT_A_DEP", direction = Relationship.Direction.OUTGOING)
	private Departement departement;

	@Relationship(type = "ENCADRE_MOD", direction = Relationship.Direction.INCOMING)
	private Set<Module> modules;

	@Relationship(type = "DIRIGE_SEANCE", direction = Relationship.Direction.INCOMING)
	private Set<Seance> seances;


}


