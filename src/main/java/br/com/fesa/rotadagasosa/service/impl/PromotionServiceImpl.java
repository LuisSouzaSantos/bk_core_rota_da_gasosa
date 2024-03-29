package br.com.fesa.rotadagasosa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fesa.rotadagasosa.exception.PromotionException;
import br.com.fesa.rotadagasosa.message.PromotionsMessage;
import br.com.fesa.rotadagasosa.model.Promotion;
import br.com.fesa.rotadagasosa.model.form.dto.BaseAdministratorItemForm;
import br.com.fesa.rotadagasosa.repository.PromotionRepository;
import br.com.fesa.rotadagasosa.service.PromotionService;
import br.com.fesa.rotadagasosa.service.validator.PromotionValidator;

@Service
public class PromotionServiceImpl implements PromotionService {

	@Autowired
	private PromotionRepository promotionRepository;
	
	@Autowired
	private PromotionValidator promotionValidator;
	
	@Override
	public Promotion save(BaseAdministratorItemForm form) throws PromotionException {
		promotionValidator.validateForm(form);
		
		Promotion retrivedPromotionByName = getByName(form.getName());
		
		if(retrivedPromotionByName != null) { throw new PromotionException(PromotionsMessage.ERROR_DUPLICATE); }
		
		Promotion promotion = new Promotion();
		promotion.setName(form.getName());
		promotion.setVisible(form.isVisible());
		
		return promotionRepository.save(promotion);
	}

	@Override
	public Promotion edit(Promotion promotion) throws PromotionException {
		promotionValidator.validatePromotionFields(promotion);
		
		if(promotion.getId() == null) { throw new PromotionException(PromotionsMessage.ERROR_ID_NULL); }
		
		Promotion promotionById = getById(promotion.getId());
		
		if(promotionById == null) { throw new PromotionException(PromotionsMessage.ERROR_NULL); }
		
		Promotion promotionByName = getByName(promotion.getName());
		
		if((promotionByName != null) && (!promotionByName.getId().equals(promotionById.getId()))) { throw new PromotionException(PromotionsMessage.ERROR_DUPLICATE); }
		
		promotionById.setName(promotion.getName());
		promotionById.setVisible(promotion.getVisible());
		
		return promotionRepository.save(promotionById);
	}
	
	@Override
	public void delete(Long id) throws PromotionException {
		if(id == null) { throw new PromotionException(PromotionsMessage.ERROR_ID_NULL); } 
		
		promotionRepository.deleteById(id);
	}

	@Override
	public List<Promotion> getAll() {
		return promotionRepository.findAll();
	}
	
	private Promotion getByName(String name) {
		return promotionRepository.findByName(name);
	}
	
	private Promotion getById(Long id) {
		Optional<Promotion> promotion = promotionRepository.findById(id);
		
		if(promotion.isPresent() == false) { return null; }
		
		return promotion.get();
	}

}
