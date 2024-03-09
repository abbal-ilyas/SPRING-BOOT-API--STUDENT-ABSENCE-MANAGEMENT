package App.Bs.Etudiant;

import App.Bs.Absence.Absence;
import App.Bs.Departement.Departement;
import App.Bs.Filiere.Filiere;
import App.Bs.Professeur.Professeur;
import App.Bs.Seance.Seance;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDate;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Node(primaryLabel  = "Etudiant")
public class Etudiant {

	@Id
	private Long id;

	@Property
    private String numero;
	@Property
	private String nom;

	@Property
	private String prenom;

	@Property
	private String email;

	@Property
	private LocalDate birth;

	@Property
	private String apogee;



	@Property
	private String ville;// Autres propriétés de l'entité

	//RELATION avec absence 			[ETUDIANT]-->[ ABSENCE]
	@Relationship(type = "A_PASSE", direction = Relationship.Direction.OUTGOING)
	private Set<Absence> absences;


	@Relationship(type = "PRESENT_A_SEACNE", direction = Relationship.Direction.INCOMING)
	private Set<Seance> seance;

	@Relationship(type = "ENCADRE_PAR_PROF", direction = Relationship.Direction.OUTGOING)
	private Set<Professeur> professeurs;

	@Relationship(type = "INSCRIT_DANS_MOD", direction = Relationship.Direction.INCOMING)
	private Set<Module> modules;

	@Relationship(type = "APPARTIENT_A_FILR", direction = Relationship.Direction.OUTGOING)
	private Filiere filiere;

	@Relationship(type = "APPARTIENT_A_DEP", direction = Relationship.Direction.OUTGOING)
	private Departement deaprtemnt;

	public Etudiant(String numero, String nom, String prenom, String email, LocalDate birth, String apogee, String ville) {
		this.numero = numero;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.birth = birth;
		this.apogee = apogee;
		this.ville = ville;
	}


	// Constructeurs, getters, setters
}

