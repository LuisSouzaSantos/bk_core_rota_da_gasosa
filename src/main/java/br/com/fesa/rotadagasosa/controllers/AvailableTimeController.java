package br.com.fesa.rotadagasosa.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fesa.rotadagasosa.model.AvailableTime;

@CrossOrigin
@RestController
@RequestMapping("/availableTime")
public class AvailableTimeController {

	@PostMapping
	public ResponseEntity<AvailableTime> saveAvailableTime(@RequestBody AvailableTime availableTime){
		return ResponseEntity.ok(flagAvailableTime());
	}
	
	@PutMapping
	public ResponseEntity<AvailableTime> updateAvailableTime(@RequestBody AvailableTime availableTime){
		return ResponseEntity.ok(flagAvailableTime());
	}
	
	@GetMapping
	public ResponseEntity<List<AvailableTime>> getAllAvailablesTime(){
		return ResponseEntity.ok(new ArrayList<AvailableTime>(Arrays.asList(flagAvailableTime())));
	}
	
	private AvailableTime flagAvailableTime() {
		AvailableTime availableTime = new AvailableTime();
		availableTime.setId(1L);
		availableTime.setName("AVAILABLE");
		availableTime.setVisible(true);
		
		return availableTime;
	}
	
}
