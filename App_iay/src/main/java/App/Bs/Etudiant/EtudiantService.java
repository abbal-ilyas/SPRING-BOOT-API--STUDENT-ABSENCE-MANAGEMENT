package App.Bs.Etudiant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EtudiantService {

	private final EtudiantRepository etudiantRepository;

	@Autowired
	public EtudiantService(EtudiantRepository etudiantRepository) {
		this.etudiantRepository = etudiantRepository;
	}

	public List<Etudiant> getAllEtudiants() {
		return etudiantRepository.findAll();
	}

	public Etudiant getEtudiantById(Long id) {
		return etudiantRepository.findById(id).orElse(null);
	}
	public Etudiant getEtudiantByNumero(String numero) {
        return etudiantRepository.findByNumero(numero).orElse(null);
    }
	public Etudiant saveEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }
	public void deleteEtudiant(String numero, String nom) {
        etudiantRepository.deleteEtudiantByNumeroAndNom(numero, nom);
    }

	// Ajoutez d'autres méthodes de service en fonction de vos besoins
}

