package br.com.fesa.rotadagasosa.model;

import java.time.ZonedDateTime;

public class UsedGasStation {

	private Long id;
	private Double fuelAmount;
	private Double literPrice;
	private ZonedDateTime date;
	private GasStation gasStation;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getFuelAmount() {
		return fuelAmount;
	}
	public void setFuelAmount(Double fuelAmount) {
		this.fuelAmount = fuelAmount;
	}
	public Double getLiterPrice() {
		return literPrice;
	}
	public void setLiterPrice(Double literPrice) {
		this.literPrice = literPrice;
	}
	public ZonedDateTime getDate() {
		return date;
	}
	public void setDate(ZonedDateTime date) {
		this.date = date;
	}
	public GasStation getGasStation() {
		return gasStation;
	}
	public void setGasStation(GasStation gasStation) {
		this.gasStation = gasStation;
	}
		
}