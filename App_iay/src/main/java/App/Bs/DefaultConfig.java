package App.Bs;

import App.Bs.Absence.Absence;
import App.Bs.Departement.Departement;
import App.Bs.Departement.DepartementRepository;
import App.Bs.Filiere.Filiere;
import App.Bs.Filiere.FiliereRepository;
import App.Bs.Filiere.NomSemstre;
import App.Bs.Module.ModuleRepository;
import App.Bs.Module.module;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DefaultConfig{

	private final DepartementRepository departementRepository;
	private final FiliereRepository filiereRepository;
	private final ModuleRepository moduleRepository;

	public DefaultConfig(DepartementRepository departementRepository, FiliereRepository filiereRepository,
								  ModuleRepository moduleRepository) {
		this.departementRepository = departementRepository;
		this.filiereRepository = filiereRepository;
		this.moduleRepository = moduleRepository;
	}

	@PostConstruct
	@Transactional
	public void initDefaultData() {
		// Create default departments
		Departement informatique = new Departement("Informatique");
		Departement gestion = new Departement("Mathematique");
		// Create default programs
		Filiere informatiqueFiliere = new Filiere("m2i", NomSemstre.s1,informatique);
		Filiere gestionFiliere = new Filiere("sdia", NomSemstre.s1,gestion);

		// Create default modules
		module java = new module("JAKARTA EE", informatiqueFiliere);
		module accounting = new module("TECHNOLOGIE IO ET IOT", informatiqueFiliere);

		if( (departementRepository.existsById(informatique.getId())  &&
				!departementRepository.existsById(gestion.getId()) &&
		!filiereRepository.existsById(gestionFiliere.getId()) &&
				!filiereRepository.existsById(informatiqueFiliere.getId())
				&& moduleRepository.existsById(java.getId()) &&
				moduleRepository.existsById(accounting.getId())
		) == false )
		{
		departementRepository.saveAll(Arrays.asList(informatique, gestion));


		filiereRepository.saveAll(Arrays.asList(informatiqueFiliere, gestionFiliere));


		moduleRepository.saveAll(Arrays.asList(java, accounting));
		}
	}
}
