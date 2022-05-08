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

import br.com.fesa.rotadagasosa.exception.FlagException;
import br.com.fesa.rotadagasosa.model.Flag;
import br.com.fesa.rotadagasosa.model.PathAuthentication;
import br.com.fesa.rotadagasosa.model.form.dto.BaseAdministratorItemForm;
import br.com.fesa.rotadagasosa.service.FlagService;

@CrossOrigin
@RestController
@RequestMapping("/flag")
public class FlagController {
	
	public final static List<PathAuthentication> APIS_GET = Arrays.asList();
	public final static List<PathAuthentication> APIS_POST = Arrays.asList();
	public final static List<PathAuthentication> APIS_PUT = Arrays.asList();
	public final static List<PathAuthentication> APIS_DELETE = Arrays.asList();
	
	@Autowired
	private FlagService flagService; 
	
	@PostMapping
	public ResponseEntity<Flag> saveFlag(@RequestBody BaseAdministratorItemForm form) throws FlagException{
		Flag savedFlag = flagService.save(form);
		
		return ResponseEntity.ok(savedFlag);
	}
	
	@PutMapping
	public ResponseEntity<Flag> updateFlag(@RequestBody Flag flag) throws FlagException{
		Flag editedFlag = flagService.edit(flag);
		
		return ResponseEntity.ok(editedFlag);
	}
	
	@GetMapping
	public ResponseEntity<List<Flag>> getAllFlags(){
		List<Flag> flagList = flagService.getAll();
		
		return ResponseEntity.ok(flagList);
	}
	
	@DeleteMapping("/{id}")
	public void deleteFlag(@PathVariable Long id) throws FlagException {
		flagService.delete(id);
	}
	
}