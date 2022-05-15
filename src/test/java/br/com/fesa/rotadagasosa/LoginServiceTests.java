package br.com.fesa.rotadagasosa;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.fesa.rotadagasosa.exception.LoginException;
import br.com.fesa.rotadagasosa.model.Administrator;
import br.com.fesa.rotadagasosa.model.Login;
import br.com.fesa.rotadagasosa.model.types.CredentialsType;
import br.com.fesa.rotadagasosa.repository.AdministratorRepository;
import br.com.fesa.rotadagasosa.service.AdministratorService;
import br.com.fesa.rotadagasosa.service.AuthService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class LoginServiceTests {
	
	@Mock
	AdministratorRepository administratorRepository;

	@InjectMocks
	AdministratorService administratorService;
	
	@InjectMocks
	AuthService authService;

	public void setUp() {
		Administrator administrator = new Administrator();
		administrator.setId(1L);
		administrator.setEmail("teste@hotmail.com");
		administrator.setPassword("123456");
		
		when(administratorRepository.save(administrator)).thenReturn(administrator);
	}
	
	@Test
	public void sucessAuthentication() throws LoginException {
		setUp();
		
		Login login = new Login("teste@hotmail.com", "123456", CredentialsType.ADMINISTRATOR);
				
		Login authenticatedLogin = authService.authentication(login);
		
		assertNotNull(authenticatedLogin);
	}
	
	@Test(expected = LoginException.class)
	public void errorAuthentication() throws LoginException {
		setUp();
		
		Login login = new Login("local@hotmail.com", "123456", CredentialsType.ADMINISTRATOR);
		
		Login authenticatedLogin = authService.authentication(login);
		
		assertNull(authenticatedLogin);
	}
		
}