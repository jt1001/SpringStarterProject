package com.example.cake.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cake.domain.Cake;
import com.example.cake.service.CakeService;

@RestController
public class CakeController {
	
	private CakeService service;
	
	@Autowired //Tells Spring to fetch the CakeService from the context - dependency injection????
	public CakeController(CakeService service) {
		super();
		this.service=service;
		
	}

	@PostMapping("/create") // to create! //pulls the parameter from the body of the request //in postman
							// you can use = localhost:8080/create
	public ResponseEntity<Cake> createCake(@RequestBody Cake c) {
		Cake created = this.service.createCake(c);
		ResponseEntity<Cake> response = new ResponseEntity<Cake>(created, HttpStatus.CREATED); // 201 = CREATED code
		return response;
	}

	@GetMapping("/getAll") // This will return list of all CAKES!!!!!!!!!!!!!!!! // you can use =
							// localhost:8080/getAll
	public ResponseEntity<List<Cake>> getAllCakes() {
		return ResponseEntity.ok(this.service.getAllCakes()); // 200 - Status code for OK.
	}

	@GetMapping("/get/{id}") // 200 - STATUS code returned for OK // TO READ FIELDS USING ID!!!!
	public Cake getCake(@PathVariable Integer id) {
		return this.service.getCake(id);
		
	}

	@PutMapping("/replace/{id}") // 202 - STATUS CODE FOR ACCEPTED // FOR UPDATING the CAKE using ID!!!!
	public ResponseEntity<Cake> replaceCake(@PathVariable Integer id, @RequestBody Cake newCake) {
		Cake body = this.service.replaceCake(id, newCake);
		ResponseEntity<Cake> response = new ResponseEntity<Cake>(body, HttpStatus.ACCEPTED);
		return response;
	}

	@DeleteMapping("/remove/{id}") // 204 - STATUS CODE FOR NO CONTENT
	public ResponseEntity<?> removeCake(@PathVariable Integer id) {
		this.service.removeCake(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}


}
