package App.Bs.Cordinnateur;

import App.Bs.Filiere.Filiere;
import App.Bs.Professeur.Professeur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

// Utilisation de la même classe Professeur pour représenter un Coordinateur
@EqualsAndHashCode(callSuper = true)
@Node(primaryLabel = "coordinateur",labels = {"Coordinateur","Prifesseur"})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coordinateur extends Professeur {

	// Ajout de relations spécifiques à un coordinateur, si nécessaire
	@Relationship(type = "CORD_DE_FILR", direction = Relationship.Direction.OUTGOING)
	private Filiere filiere;

	// Autres propriétés ou méthodes spécifiques à un coordinateur
}

