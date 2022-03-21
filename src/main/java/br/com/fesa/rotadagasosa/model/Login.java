package br.com.fesa.rotadagasosa.model;

import br.com.fesa.rotadagasosa.model.types.CredentialsType;

public class Login {

	private String username;
	private String password;
	private CredentialsType credentialsType;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public CredentialsType getCredentialsType() {
		return credentialsType;
	}
	public void setCredentialsType(CredentialsType credentialsType) {
		this.credentialsType = credentialsType;
	}
		
}