package App.Bs.Filiere;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiliereService {

	private final FiliereRepository filiereRepository;

	@Autowired
	public FiliereService(FiliereRepository filiereRepository) {
		this.filiereRepository = filiereRepository;
	}

	// Ajoutez des méthodes de service (CRUD, etc.) en fonction de vos besoins

	public List<Filiere> getAllFilieres() {
		return filiereRepository.findAll();
	}

	public Filiere getFiliereById(Long id) {
		return filiereRepository.findById(id).orElse(null);
	}

	public Filiere saveFiliere(Filiere filiere) {
		return filiereRepository.save(filiere);
	}

	public void deleteFiliere(Long id) {
		filiereRepository.deleteById(id);
	}
}

