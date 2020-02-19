package com.ddiego.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ddiego.entity.Turno;

@Repository
public interface TurnoRepositorio extends JpaRepository<Turno, Long> {
	List<Turno> findByProfesional_IdProfesional(Long idProfesional);
}
