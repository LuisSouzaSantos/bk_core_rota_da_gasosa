package br.com.fesa.rotadagasosa.controllers;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.fesa.rotadagasosa.model.PathAuthentication;
import br.com.fesa.rotadagasosa.model.types.PathAuthenticationType;

public class Controller {

	public static List<PathAuthentication>  apisGet() {
		return Stream.of(AuthController.APIS_GET, AvailableTimeController.APIS_GET).flatMap(Collection::stream).collect(Collectors.toList());
	}
	
	public static List<PathAuthentication> apisPost() {
		return Stream.of(AuthController.APIS_POST, AvailableTimeController.APIS_POST).flatMap(Collection::stream).collect(Collectors.toList());
	}
	
	public static List<PathAuthentication> apisPut() {
		return Stream.of(AuthController.APIS_PUT, AvailableTimeController.APIS_PUT).flatMap(Collection::stream).collect(Collectors.toList());
	}
	
	public static List<PathAuthentication> apisDelete() {
		return Stream.of(AuthController.APIS_DELETE, AvailableTimeController.APIS_DELETE).flatMap(Collection::stream).collect(Collectors.toList());
	}
	
	public static String[] geApisGetOpened() {
		return apisGet().stream()
				.filter(path -> path.getPathAuthenticationType().equals(PathAuthenticationType.NO_AUTHENTICATION_NEEDED))
				.map(path -> path.getPath())
				.toArray(String[]::new);
	}
	
	public static String[] getApisPostOpened(){
		return apisPost().stream()
				.filter(path -> path.getPathAuthenticationType().equals(PathAuthenticationType.NO_AUTHENTICATION_NEEDED))
				.map(path -> path.getPath())
				.toArray(String[]::new);
	}
	
	public static String[] getApisPutOpened(){
		return apisPut().stream()
				.filter(path -> path.getPathAuthenticationType().equals(PathAuthenticationType.NO_AUTHENTICATION_NEEDED))
				.map(path -> path.getPath())
				.toArray(String[]::new);
	}
	
	public static String[] getApisDeleteOpened(){
		return apisDelete().stream()
				.filter(path -> path.getPathAuthenticationType().equals(PathAuthenticationType.NO_AUTHENTICATION_NEEDED))
				.map(path -> path.getPath())
				.toArray(String[]::new);
	}
		
}