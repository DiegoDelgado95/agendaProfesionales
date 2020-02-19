package com.ddiego.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Data
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Profesional {

	@Id
	@GeneratedValue
	private long idProfesional;
	
	private String nombre;
	private String apellido;
	private String profesion;
	private String matricula;
	
	@JsonIgnore
	@OneToMany(mappedBy="profesional")
	private List<Turno> turno = new ArrayList<>();
	
	
	
	
}
