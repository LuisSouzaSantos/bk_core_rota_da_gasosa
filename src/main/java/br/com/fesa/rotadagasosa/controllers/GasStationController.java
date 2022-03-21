package br.com.fesa.rotadagasosa.controllers;

import java.time.DayOfWeek;
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

import br.com.fesa.rotadagasosa.model.AvailableTime;
import br.com.fesa.rotadagasosa.model.AvailableTimeDetails;
import br.com.fesa.rotadagasosa.model.Fuel;
import br.com.fesa.rotadagasosa.model.FuelDetails;
import br.com.fesa.rotadagasosa.model.GasStation;
import br.com.fesa.rotadagasosa.model.Promotion;
import br.com.fesa.rotadagasosa.model.PromotionDetails;
import br.com.fesa.rotadagasosa.model.Service;
import br.com.fesa.rotadagasosa.model.ServiceDetails;

@CrossOrigin
@RestController
@RequestMapping("/gasStation")
public class GasStationController {
	
	@PostMapping
	public ResponseEntity<GasStation> saveGasStation(){
		return ResponseEntity.ok(gasStationMock());
	}
	
	@PutMapping
	public ResponseEntity<GasStation> updateGasStation(){
		return ResponseEntity.ok(gasStationMock());
	}
	
	@GetMapping
	public ResponseEntity<List<GasStation>> getAllGasStation(){
		return ResponseEntity.ok(new ArrayList<GasStation>(Arrays.asList(gasStationMock())));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<GasStation> getGasStationById(@PathVariable Long id){
		return ResponseEntity.ok(gasStationMock());
	}
	
	@DeleteMapping("/{id}")
	public void deleteGasStation(@PathVariable Long id){
		
	}
	
	@PostMapping("/near")
	public ResponseEntity<List<GasStation>> getAllgasStationNearCurrentCustomerDirection(){
		return ResponseEntity.ok(new ArrayList<GasStation>(Arrays.asList(gasStationMock())));
	}
	

	private GasStation gasStationMock() {
		GasStation gasStation = new GasStation();
		
		gasStation.setId(1L);
		gasStation.setName("IPIRANGA DOIS");
		gasStation.setPassword("senhaAleatoria");
		gasStation.setCnpj("12345678912345");
		gasStation.setCep("01001000");
		gasStation.setAddress("Rua das Aves");
		gasStation.setAddressNumber("100");
		gasStation.setLatitude(12.34);
		gasStation.setLongitude(121.34);
		gasStation.setAvailableTimeStart(ZonedDateTime.now());
		gasStation.setAvailableTimeEnd(ZonedDateTime.now());
		gasStation.setActive(true);
		gasStation.setVerified(true);
		
		Fuel fuel = new Fuel();
		fuel.setId(1L);
		fuel.setName("GASOLINE");
		fuel.setVisible(true);
		
		FuelDetails fuelDetails = new FuelDetails();
		fuelDetails.setId(1L);
		fuelDetails.setFuel(fuel);
		fuelDetails.setAvailable(true);
		fuelDetails.setPrice(2.34);
		
		Service service = new Service();
		service.setId(1L);
		service.setName("RESTAURANT");
		service.setVisible(true);
		
		ServiceDetails serviceDetails = new ServiceDetails();
		serviceDetails.setId(1L);
		serviceDetails.setAvailable(true);
		serviceDetails.setOperatingDays(Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.SATURDAY));
		serviceDetails.setStartTime(ZonedDateTime.now());
		serviceDetails.setEndTime(ZonedDateTime.now());
		serviceDetails.setService(service);
		
		AvailableTime availableTime = new AvailableTime();
		availableTime.setId(1L);
		availableTime.setName("AVAILABLE");
		availableTime.setVisible(true);
		
		AvailableTimeDetails availableTimeDetails = new AvailableTimeDetails();
		availableTimeDetails.setId(1L);
		availableTimeDetails.setOperatingsDay(Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.SATURDAY));
		availableTimeDetails.setStartTime(ZonedDateTime.now());
		availableTimeDetails.setEndTime(ZonedDateTime.now());
		availableTimeDetails.setAvailableTime(availableTime);
		
		Promotion promotion = new Promotion();
		promotion.setId(1L);
		promotion.setName("BASIC");
		promotion.setVisible(true);
		
		PromotionDetails promotionDetails = new PromotionDetails();
		promotionDetails.setId(1L);
		promotionDetails.setPromotion(promotion);
		promotionDetails.setDescription("Gasolina a R$1.00");
		promotionDetails.setTitle("Promocao rapida");
		promotionDetails.setStartTime(ZonedDateTime.now());
		promotionDetails.setEndTime(ZonedDateTime.now());
		
		gasStation.setFuelDetailsList(Arrays.asList(fuelDetails));
		gasStation.setServiceDetailsList(Arrays.asList(serviceDetails));
		gasStation.setAvailablesDetailsList(Arrays.asList(availableTimeDetails));
		gasStation.setPromotionsDetailsList(Arrays.asList(promotionDetails));
		
		return gasStation;
	}
	
}
