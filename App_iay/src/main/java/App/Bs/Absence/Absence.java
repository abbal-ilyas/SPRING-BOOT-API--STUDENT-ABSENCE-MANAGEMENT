package App.Bs.Absence;

import App.Bs.Etudiant.Etudiant;
import App.Bs.Seance.Seance;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Node(primaryLabel  = "Absence")
public class Absence {

	@Id
	private Long id;


    @Property
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dateAbsence;

	@Relationship(type = "PASSE_PAR_ETUD", direction = Relationship.Direction.INCOMING)
	private Set<Etudiant> etudiants;

	@Relationship(type = "PASSE_DANS_MOD", direction = Relationship.Direction.INCOMING)
	private Set<Module> modules;

	@Relationship(type = "PASSE_DANS_SEANCE", direction = Relationship.Direction.INCOMING)
	private Set<Seance> seance;

	public Absence(LocalDate dateAbsence, Set<Etudiant> etudiants, Set<Module> modules, Set<Seance> seance) {
		this.dateAbsence = dateAbsence;
		this.etudiants = etudiants;
		this.modules = modules;
		this.seance = seance;
	}


	// Les relations avec d'autres entités peuvent être ajoutées ici

	// Constructeurs, getters et setters



	// Autres méthodes ou relations nécessaires
}

