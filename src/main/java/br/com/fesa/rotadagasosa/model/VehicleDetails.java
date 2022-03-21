package br.com.fesa.rotadagasosa.model;

public class VehicleDetails {

	private Long id;
	private String model;
	private String brand;
	private Fuel fuel;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public Fuel getFuel() {
		return fuel;
	}
	
	public void setFuel(Fuel fuel) {
		this.fuel = fuel;
	}
	
}