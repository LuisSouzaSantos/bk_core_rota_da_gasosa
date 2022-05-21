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

import br.com.fesa.rotadagasosa.exception.ServiceException;
import br.com.fesa.rotadagasosa.message.ServiceMessage;
import br.com.fesa.rotadagasosa.model.Service;
import br.com.fesa.rotadagasosa.model.form.dto.BaseAdministratorItemForm;
import br.com.fesa.rotadagasosa.repository.ServiceRepository;
import br.com.fesa.rotadagasosa.service.validator.ServiceValidator;

class ServiceServiceImplTest {

	@InjectMocks
	ServiceServiceImpl serviceService;
	
	@Mock
	ServiceRepository serviceRepository;
	
	@InjectMocks
	ServiceValidator serviceValidator;

	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	Service setUpFakeService1() {
		Service service = new Service();
		service.setId(1L);
		service.setName("LOJA");
		service.setVisible(true);
		
		return service;
	}
	
	Service setUpFakeService2() {
		Service service2 = new Service();
		service2.setId(2L);
		service2.setName("CAIXA 24 HORAS");
		service2.setVisible(true);
		
		return service2;
	}

	@Test
	void successSaveService() throws ServiceException {
		BaseAdministratorItemForm service = new BaseAdministratorItemForm();
		service.setName("SUPORTE PARA CARROS ELETRICOS");
		service.setVisible(true);
		
		when(serviceRepository.save(Mockito.any())).thenReturn(setUpFakeService1());
		
		Service createdService = serviceService.save(service);
		
		assertNotNull(createdService);
	}
	
	@Test
	void errorSaveService() {
		ServiceException thrown = Assertions.assertThrows(ServiceException.class, () -> {
			BaseAdministratorItemForm service = new BaseAdministratorItemForm();
			service.setName("LOJA");
			service.setVisible(true);
			
			when(serviceRepository.findByName("LOJA")).thenReturn(setUpFakeService1());
			
			serviceService.save(service);
		});
		
		assertEquals(ServiceMessage.ERROR_DUPLICATE, thrown.getMessage());
	}
	
	@Test
	void successEditService() throws ServiceException {
		Service service = new Service();
		service.setId(1L);
		service.setName("FLOR");
		service.setVisible(true);
		
		when(serviceRepository.findById(1L)).thenReturn(Optional.of(setUpFakeService1()));
		when(serviceRepository.findByName("FLOR")).thenReturn(null);
		when(serviceRepository.save(Mockito.any())).thenReturn(setUpFakeService1());
		
		Service editedService = serviceService.edit(service);
		
		assertNotNull(editedService);
	}
	
	@Test
	void errorEditService() {
		ServiceException thrown = Assertions.assertThrows(ServiceException.class, () -> {
			Service service = new Service();
			service.setId(2L);
			service.setName("LOJA");
			service.setVisible(true);
			
			when(serviceRepository.findById(2L)).thenReturn(Optional.of(setUpFakeService2()));
			when(serviceRepository.findByName("LOJA")).thenReturn(setUpFakeService1());
			when(serviceRepository.save(Mockito.any())).thenReturn(setUpFakeService1());
			
			serviceService.edit(service);
		});
		
		assertEquals(ServiceMessage.ERROR_DUPLICATE, thrown.getMessage());
	}

}