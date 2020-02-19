package com.ddiego.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddiego.entity.Profesional;
import com.ddiego.repository.ProfesionalRepositorio;

@Service
@Transactional
public class ProfesionalService {

	@Autowired
	ProfesionalRepositorio profesionalRepositorio;
	
	@PostConstruct
	public void init(){
		if(profesionalRepositorio.findAll().isEmpty()) {
			create("Diego", "Delgado", "Sistemas", "1234");
			create("Fede", "Mauro", "Sistemas", "5678");
			create("Maria", "Bengoechea", "Seguridad e Higiene", "3692");
			create("Flor", "Perez", "Diseñadora Indumentaria", "1472");
		}
	}
	
	public Profesional create(String nombre, String apellido, String profesion, String matricula) {
		Profesional pro = new Profesional();
		pro.setNombre(nombre);
		pro.setApellido(apellido);
		pro.setProfesion(profesion);
		pro.setMatricula(matricula);
		return profesionalRepositorio.save(pro);
	}
	
	public Profesional saveProfesional(Profesional profesional) {
		return profesionalRepositorio.save(profesional);
	}
	
	public Profesional updateProfesional(long idProfesional, Profesional profesional) {
		if(!existsById(idProfesional)) {
			throw new RuntimeException("NO EXISTE EL PROFESIONAL");
		}
		return profesionalRepositorio.save(profesional);
	}
	
	public void deleteProfesional(long idProfesional) {
		if(!existsById(idProfesional)) {
			throw new RuntimeException("NO EXISTE EL PROFESIONAL");
		}
		profesionalRepositorio.deleteById(idProfesional);;
	}
	
	public List<Profesional> findAll(){
		return profesionalRepositorio.findAll();
	}
	
	
	public Profesional getProfesional(long idProfesional) {
		if(!existsById(idProfesional)) {
			throw new RuntimeException("NO EXISTE EL PROFESIONAL");
		}
		return profesionalRepositorio.getOne(idProfesional);
	}
	
	public Profesional findByMatricula(String matricula) {
		return profesionalRepositorio.findByMatricula(matricula);
	}
	
	public boolean existsById(Long id) {
		return profesionalRepositorio.existsById(id);
	}
	
	
}
