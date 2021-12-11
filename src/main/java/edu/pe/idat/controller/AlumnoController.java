package edu.pe.idat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.qbo.model.response.ResultadoResponse;
import edu.pe.idat.model.Alumno;
import edu.pe.idat.model.sp.AlumnoSp;
import edu.pe.idat.service.AlumnoService;
import edu.pe.idat.service.EspecialidadService;


@Controller
@RequestMapping("/Alumno")
public class AlumnoController {

	@Autowired
	private AlumnoService alumnoService;
	@Autowired
	private EspecialidadService especialidadService;
	
	@GetMapping("/frmMantAlumno")
	public String frmMantAlumno(Model model) {
		model.addAttribute("listalumnos", alumnoService.listarAlumnos());
		model.addAttribute("listespecialidad", especialidadService.listarEspecialidad());
		return "Alumno/frmMantAlumno";
	}
	
	@PostMapping("/registrarAlumno")
	@ResponseBody
	public ResultadoResponse registrarCurso(@RequestBody Alumno objalumno) {
		String mensaje = "Alumno registrado correctamente";
		Boolean respuesta = true;
		try {
			alumnoService.registrarAlumno(objalumno);
		}catch(Exception ex) {
			mensaje ="Alumno no registrado.";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}
	
	@GetMapping("/listarAlumnos")
	@ResponseBody
	public List<AlumnoSp> listarAlumnos(){
		return alumnoService.listarAlumnos();
	}
	
	
	@DeleteMapping("/eliminarAlumno")
	@ResponseBody
	public ResultadoResponse eliminarCurso(@RequestBody Alumno objalumno) {
		String mensaje = "Alumno eliminado correctamente";
		Boolean respuesta = true;
		try {
			alumnoService.eliminarAlumno(objalumno);
		}catch(Exception ex) {
			mensaje = "El alumno no fue eliminado.";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}
}
