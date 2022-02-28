package com.example.cake.domain;

public class Cake {

	private Integer id;
	private String Flavour;
	private Double price;

	public Cake() {
		super();
	}

	public Cake(Integer id, String flavour, Double price) {
		super();
		this.id = id;
		Flavour = flavour;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFlavour() {
		return Flavour;
	}

	public void setFlavour(String flavour) {
		Flavour = flavour;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Cake [id=" + id + ", Flavour=" + Flavour + ", price=" + price + "]";
	}

}
