package org.iota.models.dto;


import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("BIKE")
public class Bike extends Vehicle {

	private String bikeBrand;

	public String getBikeBrand() {
		return bikeBrand;
	}

	public void setBikeBrand(String bikeBrand) {
		this.bikeBrand = bikeBrand;
	}

}
