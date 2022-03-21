package br.com.fesa.rotadagasosa.model;

public class CustomerDirection {

	private String originLatitude;
	private String originLongitude;
	private Long gasStationId;
	
	public String getOriginLatitude() {
		return originLatitude;
	}
	
	public void setOriginLatitude(String originLatitude) {
		this.originLatitude = originLatitude;
	}
	
	public String getOriginLongitude() {
		return originLongitude;
	}
	
	public void setOriginLongitude(String originLongitude) {
		this.originLongitude = originLongitude;
	}
	
	public Long getGasStationId() {
		return gasStationId;
	}
	
	public void setGasStationId(Long gasStationId) {
		this.gasStationId = gasStationId;
	}
	
}