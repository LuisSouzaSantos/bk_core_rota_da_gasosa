package br.com.fesa.rotadagasosa.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fesa.rotadagasosa.exception.PromotionException;
import br.com.fesa.rotadagasosa.model.PathAuthentication;
import br.com.fesa.rotadagasosa.model.Promotion;
import br.com.fesa.rotadagasosa.model.form.dto.BaseAdministratorItemForm;
import br.com.fesa.rotadagasosa.service.PromotionService;

@CrossOrigin
@RestController
@RequestMapping("/promotion")
public class PromotionController {
	
	public final static List<PathAuthentication> APIS_GET = Arrays.asList();
	public final static List<PathAuthentication> APIS_POST = Arrays.asList();
	public final static List<PathAuthentication> APIS_PUT = Arrays.asList();
	public final static List<PathAuthentication> APIS_DELETE = Arrays.asList();
	
	@Autowired
	private PromotionService promotionService;

	@PostMapping
	public ResponseEntity<Promotion> savePromotion(@RequestBody BaseAdministratorItemForm form) throws PromotionException{
		Promotion savedPromotion = promotionService.save(form);
		
		return ResponseEntity.ok(savedPromotion);
	}
	
	@PutMapping
	public ResponseEntity<Promotion> updatePromotion(@RequestBody Promotion promotion) throws PromotionException{
		Promotion editedPromotion = promotionService.edit(promotion);
		
		return ResponseEntity.ok(editedPromotion);
	}
	
	@GetMapping
	public ResponseEntity<List<Promotion>> getAllPromotions(){
		List<Promotion> promotionList = promotionService.getAll();
		
		return ResponseEntity.ok(promotionList);
	}
	
	@DeleteMapping("/{id}")
	public void deletePromotion(@PathVariable Long id) throws PromotionException {
		promotionService.delete(id);
	}

}