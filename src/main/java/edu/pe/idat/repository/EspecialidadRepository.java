package edu.pe.idat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.pe.idat.model.Especialidad;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, String> {

	
}
