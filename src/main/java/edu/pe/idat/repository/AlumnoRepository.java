package edu.pe.idat.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.pe.idat.model.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, String> {

	@Transactional
	@Modifying
	@Query(value ="{call sp_MantRegistrarAlumno(:nomalumno, :apealumno, :idesp, :proce)}",
			nativeQuery = true)
	void registrarAlumno(@Param("nomalumno") String nomalumno,
			@Param("apealumno") String apealumno,
			@Param("idesp") String idesp,
			@Param("proce") String proce);
	
	
	@Transactional
	@Modifying
	@Query(value ="{call sp_MantActualizarAlumno(:codalumno, :nomalumno, :apealumno, :idesp, :proce)}",
			nativeQuery = true)
	void actualizarAlumno(@Param("codalumno") String codalumno,
			@Param("nomalumno") String nomalumno,
			@Param("apealumno") String apealumno,
			@Param("idesp") String idesp,
			@Param("proce") String proce);
}
