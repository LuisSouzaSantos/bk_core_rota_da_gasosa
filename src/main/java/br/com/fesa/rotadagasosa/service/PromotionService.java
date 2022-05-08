package br.com.fesa.rotadagasosa.service;

import java.util.List;

import br.com.fesa.rotadagasosa.exception.PromotionException;
import br.com.fesa.rotadagasosa.model.Promotion;
import br.com.fesa.rotadagasosa.model.form.dto.BaseAdministratorItemForm;

public interface PromotionService {

	public Promotion save(BaseAdministratorItemForm form) throws PromotionException;
	
	public Promotion edit(Promotion promotion) throws PromotionException;
	
	public void delete(Long id) throws PromotionException;
	
	public List<Promotion> getAll();
	
}