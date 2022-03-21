package br.com.fesa.rotadagasosa.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fesa.rotadagasosa.model.Direction;

@CrossOrigin
@RestController
@RequestMapping("/direction")
public class DirectionController {

	@PostMapping
	public ResponseEntity<Direction> buildDirection(){
		return ResponseEntity.ok(directionMock());
	}
	
	private Direction directionMock() {
		Direction direction = new Direction();
		direction.setDestinationLatitude(123.32);
		direction.setDestinationLongitude(11.23);
		direction.setOriginLatitude(1234.43);
		direction.setOriginLongitude(987.12);
		
		return direction;
	}
	
}
