package App.Bs.Absence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AbsenceService {

	private final AbsenceRepository absenceRepository;

	@Autowired
	public AbsenceService(AbsenceRepository absenceRepository) {
		this.absenceRepository = absenceRepository;
	}

	public List<Absence> getAllAbsences() {
		return absenceRepository.findAll();
	}

	public Absence getAbsenceById(Long id) {
		return absenceRepository.findById(id).orElse(null);
	}
	public Absence getAbsenceByDate(LocalDate date) {
		return absenceRepository.findAbsenceByDateAbsence(date).orElse(null);
	}
	public Absence saveAbsence(Absence absence) {
		return absenceRepository.save(absence);
	}

	public void deleteAbsence(Long id) {
		absenceRepository.deleteById(id);
	}
}

