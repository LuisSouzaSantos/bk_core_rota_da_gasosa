package br.com.fesa.rotadagasosa;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.fesa.rotadagasosa.exception.FuelException;
import br.com.fesa.rotadagasosa.model.Fuel;
import br.com.fesa.rotadagasosa.model.form.dto.BaseAdministratorItemForm;
import br.com.fesa.rotadagasosa.repository.FuelRepository;
import br.com.fesa.rotadagasosa.service.FuelService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class FuelServiceTests {

	@Mock
	FuelRepository fuelRepository;

	@InjectMocks
	FuelService fuelService;
	
	public void setUp() {
		Fuel fuel = new Fuel();
		fuel.setId(1L);
		fuel.setName("GASOLINA");
		fuel.setVisible(true);
		
		Fuel fuel2 = new Fuel();
		fuel.setId(2L);
		fuel.setName("ALCOOL");
		fuel.setVisible(true);
		
		when(fuelRepository.save(fuel)).thenReturn(fuel);
		when(fuelRepository.save(fuel2)).thenReturn(fuel2);
	}
	
	@Test
	public void successSaveFuel() throws FuelException {
		setUp();
		
		BaseAdministratorItemForm fuel = new BaseAdministratorItemForm();
		fuel.setName("DIESEL");
		fuel.setVisible(true);
		
		Fuel createdFuel = fuelService.save(fuel);
		
		assertNotNull(createdFuel);
	}
	
	@Test(expected = FuelException.class)
	public void errorSaveFuel() throws FuelException {
		setUp();
		
		BaseAdministratorItemForm fuel = new BaseAdministratorItemForm();
		fuel.setName("GASOLINA");
		fuel.setVisible(true);
		
		Fuel createdFuel = fuelService.save(fuel);
		
		assertNotNull(createdFuel);
	}
	
	@Test
	public void successEditFuel() throws FuelException {
		setUp();
		
		Fuel fuel = new Fuel();
		fuel.setId(1L);
		fuel.setName("GNV");
		fuel.setVisible(true);
		
		Fuel editedFuel = fuelService.edit(fuel);
		
		assertNotNull(editedFuel);
	}
	
	@Test(expected = FuelException.class)
	public void errorEditFuel() throws FuelException {
		setUp();
		
		Fuel fuel = new Fuel();
		fuel.setId(2L);
		fuel.setName("GASOLINA");
		fuel.setVisible(true);
		
		Fuel editedFuel = fuelService.edit(fuel);
		
		assertNotNull(editedFuel);
	}
	
	@Test
	public void allFuel() {
		setUp();
		
		List<Fuel> fuelList = fuelService.getAll();
		
		assertNotNull(fuelList);
	}
	
}
