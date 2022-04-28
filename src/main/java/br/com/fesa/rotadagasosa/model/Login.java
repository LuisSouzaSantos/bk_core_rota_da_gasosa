package br.com.fesa.rotadagasosa.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



import br.com.fesa.rotadagasosa.message.AuthenticationMessage;
import br.com.fesa.rotadagasosa.model.dto.LoginDTO;
import br.com.fesa.rotadagasosa.model.types.CredentialsType;
import br.com.fesa.rotadagasosa.utils.Utils;

public class Login implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = AuthenticationMessage.ERROR_USERNAME_FIELD)
	private String username;
	@NotBlank(message = AuthenticationMessage.ERROR_PASSWORD_FIELD)
	private String password;
	private String token;
	@NotNull(message = AuthenticationMessage.ERROR_CREDENTIALS_TYPE_FIELD)
	private CredentialsType credentialsType;
	
	public Login() {}
	
	public Login(String username, String password, CredentialsType credentialsType) {
		this.setUsername(username);
		this.setPassword(password);
		this.credentialsType = credentialsType;
	}
	
	public Login(String username, String password, String credentialsType) {
		this.setUsername(username);
		this.setPassword(password);
		this.credentialsType = CredentialsType.valueOf(credentialsType);
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = Utils.sanitizerInput(username);
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = Utils.sanitizerInput(password);
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public CredentialsType getCredentialsType() {
		return credentialsType;
	}
	
	public void setCredentialsType(CredentialsType credentialsType) {
		this.credentialsType = credentialsType;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<GrantedAuthority>();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public LoginDTO toDTO() {
		LoginDTO loginDTO = new LoginDTO();
		
		loginDTO.setToken(this.token);
		loginDTO.setUsername(this.username);
		
		return loginDTO;
	}
		
}