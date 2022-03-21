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

import br.com.fesa.rotadagasosa.model.Service;

@CrossOrigin
@RestController
@RequestMapping("/service")
public class ServiceController {

	@PostMapping
	public ResponseEntity<Service> saveService(@RequestBody Service service){
		return ResponseEntity.ok(serviceMock());
	}
	
	@PutMapping
	public ResponseEntity<Service> updateService(@RequestBody Service service){
		return ResponseEntity.ok(serviceMock());
	}
	
	@GetMapping
	public ResponseEntity<List<Service>> getAllServices(){
		return ResponseEntity.ok(new ArrayList<Service>(Arrays.asList(serviceMock())));
	}
	
	private Service serviceMock() {
		Service service = new Service();
		service.setId(1L);
		service.setName("RESTAURANT");
		service.setVisible(true);
		
		return service;
	}
	
}
