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

import br.com.fesa.rotadagasosa.exception.ServiceException;
import br.com.fesa.rotadagasosa.model.PathAuthentication;
import br.com.fesa.rotadagasosa.model.Service;
import br.com.fesa.rotadagasosa.model.form.dto.BaseAdministratorItemForm;
import br.com.fesa.rotadagasosa.service.ServiceService;

@CrossOrigin
@RestController
@RequestMapping("/service")
public class ServiceController {

	public final static List<PathAuthentication> APIS_GET = Arrays.asList();
	public final static List<PathAuthentication> APIS_POST = Arrays.asList();
	public final static List<PathAuthentication> APIS_PUT = Arrays.asList();
	public final static List<PathAuthentication> APIS_DELETE = Arrays.asList();
	
	@Autowired
	private ServiceService serviceService;
	
	@PostMapping
	public ResponseEntity<Service> saveService(@RequestBody BaseAdministratorItemForm form) throws ServiceException{
		Service savedService = serviceService.save(form);
		
		return ResponseEntity.ok(savedService);
	}
	
	@PutMapping
	public ResponseEntity<Service> updateService(@RequestBody Service service) throws ServiceException{
		Service editService = serviceService.edit(service);
		
		return ResponseEntity.ok(editService);
	}
	
	@GetMapping
	public ResponseEntity<List<Service>> getAllServices(){
		List<Service> serviceList = serviceService.getAll();
		
		return ResponseEntity.ok(serviceList);
	}
	
	@DeleteMapping("/{id}")
	public void deleteService(@PathVariable Long id) throws ServiceException {
		serviceService.delete(id);
	}
	
}