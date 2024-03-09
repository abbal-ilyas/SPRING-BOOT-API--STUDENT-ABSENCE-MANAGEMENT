package App.Bs.Filiere;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/filieres")
public class FiliereController {

	private final FiliereService filiereService;

	@Autowired
	public FiliereController(FiliereService filiereService) {
		this.filiereService = filiereService;
	}

	@GetMapping
	public List<Filiere> getAllFilieres() {
		return filiereService.getAllFilieres();
	}

	@GetMapping("/{id}")
	public Filiere getFiliereById(@PathVariable Long id) {
		return filiereService.getFiliereById(id);
	}

	@PostMapping
	public Filiere saveFiliere(@RequestBody Filiere filiere) {
		return filiereService.saveFiliere(filiere);
	}

	@DeleteMapping("/{id}")
	public void deleteFiliere(@PathVariable Long id) {
		filiereService.deleteFiliere(id);
	}
}

