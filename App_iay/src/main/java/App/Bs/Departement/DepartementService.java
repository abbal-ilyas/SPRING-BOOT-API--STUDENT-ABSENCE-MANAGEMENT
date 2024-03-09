package App.Bs.Departement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartementService {

	private final DepartementRepository departementRepository;

	@Autowired
	public DepartementService(DepartementRepository departementRepository) {
		this.departementRepository = departementRepository;
	}

	// Ajoutez des méthodes de service (CRUD, etc.) en fonction de vos besoins

	public List<Departement> getAllDepartements() {
		return departementRepository.findAll();
	}

	public Departement getDepartementById(Long id) {
		return departementRepository.findById(id).orElse(null);
	}

	public Departement saveDepartement(Departement departement) {
		return departementRepository.save(departement);
	}

	public void deleteDepartement(Long id) {
		departementRepository.deleteById(id);
	}
}
