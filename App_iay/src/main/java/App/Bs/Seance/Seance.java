package App.Bs.Seance;

import App.Bs.Absence.Absence;
import App.Bs.Etudiant.Etudiant;
import App.Bs.Professeur.Professeur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Set;

@Node(primaryLabel ="Seance" )
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seance {

	@Id
	@GeneratedValue
	private Long id;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Property
	private LocalDate dateSeance;

	@Property
	private String heureDebutSeance;

	@Property
    private String heureFinSeance;

	@Relationship(type = "ENSEIGNE_PAR_PROF", direction = Relationship.Direction.INCOMING)
	private Professeur professeur;

	@Relationship(type = "CONTIENT_FILR", direction = Relationship.Direction.OUTGOING)
	private Set<Absence> absences;

	@Relationship(type = "PASSE_PAR_ETUD", direction = Relationship.Direction.INCOMING)
	private Set<Etudiant> etudiants;

	@Relationship(type = "APPARTIENT_A_MOD", direction = Relationship.Direction.INCOMING)
	private Module module;


}
