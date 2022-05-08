package br.com.fesa.rotadagasosa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fesa.rotadagasosa.model.Fuel;

public interface FuelRepository extends JpaRepository<Fuel, Long> {

	public Fuel findByName(String name);
	
}