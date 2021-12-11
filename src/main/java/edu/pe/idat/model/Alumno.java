package edu.pe.idat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "alumno")
public class Alumno {
	@Id
	private String idalumno;
	@Column(name = "apealumno")
	private String apealumno;
	@Column(name = "nomalumno")
	private String nomalumno;
	@Column(name = "idesp")
	private String idesp;
	@Column(name = "proce")
	private String proce;
	
	
}
