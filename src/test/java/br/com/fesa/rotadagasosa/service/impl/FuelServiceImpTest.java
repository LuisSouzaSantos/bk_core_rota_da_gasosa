package br.com.fesa.rotadagasosa.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.fesa.rotadagasosa.exception.FlagException;
import br.com.fesa.rotadagasosa.exception.FuelException;
import br.com.fesa.rotadagasosa.message.FuelMesage;
import br.com.fesa.rotadagasosa.model.Fuel;
import br.com.fesa.rotadagasosa.model.form.dto.BaseAdministratorItemForm;
import br.com.fesa.rotadagasosa.repository.FuelRepository;

class FuelServiceImpTest {
	
	@InjectMocks
	FuelServiceImp fuelService;
	
	@Mock
	FuelRepository fuelRepository;

	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	Fuel setUpFakeFuel1() {
		Fuel fuel = new Fuel();
		fuel.setId(1L);
		fuel.setName("GASOLINA");
		fuel.setVisible(true);
		
		return fuel;
	}
	
	Fuel setUpFakeFuel2() {
		Fuel fuel2 = new Fuel();
		fuel2.setId(2L);
		fuel2.setName("ALCOOL");
		fuel2.setVisible(true);
		
		return fuel2;
	}

	@Test
	void successSaveFuel() throws FuelException {
		BaseAdministratorItemForm fuel = new BaseAdministratorItemForm();
		fuel.setName("DIESEL");
		fuel.setVisible(true);
		
		when(fuelRepository.save(Mockito.any())).thenReturn(setUpFakeFuel1());
		
		Fuel createdFuel = fuelService.save(fuel);
		
		assertNotNull(createdFuel);
	}
	
	@Test
	void errorSaveFuel() {
		FuelException thrown = Assertions.assertThrows(FuelException.class, () -> {
			BaseAdministratorItemForm fuel = new BaseAdministratorItemForm();
			fuel.setName("GASOLINA");
			fuel.setVisible(true);
			
			when(fuelRepository.findByName("GASOLINA")).thenReturn(setUpFakeFuel1());
			
			fuelService.save(fuel);
		});
		
		assertEquals(FuelMesage.ERROR_DUPLICATE, thrown.getMessage());
	}
	
	@Test
	void successEditFuel() throws FuelException {
		Fuel fuel = new Fuel();
		fuel.setId(1L);
		fuel.setName("GNV");
		fuel.setVisible(true);
		
		when(fuelRepository.findById(1L)).thenReturn(Optional.of(setUpFakeFuel1()));
		when(fuelRepository.findByName("GNV")).thenReturn(null);
		when(fuelRepository.save(Mockito.any())).thenReturn(setUpFakeFuel1());
		
		Fuel editedFuel = fuelService.edit(fuel);
		
		assertNotNull(editedFuel);
	}
	
	@Test
	void errorEditFuel() throws FuelException {
		FlagException thrown = Assertions.assertThrows(FlagException.class, () -> {
			Fuel fuel = new Fuel();
			fuel.setId(2L);
			fuel.setName("GASOLINA");
			fuel.setVisible(true);
			
			when(fuelRepository.findById(2L)).thenReturn(Optional.of(setUpFakeFuel2()));
			when(fuelRepository.findByName("GASOLINA")).thenReturn(setUpFakeFuel1());
			when(fuelRepository.save(Mockito.any())).thenReturn(setUpFakeFuel1());
			
			fuelService.edit(fuel);
		});
		
		assertEquals(FuelMesage.ERROR_DUPLICATE, thrown.getMessage());
	}

}
