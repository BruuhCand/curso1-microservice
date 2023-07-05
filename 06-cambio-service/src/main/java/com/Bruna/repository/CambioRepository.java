package com.Bruna.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Bruna.entities.Cambio;

public interface CambioRepository extends JpaRepository<Cambio, Long>{
	
	Cambio findByFromAndTo(String from, String to);
}
