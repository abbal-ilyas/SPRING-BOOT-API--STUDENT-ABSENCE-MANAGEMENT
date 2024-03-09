package App.Bs.Module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/modules")
public class ModuleController {

	private final ModuleService moduleService;

	@Autowired
	public ModuleController(ModuleService moduleService) {
		this.moduleService = moduleService;
	}

	// Ajouter des endpoints REST pour la gestion des modules
}
