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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ddiego.entity.Profesional;
import com.ddiego.service.ProfesionalService;

@RestController
public class ProfesionalController {

	@Autowired
	ProfesionalService profesionalService;
	
	@GetMapping("/api/profesional")
	public ResponseEntity<List<Profesional>> getAllProfesional(){
		return ResponseEntity.status(HttpStatus.OK).body(profesionalService.findAll());
	}
	
	@GetMapping("/api/profesional/matricula")
	public ResponseEntity<Profesional> getProfesionalMatricula(@RequestParam String matricula){
		return ResponseEntity.status(HttpStatus.OK).body(profesionalService.findByMatricula(matricula));
	}
	
	@GetMapping("/api/profesional/{idProfesional}")
	public ResponseEntity<Profesional> getProfesional(@PathVariable long idProfesional){
		return ResponseEntity.status(HttpStatus.OK).body(profesionalService.getProfesional(idProfesional));
	}
	
	@PostMapping("/api/profesional")
	public ResponseEntity<Profesional> saveProfesional(@RequestBody Profesional profesional){
		return ResponseEntity.status(HttpStatus.CREATED).body(profesionalService.saveProfesional(profesional));
	}
	
	@PutMapping("/api/profesional/{idProfesional}")
	public ResponseEntity<Profesional> updateProfesional(@PathVariable long idProfesional, @RequestBody Profesional profesional){
		return ResponseEntity.status(HttpStatus.OK).body(profesionalService.updateProfesional(idProfesional, profesional));
	}
	
	@DeleteMapping("/api/profesional/{idProfesional}")
	public ResponseEntity<Void> deleteProfesional(@PathVariable long idProfesional){
		profesionalService.deleteProfesional(idProfesional);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
}
