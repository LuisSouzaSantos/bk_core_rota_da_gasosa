package br.com.fesa.rotadagasosa.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "gas_station")
public class GasStation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "password")
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "flag_id")
	private Flag flag;
	
	@Column(name = "cnpj")
	private String cnpj;
	
	@Column(name = "cep")
	private String cep;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "address_number")
	private String addressNumber;
	
	@Column(name = "latitude")
	private Double latitude;
	
	@Column(name = "longitude")
	private Double longitude;
	
	@Column(name = "active")
	private Boolean active;
	
	@Column(name = "verified")
	private Boolean verified;
	
	@OneToMany(mappedBy = "gasStation", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<FuelDetails> fuelDetailsList;
	
	@OneToMany(mappedBy = "gasStation", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ServiceDetails> serviceDetailsList;
	
	@OneToMany(mappedBy = "gasStation", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<AvailableTimeDetails> availablesDetailsList;
	
	@OneToMany(mappedBy = "gasStation", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PromotionDetails> promotionsDetailsList;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Flag getFlag() {
		return flag;
	}
	
	public void setFlag(Flag flag) {
		this.flag = flag;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddressNumber() {
		return addressNumber;
	}
	
	public void setAddressNumber(String addressNumber) {
		this.addressNumber = addressNumber;
	}
	
	public Double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	public Double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	public Boolean getActive() {
		return active;
	}
	
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	public Boolean getVerified() {
		return verified;
	}
	
	public void setVerified(Boolean verified) {
		this.verified = verified;
	}
	
	public List<FuelDetails> getFuelDetailsList() {
		return fuelDetailsList;
	}
	
	public void setFuelDetailsList(List<FuelDetails> fuelDetailsList) {
		this.fuelDetailsList = fuelDetailsList;
	}
	
	public List<ServiceDetails> getServiceDetailsList() {
		return serviceDetailsList;
	}
	
	public void setServiceDetailsList(List<ServiceDetails> serviceDetailsList) {
		this.serviceDetailsList = serviceDetailsList;
	}
	
	public List<AvailableTimeDetails> getAvailablesDetailsList() {
		return availablesDetailsList;
	}
	
	public void setAvailablesDetailsList(List<AvailableTimeDetails> availablesDetailsList) {
		this.availablesDetailsList = availablesDetailsList;
	}
	
	public List<PromotionDetails> getPromotionsDetailsList() {
		return promotionsDetailsList;
	}
	
	public void setPromotionsDetailsList(List<PromotionDetails> promotionsDetailsList) {
		this.promotionsDetailsList = promotionsDetailsList;
	}
		
}