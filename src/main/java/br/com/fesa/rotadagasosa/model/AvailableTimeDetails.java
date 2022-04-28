package br.com.fesa.rotadagasosa.model;

import java.time.DayOfWeek;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "available_time_details")
public class AvailableTimeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "day_of_week")
	private DayOfWeek dayOfWeek;
	
	@Column(name = "start_time")
	private ZonedDateTime startTime;
	
	@Column(name = "end_time")
	private ZonedDateTime endTime;
	
	@ManyToOne
	@JoinColumn(name = "available_time_id")
	private AvailableTime availableTime;
	
	@ManyToOne
	@JoinColumn(name = "gas_station_id")
	private GasStation gasStation;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
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

	public GasStation getGasStation() {
		return gasStation;
	}

	public void setGasStation(GasStation gasStation) {
		this.gasStation = gasStation;
	}
	
}