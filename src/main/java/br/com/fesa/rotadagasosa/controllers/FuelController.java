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

import br.com.fesa.rotadagasosa.model.Fuel;

@CrossOrigin
@RestController
@RequestMapping("/fuel")
public class FuelController {

	@PostMapping
	public ResponseEntity<Fuel> saveFuel(@RequestBody Fuel fuel){
		return ResponseEntity.ok(fuelMock());
	}
	
	@PutMapping
	public ResponseEntity<Fuel> updateFuel(@RequestBody Fuel fuel){
		return ResponseEntity.ok(fuelMock());
	}
	
	@GetMapping
	public ResponseEntity<List<Fuel>> getAllFuels(){
		return ResponseEntity.ok(new ArrayList<Fuel>(Arrays.asList(fuelMock())));
	}
	
	private Fuel fuelMock() {
		Fuel fuel = new Fuel();
		fuel.setId(1L);
		fuel.setName("DIESEL");
		fuel.setVisible(true);
		
		return fuel;
	}
	
}
