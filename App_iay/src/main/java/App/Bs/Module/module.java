package App.Bs.Module;

import App.Bs.Absence.Absence;
import App.Bs.Etudiant.Etudiant;
import App.Bs.Filiere.Filiere;
import App.Bs.Professeur.Professeur;
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
@AllArgsConstructor
@NoArgsConstructor
@Node(primaryLabel = "module")
public class module {

	@Id
	@GeneratedValue
	private Long id;

	@Property
	private String nom;

	//  la relation avec Etudiant
	@Relationship(type = "CONTIENT_ETUD", direction = Relationship.Direction.INCOMING)
	private Set<Etudiant> etudiants;


	@Relationship(type = "ENSEIGNE_PAR_PROF", direction = Relationship.Direction.OUTGOING)
	private Professeur professeurs;

	@Relationship(type = "A_ABSENCE", direction = Relationship.Direction.OUTGOING)
	private Set<Absence> absence;

	@Relationship(type = "APPARTIENT_A_FILR", direction = Relationship.Direction.OUTGOING)
	private Filiere filieres;

	@Relationship(type = "A_SEANCE", direction = Relationship.Direction.INCOMING)
	private Set<Seance> seances;


	public module(String nom, Filiere filieres) {
		this.nom = nom;
		this.filieres = filieres;
	}
}

