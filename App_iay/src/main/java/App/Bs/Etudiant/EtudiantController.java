package App.Bs.Etudiant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.DeleteExchange;

import java.util.List;

@RestController
@RequestMapping("/app/etudiants")
public class EtudiantController {

	private final EtudiantService etudiantService;

	@Autowired
	public EtudiantController(EtudiantService etudiantService) {
		this.etudiantService = etudiantService;
	}

	@GetMapping
	public List<Etudiant> getAllEtudiants() {
		return etudiantService.getAllEtudiants();
	}

	@GetMapping("/{id}")
	public Etudiant getEtudiantById(@PathVariable Long id) {
		return etudiantService.getEtudiantById(id);
	}
	@DeleteMapping
	public void deleteEtudiant(@PathVariable String numero,String nom) {
        etudiantService.deleteEtudiant(numero,nom);
    }
	// Ajoutez d'autres méthodes de contrôleur en fonction de vos besoins
}

