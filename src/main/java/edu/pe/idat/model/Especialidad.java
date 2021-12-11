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
@Table(name = "especialidad")
public class Especialidad {
	@Id
	private String idesp;
	@Column(name ="nomesp")
	private String nomesp;
	@Column(name ="costo")
	private Double costo;
}
