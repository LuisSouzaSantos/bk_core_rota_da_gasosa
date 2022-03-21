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

import br.com.fesa.rotadagasosa.model.Flag;

@CrossOrigin
@RestController
@RequestMapping("/flag")
public class FlagController {
	
	@PostMapping
	public ResponseEntity<Flag> saveFlag(@RequestBody Flag flag){
		return ResponseEntity.ok(flagMock());
	}
	
	@PutMapping
	public ResponseEntity<Flag> updateFlag(@RequestBody Flag flag){
		return ResponseEntity.ok(flagMock());
	}
	
	@GetMapping
	public ResponseEntity<List<Flag>> getAllFlags(){
		return ResponseEntity.ok(new ArrayList<Flag>(Arrays.asList(flagMock())));
	}
	
	private Flag flagMock() {
		Flag flag = new Flag();
		flag.setId(1L);
		flag.setName("PETROBRAS");
		flag.setVisible(true);
		
		return flag;
	}

}
