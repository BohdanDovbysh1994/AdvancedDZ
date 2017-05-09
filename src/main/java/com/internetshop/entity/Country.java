package com.internetshop.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Countries") 
public class Country extends AbstractEntity{
	@Column(unique=true)
	private String name;
	
	@OneToMany (mappedBy = "country")
	List<maker> makers;
	
	public Country() {
		
	}
	public Country(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<maker> getMakers() {
		return makers;
	}
	public void setMakers(List<maker> makers) {
		this.makers = makers;
	}
	

}
