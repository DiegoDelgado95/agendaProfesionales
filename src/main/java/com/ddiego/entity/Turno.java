package com.ddiego.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Data
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Turno {

	@Id
	@GeneratedValue
	private long idTurno;
	
	private String numero;
	private String legajo;
	private String nombre;
	private String apellido;
	private String asistencia;
	private String constancia;
	
	@JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate fecha;
	
	@JsonFormat(pattern="HH:mm")
    private LocalTime horaInicio;
	
	@JsonFormat(pattern="HH:mm")
    private LocalTime horaFin;
	
	
	@ManyToOne
	private Profesional profesional;
}
