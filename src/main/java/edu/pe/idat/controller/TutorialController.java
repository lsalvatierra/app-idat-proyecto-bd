package edu.pe.idat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import edu.pe.idat.model.Tutorial;
import edu.pe.idat.service.TutorialService;

@Controller
public class TutorialController {

	@Autowired
	private TutorialService tutorialService;
	
	@GetMapping("/frmListTutorial")
	public String frmListTutorial(Model model) {
		model.addAttribute("listtutoriales", tutorialService.listarTutoriales());
		return "frmListTutorial";
	}
	
	@GetMapping("/frmRegTutorial")
	public String frmRegTutorial(Model model) {
		model.addAttribute("tutorial", new Tutorial());
		return "frmRegTutorial";
	}
	
	@PostMapping("/frmRegTutorial")
	public String frmRegTutorial(@ModelAttribute("tutorial") Tutorial objtutorial, 
			Model model) {
		tutorialService.registrarTutorial(objtutorial);
		model.addAttribute("tutorial", new Tutorial());
		return "frmRegTutorial";
	}
	
}
