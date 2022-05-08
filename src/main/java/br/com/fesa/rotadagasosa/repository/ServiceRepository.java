package br.com.fesa.rotadagasosa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fesa.rotadagasosa.model.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {

	public Service findByName(String name);
	
}
