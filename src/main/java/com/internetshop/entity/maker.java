package com.internetshop.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class maker extends AbstractEntity {
	@Column(unique=true)
	private String name;
//	@Column(unique=true)
//	private Country country;
	
	@ManyToOne
	private Country country;
	
	@OneToMany (mappedBy = "maker")
	List<ComputerComodity> computerComodities;
	@OneToMany (mappedBy = "maker")
	List<householdAppliances> householdAppliances;
	
	
	
	public maker() {
		// TODO Auto-generated constructor stub
	}
	public maker(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public List<ComputerComodity> getComputerComodities() {
		return computerComodities;
	}
	public void setComputerComodities(List<ComputerComodity> computerComodities) {
		this.computerComodities = computerComodities;
	}
	public List<householdAppliances> getHouseholdAppliances() {
		return householdAppliances;
	}
	public void setHouseholdAppliances(List<householdAppliances> householdAppliances) {
		this.householdAppliances = householdAppliances;
	}

	

}
