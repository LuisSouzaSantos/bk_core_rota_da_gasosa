package br.com.fesa.rotadagasosa.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fesa.rotadagasosa.model.Promotion;

@CrossOrigin
@RestController
@RequestMapping("/promotion")
public class PromotionController {

	@PostMapping
	public ResponseEntity<Promotion> savePromotion(@RequestBody Promotion promotion){
		return ResponseEntity.ok(promotionMock());
	}
	
	@PutMapping
	public ResponseEntity<Promotion> updatePromotion(@RequestBody Promotion promotion){
		return ResponseEntity.ok(promotionMock());
	}
	
	@GetMapping
	public ResponseEntity<List<Promotion>> getAllPromotions(){
		return ResponseEntity.ok(new ArrayList<Promotion>(Arrays.asList(promotionMock())));
	}
	
	private Promotion promotionMock() {
		Promotion promotion = new Promotion();
		promotion.setId(1L);
		promotion.setName("BASED PROMOTION");
		promotion.setVisible(true);
		
		return promotion;
	}
	
}
