package br.com.fesa.rotadagasosa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fesa.rotadagasosa.model.Flag;

public interface FlagRepository extends JpaRepository<Flag, Long> {

	public Flag findByName(String name);
	
}