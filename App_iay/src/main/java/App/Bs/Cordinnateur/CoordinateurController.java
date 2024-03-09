package App.Bs.Cordinnateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coordinateurs")
public class CoordinateurController {

	private final CoordinateurService coordinateurService;

	@Autowired
	public CoordinateurController(CoordinateurService coordinateurService) {
		this.coordinateurService = coordinateurService;
	}

	// Ajoutez des méthodes de contrôleur en fonction des besoins
}

