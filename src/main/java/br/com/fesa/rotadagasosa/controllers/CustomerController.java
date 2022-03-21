package br.com.fesa.rotadagasosa.controllers;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fesa.rotadagasosa.model.Customer;
import br.com.fesa.rotadagasosa.model.Fuel;
import br.com.fesa.rotadagasosa.model.UsedGasStation;
import br.com.fesa.rotadagasosa.model.VehicleDetails;

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@PostMapping
	public ResponseEntity<Customer> saveCustomer(){
		return ResponseEntity.ok(customerMock());
	}
	
	@PutMapping
	public ResponseEntity<Customer> updateCustomer(){
		return ResponseEntity.ok(customerMock());
	}
	
	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomer(){
		return ResponseEntity.ok(new ArrayList<Customer>(Arrays.asList(customerMock())));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
		return ResponseEntity.ok(customerMock());
	}
	
	@DeleteMapping("/{id}")
	public void deleteCustomer(@PathVariable Long id){
		
	}
	
	private Customer customerMock() {
		Customer customer = new Customer();
		
		customer.setId(1L);
		customer.setName("Luis Gustavo de Souza Santos");
		customer.setPassword("senhaAleatoria");
		customer.setCpf("123456789123");
		customer.setCep("01001000");
		customer.setAddress("Rua das Aves");
		customer.setAddressNumber("100");
		customer.setAddressComplement("Apt 50");
		
		Fuel fuel = new Fuel();
		fuel.setId(1L);
		fuel.setName("GASOLINE");
		fuel.setVisible(true);
		
		VehicleDetails vehicleDetails = new VehicleDetails();
		vehicleDetails.setId(1L);
		vehicleDetails.setModel("ix35");
		vehicleDetails.setBrand("hyundai");
		vehicleDetails.setFuel(fuel);
		
		UsedGasStation usedGasStation = new UsedGasStation();
		usedGasStation.setId(1L);
		usedGasStation.setDate(ZonedDateTime.now());
		usedGasStation.setFuelAmount(23.34);
		usedGasStation.setLiterPrice(3.20);
		usedGasStation.setGasStation(null);
		
		customer.setUsedGasStationList(Arrays.asList(usedGasStation));
		customer.setVehicleList(Arrays.asList(vehicleDetails));
		
		customer.setActive(true);
		
		return customer;
	}
	
}
