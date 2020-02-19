package com.ddiego.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ddiego.entity.Turno;
import com.ddiego.service.TurnoService;

@RestController
public class TurnoController {

	@Autowired
	TurnoService turnoService;
	
	@GetMapping("/api/{idProfesional}/turnos")
	public ResponseEntity<List<Turno>> getTurnos(@PathVariable long idProfesional){
		return ResponseEntity.status(HttpStatus.OK).body(turnoService.findAll(idProfesional));
	}
	
	@PostMapping("/api/{idProfesional}/turno")
	public ResponseEntity<Turno> crear(@PathVariable Long idProfesional, @RequestBody Turno turno){
		return ResponseEntity.status(HttpStatus.CREATED).body(turnoService.saveTurno(idProfesional, turno));
	}
	
	@PutMapping("/api/{idProfesional}/turno/{idTurno}")
	public ResponseEntity<Turno> updateTurno(@PathVariable long idProfesional,@PathVariable long idTurno, @RequestBody Turno turno){
		return ResponseEntity.status(HttpStatus.OK).body(turnoService.updateTurno(idProfesional, idTurno, turno));
	}
	
	@DeleteMapping("/api/{idProfesional}/turno/{idTurno}")
	public ResponseEntity<Void> deleteTurno(@PathVariable long idProfesional, @PathVariable long idTurno){
		turnoService.deleteTurno(idProfesional, idTurno);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
}
