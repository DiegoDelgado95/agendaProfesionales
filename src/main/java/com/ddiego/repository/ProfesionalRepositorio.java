package com.ddiego.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ddiego.entity.Profesional;

@Repository
public interface ProfesionalRepositorio extends JpaRepository<Profesional, Long> {
	Profesional findByNombre(String nombre);
	Profesional findByMatricula(String matricula);
}
