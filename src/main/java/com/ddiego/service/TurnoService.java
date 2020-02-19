package com.ddiego.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddiego.entity.Turno;
import com.ddiego.repository.TurnoRepositorio;

@Service
@Transactional
public class TurnoService {
	
	@Autowired
	TurnoRepositorio turnoRepositorio;
	
	@Autowired
	ProfesionalService profesionalService;
	
	public Turno saveTurno(Long idProfesional, Turno turno) {
		if(!profesionalService.existsById(idProfesional)) {
			throw new RuntimeException("NO EXISTE EL PROFESIONAL");
		}
		turno.setProfesional(profesionalService.getProfesional(idProfesional));
		return turnoRepositorio.save(turno);
	}
	
	public List<Turno> findAll(Long idProfesional){
		if(!profesionalService.existsById(idProfesional)) {
			throw new RuntimeException("NO EXISTE EL PROFESIONAL");
		}
		return turnoRepositorio.findByProfesional_IdProfesional(idProfesional);
	}
	
	public Turno updateTurno(long idProfesional, long idTurno, Turno turno) {
		if(!profesionalService.existsById(idProfesional)) {
			throw new RuntimeException("NO EXISTE EL PROFESIONAL");
		}
		turno.setIdTurno(idTurno);
		turno.setProfesional(profesionalService.getProfesional(idProfesional));
		return turnoRepositorio.save(turno);
	}
	
	public void deleteTurno(long idProfesional, long idTurno) {
		if(!profesionalService.existsById(idProfesional)) {
			throw new RuntimeException("NO EXISTE EL PROFESIONAL");
		}
		turnoRepositorio.deleteById(idTurno);
	}

}
