package br.com.fesa.rotadagasosa.model;

import java.time.ZonedDateTime;
import java.util.List;

public class GasStation {

	private Long id;
	private String name;
	private String password;
	private Flag flag;
	private String cnpj;
	private String cep;
	private String address;
	private String addressNumber;
	private Double latitude;
	private Double longitude;
	private ZonedDateTime availableTimeStart;
	private ZonedDateTime availableTimeEnd;
	private Boolean active;
	private Boolean verified;
	
	private List<FuelDetails> fuelDetailsList;
	private List<ServiceDetails> serviceDetailsList;
	private List<AvailableTimeDetails> availablesDetailsList;
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
	public ZonedDateTime getAvailableTimeStart() {
		return availableTimeStart;
	}
	public void setAvailableTimeStart(ZonedDateTime availableTimeStart) {
		this.availableTimeStart = availableTimeStart;
	}
	public ZonedDateTime getAvailableTimeEnd() {
		return availableTimeEnd;
	}
	public void setAvailableTimeEnd(ZonedDateTime availableTimeEnd) {
		this.availableTimeEnd = availableTimeEnd;
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