package App.Bs.Seance;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeanceService {

	private final SeanceRepository seanceRepository;

	@Autowired
	public SeanceService(SeanceRepository seanceRepository) {
		this.seanceRepository = seanceRepository;
	}

	// Ajoutez des méthodes de service (CRUD, etc.) en fonction de vos besoins

	public List<Seance> getAllSeances() {
		return seanceRepository.findAll();
	}

	public Seance getSeanceById(Long id) {
		return seanceRepository.findById(id).orElse(null);
	}

	public Seance saveSeance(Seance seance) {
		return seanceRepository.save(seance);
	}

	public void deleteSeance(Long id) {
		seanceRepository.deleteById(id);
	}
}
