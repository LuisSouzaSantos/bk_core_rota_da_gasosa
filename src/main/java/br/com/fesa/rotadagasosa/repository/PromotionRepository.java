package br.com.fesa.rotadagasosa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fesa.rotadagasosa.model.Promotion;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {

	Promotion findByName(String name);
	
}
