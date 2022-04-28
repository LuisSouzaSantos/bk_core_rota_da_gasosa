package br.com.fesa.rotadagasosa.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fuel_details")
public class FuelDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@Column(name = "available")
	private Boolean available;
	
	@ManyToOne
	@JoinColumn(name = "fuel_id")
	private Fuel fuel;
	
	@ManyToOne
	@JoinColumn(name = "gas_station_id")
	private GasStation gasStation;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Boolean getAvailable() {
		return available;
	}
	
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	
	public Fuel getFuel() {
		return fuel;
	}
	
	public void setFuel(Fuel fuel) {
		this.fuel = fuel;
	}
	
	public GasStation getGasStation() {
		return gasStation;
	}
	
	public void setGasStation(GasStation gasStation) {
		this.gasStation = gasStation;
	}	

}