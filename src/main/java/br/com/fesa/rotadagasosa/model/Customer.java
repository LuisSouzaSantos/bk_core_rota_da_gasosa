package br.com.fesa.rotadagasosa.model;

import java.util.List;

public class Customer {

	private Long id;
	private String name;
	private String password;
	private String cpf;
	private String cep;
	private String address;
	private String addressNumber;
	private String addressComplement;
	private List<VehicleDetails> vehicleList;
	private List<UsedGasStation> usedGasStationList;
	private Boolean active;
	
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
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
	public String getAddressComplement() {
		return addressComplement;
	}
	public void setAddressComplement(String addressComplement) {
		this.addressComplement = addressComplement;
	}
	public List<VehicleDetails> getVehicleList() {
		return vehicleList;
	}
	public void setVehicleList(List<VehicleDetails> vehicleList) {
		this.vehicleList = vehicleList;
	}
	public List<UsedGasStation> getUsedGasStationList() {
		return usedGasStationList;
	}
	public void setUsedGasStationList(List<UsedGasStation> usedGasStationList) {
		this.usedGasStationList = usedGasStationList;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	
}