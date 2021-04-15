package com.ashraf.covid.covidDj.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="cas")
public class Case {
	
	//define fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int Id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE,
			CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="district_id")
	@JsonManagedReference
	private District district;
	
	@Column(name="healed")
	private boolean healed;

	private int idDistrict;

	// defining constructors
	
	public int getIdDistrict() {
		return idDistrict;
	}


	public void setIdDistrict(int idDistrict) {
		this.idDistrict = idDistrict;
	}


	public Case() {
		
	}


	public Case(String firstName, String lastName, District district, boolean healed) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.district = district;
		this.healed = healed;
	}


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public District getDistrict() {
		return district;
	}


	public void setDistrict(District district) {
		this.district = district;
	}


	public boolean isHealed() {
		return healed;
	}


	public void setHealed(boolean healed) {
		this.healed = healed;
	}





	
	
	
}

