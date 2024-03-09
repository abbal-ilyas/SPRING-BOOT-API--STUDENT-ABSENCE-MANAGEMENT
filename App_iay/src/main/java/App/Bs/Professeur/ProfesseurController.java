package App.Bs.Professeur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/professeurs")
public class ProfesseurController {

	private final ProfesseurService professeurService;

	@Autowired
	public ProfesseurController(ProfesseurService professeurService) {
		this.professeurService = professeurService;
	}

	// Ajouter des endpoints REST pour la gestion des professeurs
}

