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

import br.com.fesa.rotadagasosa.exception.FuelException;
import br.com.fesa.rotadagasosa.model.Fuel;
import br.com.fesa.rotadagasosa.model.PathAuthentication;
import br.com.fesa.rotadagasosa.model.form.dto.BaseAdministratorItemForm;
import br.com.fesa.rotadagasosa.service.FuelService;

@CrossOrigin
@RestController
@RequestMapping("/fuel")
public class FuelController {

	public final static List<PathAuthentication> APIS_GET = Arrays.asList();
	public final static List<PathAuthentication> APIS_POST = Arrays.asList();
	public final static List<PathAuthentication> APIS_PUT = Arrays.asList();
	public final static List<PathAuthentication> APIS_DELETE = Arrays.asList();
	
	@Autowired
	private FuelService fuelService;
	
	@PostMapping
	public ResponseEntity<Fuel> saveFuel(@RequestBody BaseAdministratorItemForm form) throws FuelException{
		Fuel savedFuel = fuelService.save(form);
		
		return ResponseEntity.ok(savedFuel);
	}
	
	@PutMapping
	public ResponseEntity<Fuel> updateFuel(@RequestBody Fuel fuel) throws FuelException{
		Fuel editedFuel = fuelService.edit(fuel);
		
		return ResponseEntity.ok(editedFuel);
	}
	
	@GetMapping
	public ResponseEntity<List<Fuel>> getAllFuels(){
		List<Fuel> fuelList = fuelService.getAll();
		
		return ResponseEntity.ok(fuelList);
	}
	
	@DeleteMapping("/{id}")
	public void deleteFuel(@PathVariable Long id) throws FuelException {
		fuelService.delete(id);
	}

}