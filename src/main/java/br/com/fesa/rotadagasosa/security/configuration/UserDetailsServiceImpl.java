package br.com.fesa.rotadagasosa.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.fesa.rotadagasosa.message.AuthenticationMessage;
import br.com.fesa.rotadagasosa.model.Login;
import br.com.fesa.rotadagasosa.service.LoginService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService  {

	@Autowired
	private LoginService loginService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Login login = loginService.getByUsername(username);
			
		if(login == null) { throw new UsernameNotFoundException(AuthenticationMessage.LOGIN_NOT_FOUND); }
		
		return login;
	}
	
}