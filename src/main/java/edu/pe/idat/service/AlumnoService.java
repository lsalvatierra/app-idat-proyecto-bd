package edu.pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.idat.model.Alumno;
import edu.pe.idat.model.sp.AlumnoSp;
import edu.pe.idat.repository.AlumnoRepository;
import edu.pe.idat.repository.AlumnoSpRepository;

@Service
public class AlumnoService {

	@Autowired
	private AlumnoRepository alumnoRepository;
	@Autowired
	private AlumnoSpRepository alumnoSpRepository;
	
	public List<AlumnoSp> listarAlumnos(){
		return alumnoSpRepository.listarAlumnos();
	}
	
	public void registrarAlumno(Alumno alumno) {
		if(alumno.getIdalumno().equals("0")) {
			alumnoRepository.registrarAlumno(alumno.getNomalumno(), alumno.getApealumno(),
					alumno.getIdesp(), alumno.getProce());
		}else {
			alumnoRepository.actualizarAlumno(alumno.getIdalumno(), alumno.getNomalumno(), alumno.getApealumno(),
					alumno.getIdesp(), alumno.getProce());
		}
	}
	
	public void eliminarAlumno(Alumno alumno) {
		alumnoRepository.deleteById(alumno.getIdalumno());
	}
}
