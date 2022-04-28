package br.com.fesa.rotadagasosa.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fesa.rotadagasosa.exception.LoginException;
import br.com.fesa.rotadagasosa.model.Login;
import br.com.fesa.rotadagasosa.model.PathAuthentication;
import br.com.fesa.rotadagasosa.model.dto.LoginDTO;
import br.com.fesa.rotadagasosa.model.types.PathAuthenticationType;
import br.com.fesa.rotadagasosa.service.LoginService;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthController {

	public final static List<PathAuthentication> APIS_GET = Arrays.asList();
	public final static List<PathAuthentication> APIS_POST = Arrays.asList(new PathAuthentication("/auth/authentication", PathAuthenticationType.NO_AUTHENTICATION_NEEDED));
	public final static List<PathAuthentication> APIS_PUT = Arrays.asList();
	public final static List<PathAuthentication> APIS_DELETE = Arrays.asList();
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/authentication")
	public ResponseEntity<LoginDTO>authentication(@RequestBody Login login) throws LoginException {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println(passwordEncoder.encode(login.getPassword()));
		
		login = loginService.authentication(login);
		
		return ResponseEntity.ok(login.toDTO());
	}
	

}