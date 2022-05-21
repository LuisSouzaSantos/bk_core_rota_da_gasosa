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
import br.com.fesa.rotadagasosa.message.FlagMessage;
import br.com.fesa.rotadagasosa.model.Flag;
import br.com.fesa.rotadagasosa.model.form.dto.BaseAdministratorItemForm;
import br.com.fesa.rotadagasosa.repository.FlagRepository;

class FlagServiceImplTest {

	@InjectMocks
	FlagServiceImpl flagService;
	
	Flag flagMock;
	
	@Mock
	FlagRepository flagRepository;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		flagMock = new Flag();
		flagMock.setName("RETURN");
		flagMock.setVisible(true);
	}
	
	Flag setUpFakeFlag1() {
		Flag flag = new Flag();
		flag.setId(1L);
		flag.setName("IPIRANGA");
		flag.setVisible(true);
		
		return flag;
	}
	
	Flag setUpFakeFlag2() {
		Flag flag2 = new Flag();
		flag2.setId(2L);
		flag2.setName("SHELL");
		flag2.setVisible(true);
		
		return flag2;
	}
	
	@Test
	void successSaveFlag() throws FlagException {
		BaseAdministratorItemForm flag = new BaseAdministratorItemForm();
		flag.setName("IPIRANGA");
		flag.setVisible(true);
		
		//when(flagRepository.findByName("IPIRANGA")).thenReturn(setUpFakeFlag1());
		when(flagRepository.save(Mockito.any())).thenReturn(setUpFakeFlag1());
		
		Flag createdFlag = flagService.save(flag);
		
		assertNotNull(createdFlag);
	}
	
	@Test
	void errorSaveFlag(){
		FlagException thrown = Assertions.assertThrows(FlagException.class, () -> {
			BaseAdministratorItemForm flag = new BaseAdministratorItemForm();
			flag.setName("IPIRANGA");
			flag.setVisible(true);
			
			when(flagRepository.findByName("IPIRANGA")).thenReturn(setUpFakeFlag1());
			
			flagService.save(flag);
		});
		
		assertEquals(FlagMessage.ERROR_DUPLICATE, thrown.getMessage());
	}
	
	@Test
	void successEditFlag() throws FlagException {
		Flag flag = new Flag();
		flag.setId(1L);
		flag.setName("FLOR");
		flag.setVisible(true);
		
		when(flagRepository.findById(1L)).thenReturn(Optional.of(setUpFakeFlag1()));
		when(flagRepository.findByName("FLOR")).thenReturn(null);
		when(flagRepository.save(Mockito.any())).thenReturn(setUpFakeFlag1());
		
		Flag editedFlag = flagService.edit(flag);
		
		assertNotNull(editedFlag);
	}
	
	@Test
	void errorEditFlag() {
		FlagException thrown = Assertions.assertThrows(FlagException.class, () -> {
			Flag flag = new Flag();
			flag.setId(2L);
			flag.setName("IPIRANGA");
			flag.setVisible(true);
			
			when(flagRepository.findById(2L)).thenReturn(Optional.of(setUpFakeFlag2()));
			when(flagRepository.findByName("IPIRANGA")).thenReturn(setUpFakeFlag1());
			when(flagRepository.save(Mockito.any())).thenReturn(setUpFakeFlag1());
			
			flagService.edit(flag);
		});
		
		assertEquals(FlagMessage.ERROR_DUPLICATE, thrown.getMessage());
	}

}