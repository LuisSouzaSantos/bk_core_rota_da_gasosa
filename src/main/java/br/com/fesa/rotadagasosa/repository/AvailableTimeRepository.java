package br.com.fesa.rotadagasosa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fesa.rotadagasosa.model.AvailableTime;

public interface AvailableTimeRepository extends JpaRepository<AvailableTime, Long> {

	public AvailableTime findByName(String name);
	
}