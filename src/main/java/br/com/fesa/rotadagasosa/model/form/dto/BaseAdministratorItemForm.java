package br.com.fesa.rotadagasosa.model.form.dto;

public class BaseAdministratorItemForm {

	private String name;
	private boolean visible = true;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isVisible() {
		return visible;
	}
	
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
		
}