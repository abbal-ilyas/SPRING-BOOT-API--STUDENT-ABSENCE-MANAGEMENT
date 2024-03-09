package App.Bs.Absence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/app/absences")
public class AbsenceController {

	private final AbsenceService absenceService;

	@Autowired
	public AbsenceController(AbsenceService absenceService) {
		this.absenceService = absenceService;
	}

	@GetMapping
	public List<Absence> getAllAbsences() {
		return absenceService.getAllAbsences();
	}

	@GetMapping("{id}")
	public Absence getAbsenceById(@PathVariable Long id) {
		return absenceService.getAbsenceById(id);
	}

	@PostMapping
	public Absence saveAbsence(@RequestBody Absence absence) {
		return absenceService.saveAbsence(absence);
	}
	@GetMapping("/{date}")
	public Absence GetAbsenceByDate(@PathVariable LocalDate date) {
		return absenceService.getAbsenceByDate(date);
	}
	@DeleteMapping("{id}")
	public void deleteAbsence(@PathVariable Long id) {
		absenceService.deleteAbsence(id);
	}
}

