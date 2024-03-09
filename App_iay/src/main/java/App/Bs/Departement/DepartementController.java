package App.Bs.Departement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/departements")
public class DepartementController {

	private final DepartementService departementService;

	@Autowired
	public DepartementController(DepartementService departementService) {
		this.departementService = departementService;
	}

	@GetMapping
	public List<Departement> getAllDepartements() {
		return departementService.getAllDepartements();
	}

	@GetMapping("/{id}")
	public Departement getDepartementById(@PathVariable Long id) {
		return departementService.getDepartementById(id);
	}

	@PostMapping
	public Departement saveDepartement(@RequestBody Departement departement) {
		return departementService.saveDepartement(departement);
	}

	@DeleteMapping("/{id}")
	public void deleteDepartement(@PathVariable Long id) {
		departementService.deleteDepartement(id);
	}
}

