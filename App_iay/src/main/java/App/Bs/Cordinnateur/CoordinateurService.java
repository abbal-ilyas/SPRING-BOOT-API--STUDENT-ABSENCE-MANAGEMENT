package App.Bs.Cordinnateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoordinateurService {

	private final CoordinateurRepository coordinateurRepository;

	@Autowired
	public CoordinateurService(CoordinateurRepository coordinateurRepository) {
		this.coordinateurRepository = coordinateurRepository;
	}

	// Ajoutez des méthodes de service en fonction des besoins
}

