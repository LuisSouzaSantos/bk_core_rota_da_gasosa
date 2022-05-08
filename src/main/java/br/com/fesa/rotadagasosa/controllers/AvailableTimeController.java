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

import br.com.fesa.rotadagasosa.exception.AvailableTimeException;
import br.com.fesa.rotadagasosa.model.AvailableTime;
import br.com.fesa.rotadagasosa.model.PathAuthentication;
import br.com.fesa.rotadagasosa.model.form.dto.BaseAdministratorItemForm;
import br.com.fesa.rotadagasosa.service.AvailableTimeService;

@CrossOrigin
@RestController
@RequestMapping("/availableTime")
public class AvailableTimeController {

	public final static List<PathAuthentication> APIS_GET = Arrays.asList();
	public final static List<PathAuthentication> APIS_POST = Arrays.asList();
	public final static List<PathAuthentication> APIS_PUT = Arrays.asList();
	public final static List<PathAuthentication> APIS_DELETE = Arrays.asList();

	@Autowired
	private AvailableTimeService availableTimeService;
	
	@PostMapping
	public ResponseEntity<AvailableTime> saveAvailableTime(@RequestBody BaseAdministratorItemForm form) throws AvailableTimeException{
		AvailableTime savedAvailableTime = availableTimeService.save(form);
		
		return ResponseEntity.ok(savedAvailableTime);
	}
	
	@PutMapping
	public ResponseEntity<AvailableTime> updateAvailableTime(@RequestBody AvailableTime availableTime) throws AvailableTimeException{
		AvailableTime editedAvailableTime = availableTimeService.edit(availableTime);
		
		return ResponseEntity.ok(editedAvailableTime);
	}
	
	@GetMapping
	public ResponseEntity<List<AvailableTime>> getAllAvailablesTime(){
		List<AvailableTime> availableTimeList = availableTimeService.getAll();
		
		return ResponseEntity.ok(availableTimeList);
	}
	
	@DeleteMapping("/{id}")
	public void deleteAvailableTime(@PathVariable Long id) throws AvailableTimeException {
		availableTimeService.delete(id);
	}
	
}