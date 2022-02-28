package com.example.cake.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.cake.domain.Cake;

@Service
public class CakeService {

	private List<Cake> cakes = new ArrayList<>();

	// CREATE
	public Cake createCake(Cake c) {
		this.cakes.add(c);
		Cake created = this.cakes.get(this.cakes.size() - 1);
		return created;

	}

	// READ
	public List<Cake> getAllCakes() {
		return this.cakes;

	}

	public Cake getCake(Integer id) {
		return this.cakes.get(id);

	}

	// UPDATE
	public Cake replaceCake(Integer id, Cake newCake) {
		Cake body = this.cakes.set(id, newCake);
		return body;

	}

	// DELETE
	public void removeCake(@PathVariable Integer id) {
		this.cakes.remove(id.intValue()); // added intValue() so they know its an Integer and not a CAKE!!!!!!!
	}

}
