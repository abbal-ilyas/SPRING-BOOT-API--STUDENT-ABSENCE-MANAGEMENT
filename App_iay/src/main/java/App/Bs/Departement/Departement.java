package App.Bs.Departement;

import App.Bs.Etudiant.Etudiant;
import App.Bs.Filiere.Filiere;
import App.Bs.Professeur.Professeur;
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
@Node(primaryLabel ="Departement" )
@NoArgsConstructor
@AllArgsConstructor
public class Departement {

	@Id
	@GeneratedValue
	private Long id;

	@Property
	private String nom;

	// Autres propriétés de l'entité

	@Relationship(type = "TRAVAILE_ICI_PROF", direction = Relationship.Direction.INCOMING)
	private Set<Professeur> profeesurs;

	@Relationship(type = "CONTIENT_FILR", direction = Relationship.Direction.INCOMING)
	private Set<Filiere> filiers;

	@Relationship(type = "CONTIENT_FILR", direction = Relationship.Direction.INCOMING)
	private Set<Etudiant> etudiants;

	public Departement(String nom) {
		this.nom = nom;
	}

	// Constructeurs, getters, setters
}
