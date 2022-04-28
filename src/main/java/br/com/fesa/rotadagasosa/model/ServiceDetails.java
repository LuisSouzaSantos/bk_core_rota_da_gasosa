package br.com.fesa.rotadagasosa.model;

import java.time.DayOfWeek;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.fesa.rotadagasosa.utils.Utils;

@Entity
@Table(name = "service_details")
public class ServiceDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "available")
	private Boolean available;

	@Column(name = "start_time")
	private ZonedDateTime startTime;
	
	@Column(name = "end_time")
	private ZonedDateTime endTime;
	
	@Column(name = "operating_days")
	private String operatingDays;
	
	@ManyToOne
	@JoinColumn(name = "service_id")
	private Service service;
	
	@ManyToOne
	@JoinColumn(name = "gas_station_id")
	private GasStation gasStation;
	
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
	
	public String getOperatingDays() {
		return operatingDays;
	}

	public void setOperatingDays(String operatingDays) {
		this.operatingDays = operatingDays;
	}

	public List<DayOfWeek> getFormatedOperatingDays() {	
		if(this.operatingDays == null || this.operatingDays.trim().isEmpty()) { return new ArrayList<DayOfWeek>(); }
		
		List<String> dayOfWeekStringFormat = Utils.stringToStringList(this.operatingDays);
		
		List<DayOfWeek> daysOfWeekList = dayOfWeekStringFormat.stream()
				.map(dayOfWeek -> DayOfWeek.valueOf(dayOfWeek))
				.collect(Collectors.toList());
		
		return daysOfWeekList;
	}
	
	public Service getService() {
		return service;
	}
	
	public void setService(Service service) {
		this.service = service;
	}

	public GasStation getGasStation() {
		return gasStation;
	}

	public void setGasStation(GasStation gasStation) {
		this.gasStation = gasStation;
	}
	
}