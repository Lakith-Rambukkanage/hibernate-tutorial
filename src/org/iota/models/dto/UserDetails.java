package org.iota.models.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity(name = "USER_DETAILS")
public class UserDetails {
	@Id	@GeneratedValue
	private int userID;

	private String userName;

	@Temporal(TemporalType.DATE)
	private Date joinedDate;

	@OneToMany
	@JoinTable(name = "USER_VEHICLE",joinColumns = @JoinColumn(name = "USER_ID"),inverseJoinColumns = @JoinColumn(name = "VEHICLE_ID"))
	private Collection<Vehicle> vehicles = new ArrayList<Vehicle>();



	private String description;


	@ElementCollection
	@JoinTable( name = "USER_ADDRESSES", joinColumns =@JoinColumn(name = "userID"))
	@GenericGenerator(name = "sequence_gen",strategy = "sequence")
	@CollectionId(columns ={@Column(name = "ADDRESS_ID")},generator ="sequence_gen",type =@Type(type = "long" ))
	private Collection<Address> addresses = new ArrayList<Address>();


	public Collection<Vehicle> getVehicles() {return vehicles;}

	public void setVehicles(Collection<Vehicle> vehicles) { this.vehicles = vehicles;}

	public Collection<Address> getAddresses() {return addresses;}

	public void setAddresses(Collection<Address> addresses) {this.addresses= addresses;	}


	public String getDescription() {return description;	}

	public void setDescription(String description) {this.description = description; }

	public Date getJoinedDate() {return joinedDate;	}

	public void setJoinedDate(Date joinedDate) {this.joinedDate = joinedDate;}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
}
