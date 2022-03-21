package br.com.fesa.rotadagasosa.model;

import java.time.DayOfWeek;
import java.time.ZonedDateTime;
import java.util.List;

public class AvailableTimeDetails {

	private Long id;
	private List<DayOfWeek> operatingsDay;
	private ZonedDateTime startTime;
	private ZonedDateTime endTime;
	private AvailableTime availableTime;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<DayOfWeek> getOperatingsDay() {
		return operatingsDay;
	}
	public void setOperatingsDay(List<DayOfWeek> operatingsDay) {
		this.operatingsDay = operatingsDay;
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
	public AvailableTime getAvailableTime() {
		return availableTime;
	}
	public void setAvailableTime(AvailableTime availableTime) {
		this.availableTime = availableTime;
	}
		
}