package edu.pe.idat.model.sp;


import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class AlumnoSp {

	@Id
	private String idalumno;

	private String apealumno;

	private String nomalumno;

	private String idesp;

	private String proce;
	
	private String nomesp;
}
