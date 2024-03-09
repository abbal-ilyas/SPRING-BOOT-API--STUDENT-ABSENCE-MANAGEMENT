package App.Bs.Seance;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/seances")
public class SeanceController {

	private final SeanceService seanceService;

	@Autowired
	public SeanceController(SeanceService seanceService) {
		this.seanceService = seanceService;
	}

	@GetMapping
	public List<Seance> getAllSeances() {
		return seanceService.getAllSeances();
	}

	@GetMapping("/{id}")
	public Seance getSeanceById(@PathVariable Long id) {
		return seanceService.getSeanceById(id);
	}

	@PostMapping
	public Seance saveSeance(@RequestBody Seance seance) {
		return seanceService.saveSeance(seance);
	}

	@DeleteMapping("/{id}")
	public void deleteSeance(@PathVariable Long id) {
		seanceService.deleteSeance(id);
	}
}

