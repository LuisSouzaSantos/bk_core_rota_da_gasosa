package br.com.fesa.rotadagasosa.model;

import br.com.fesa.rotadagasosa.model.types.PathAuthenticationType;

public class PathAuthentication {

	private String path;
	private PathAuthenticationType pathAuthenticationType;
	
	public PathAuthentication(String path, PathAuthenticationType pathAuthenticationType) {
		this.path = path;
		this.pathAuthenticationType = pathAuthenticationType;
	}

	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public PathAuthenticationType getPathAuthenticationType() {
		return pathAuthenticationType;
	}
	
	public void setPathAuthenticationType(PathAuthenticationType pathAuthenticationType) {
		this.pathAuthenticationType = pathAuthenticationType;
	}
	
}