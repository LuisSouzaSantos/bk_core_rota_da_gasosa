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

import br.com.fesa.rotadagasosa.exception.ServiceException;
import br.com.fesa.rotadagasosa.model.Service;
import br.com.fesa.rotadagasosa.model.form.dto.BaseAdministratorItemForm;
import br.com.fesa.rotadagasosa.repository.ServiceRepository;
import br.com.fesa.rotadagasosa.service.ServiceService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ServiceServiceTests {

	@Mock
	ServiceRepository serviceRepository;

	@InjectMocks
	ServiceService serviceService;
	
	public void setUp() {
		Service service = new Service();
		service.setId(1L);
		service.setName("LOJA");
		service.setVisible(true);
		
		Service service2 = new Service();
		service2.setId(2L);
		service2.setName("CAIXA 24 HORAS");
		service2.setVisible(true);
		
		when(serviceRepository.save(service)).thenReturn(service);
		when(serviceRepository.save(service2)).thenReturn(service2);
	}
	
	@Test
	public void successSaveService() throws ServiceException {
		setUp();
		
		BaseAdministratorItemForm service = new BaseAdministratorItemForm();
		service.setName("SUPORTE PARA CARROS ELETRICOS");
		service.setVisible(true);
		
		Service createdService = serviceService.save(service);
		
		assertNotNull(createdService);
	}
	
	@Test(expected = ServiceException.class)
	public void errorSaveService() throws ServiceException {
		setUp();
		
		BaseAdministratorItemForm service = new BaseAdministratorItemForm();
		service.setName("LOJA");
		service.setVisible(true);
		
		Service createdService = serviceService.save(service);
		
		assertNotNull(createdService);
	}
	
	@Test
	public void successEditService() throws ServiceException {
		setUp();
		
		Service service = new Service();
		service.setId(1L);
		service.setName("FLOR");
		service.setVisible(true);
		
		Service editedService = serviceService.edit(service);
		
		assertNotNull(editedService);
	}
	
	@Test(expected = ServiceException.class)
	public void errorEditService() throws ServiceException {
		setUp();
		
		Service service = new Service();
		service.setId(2L);
		service.setName("LOJA");
		service.setVisible(true);
		
		Service editedService = serviceService.edit(service);
		
		assertNotNull(editedService);
	}
	
	@Test
	public void allFlag() {
		setUp();
		
		List<Service> serviceList = serviceService.getAll();
		
		assertNotNull(serviceList);
	}
	
}