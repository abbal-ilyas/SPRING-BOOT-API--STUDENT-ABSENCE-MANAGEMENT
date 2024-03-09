package App.Bs.Professeur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesseurService {

	private final ProfesseurRepository professeurRepository;

	@Autowired
	public ProfesseurService(ProfesseurRepository professeurRepository) {
		this.professeurRepository = professeurRepository;
	}

	// Ajouter des méthodes de service si nécessaire
}

