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

import br.com.fesa.rotadagasosa.exception.FlagException;
import br.com.fesa.rotadagasosa.model.Flag;
import br.com.fesa.rotadagasosa.model.form.dto.BaseAdministratorItemForm;
import br.com.fesa.rotadagasosa.repository.FlagRepository;
import br.com.fesa.rotadagasosa.service.FlagService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class FlagServiceTests {
	
	@Mock
	FlagRepository flagRepository;

	@InjectMocks
	FlagService flagService;
	
	public void setUp() {
		Flag flag = new Flag();
		flag.setId(1L);
		flag.setName("IPIRANGA");
		flag.setVisible(true);
		
		Flag flag2 = new Flag();
		flag2.setId(2L);
		flag2.setName("SHELL");
		flag2.setVisible(true);
		
		when(flagRepository.save(flag)).thenReturn(flag);
		when(flagRepository.save(flag2)).thenReturn(flag2);
	}
	
	@Test
	public void successSaveFlag() throws FlagException {
		setUp();
		
		BaseAdministratorItemForm flag = new BaseAdministratorItemForm();
		flag.setName("FLOR");
		flag.setVisible(true);
		
		Flag createdFlag = flagService.save(flag);
		
		assertNotNull(createdFlag);
	}
	
	@Test(expected = FlagException.class)
	public void errorSaveFlag() throws FlagException {
		setUp();
		
		BaseAdministratorItemForm flag = new BaseAdministratorItemForm();
		flag.setName("IPIRANGA");
		flag.setVisible(true);
		
		Flag createdFlag = flagService.save(flag);
		
		assertNotNull(createdFlag);
	}
	
	@Test
	public void successEditFlag() throws FlagException {
		setUp();
		
		Flag flag = new Flag();
		flag.setId(1L);
		flag.setName("FLOR");
		flag.setVisible(true);
		
		Flag editedFlag = flagService.edit(flag);
		
		assertNotNull(editedFlag);
	}
	
	@Test(expected = FlagException.class)
	public void errorEditFlag() throws FlagException {
		setUp();
		
		Flag flag = new Flag();
		flag.setId(2L);
		flag.setName("IPIRANGA");
		flag.setVisible(true);
		
		Flag editedFlag = flagService.edit(flag);
		
		assertNotNull(editedFlag);
	}
	
	@Test
	public void allFlag() {
		setUp();
		
		List<Flag> flagList = flagService.getAll();
		
		assertNotNull(flagList);
	}
	
}