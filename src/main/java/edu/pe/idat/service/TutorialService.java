package edu.pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.idat.model.Tutorial;
import edu.pe.idat.repository.TutorialRepository;

@Service
public class TutorialService {
	
	@Autowired
	private TutorialRepository tutorialRepository;
	
	public List<Tutorial> listarTutoriales(){
		return tutorialRepository.findAll();
	}
	
	public void registrarTutorial(Tutorial tutorial) {
		tutorialRepository.save(tutorial);
	}
	
	

}
