package br.com.fesa.rotadagasosa.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import br.com.fesa.rotadagasosa.exception.LoginException;
import br.com.fesa.rotadagasosa.model.Login;
import br.com.fesa.rotadagasosa.model.types.CredentialsType;
import br.com.fesa.rotadagasosa.repository.AdministratorRepository;

class LoginServiceImplTest {
	
	@Mock
	AdministratorRepository administratorRepository;

	@InjectMocks
	AdministratorServiceImpl administratorService;
	
	@InjectMocks
	AuthServiceImpl authService;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void sucessAuthentication() throws LoginException {
		Login login = new Login("teste@hotmail.com", "123456", CredentialsType.ADMINISTRATOR);
		
		//when(fuelRepository.save(Mockito.any())).thenReturn(setUpFakeFuel1());

				
		Login authenticatedLogin = authService.authentication(login);
		
		assertNotNull(authenticatedLogin);
	}
	
	@Test
	void errorAuthentication() throws LoginException {
		Login login = new Login("local@hotmail.com", "123456", CredentialsType.ADMINISTRATOR);
		
		Login authenticatedLogin = authService.authentication(login);
		
		assertNull(authenticatedLogin);
	}

}
