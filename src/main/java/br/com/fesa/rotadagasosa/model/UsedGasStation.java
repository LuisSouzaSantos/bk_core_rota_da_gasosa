package br.com.fesa.rotadagasosa.model;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "used_gas_station")
public class UsedGasStation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "fuel_amount")
	private BigDecimal fuelAmount;

	@Column(name = "liter_price")
	private BigDecimal literPrice;
	
	@Column(name = "date")
	private ZonedDateTime date;
	
	@ManyToOne
	@JoinColumn(name = "gas_station_id")
	private GasStation gasStation;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public BigDecimal getFuelAmount() {
		return fuelAmount;
	}

	public void setFuelAmount(BigDecimal fuelAmount) {
		this.fuelAmount = fuelAmount;
	}

	public BigDecimal getLiterPrice() {
		return literPrice;
	}

	public void setLiterPrice(BigDecimal literPrice) {
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}