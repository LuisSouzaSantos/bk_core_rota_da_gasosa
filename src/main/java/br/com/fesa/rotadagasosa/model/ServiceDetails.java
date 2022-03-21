package br.com.fesa.rotadagasosa.model;

import java.time.DayOfWeek;
import java.time.ZonedDateTime;
import java.util.List;

public class ServiceDetails {

	private Long id;
	private Boolean available;
	private ZonedDateTime startTime;
	private ZonedDateTime endTime;
	private List<DayOfWeek> operatingDays;
	private Service service;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	public ZonedDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(ZonedDateTime startTime) {
		this.startTime = startTime;
	}
	public ZonedDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(ZonedDateTime endTime) {
		this.endTime = endTime;
	}
	public List<DayOfWeek> getOperatingDays() {
		return operatingDays;
	}
	public void setOperatingDays(List<DayOfWeek> operatingDays) {
		this.operatingDays = operatingDays;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
		
}