package br.com.fesa.rotadagasosa.model.dto;

import br.com.fesa.rotadagasosa.utils.Utils;

public class LoginDTO {

	private String username;
	private String token;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = Utils.sanitizerInput(username);
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = Utils.sanitizerInput(token);
	}
	
}