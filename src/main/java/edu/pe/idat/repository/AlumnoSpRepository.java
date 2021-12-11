package edu.pe.idat.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.pe.idat.model.sp.AlumnoSp;

@Repository
public interface AlumnoSpRepository extends JpaRepository<AlumnoSp, String> {


	@Query(value ="{call sp_MantListarAlumno()}",
			nativeQuery = true)
	List<AlumnoSp> listarAlumnos();
}
