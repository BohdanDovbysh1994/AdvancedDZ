package com.internetshop.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class householdAppliances extends AbstractEntity{

	@Column(unique=true)
	private String type;
	@Column(unique=true)
	private String brend;
	private int price;
	private int number;
	
	@ManyToMany
	 @JoinTable(name = "Orders_householdAppliances", joinColumns = 
	 @JoinColumn(name = "householdAppliancesID"), inverseJoinColumns
	 = @JoinColumn(name = "OrdersID"))
	 public List<Orders> orders;
	
	@ManyToOne
	private maker maker;
	
	
	public householdAppliances() {
		// TODO Auto-generated constructor stub
	}
	public householdAppliances(String type, String brend, int price, int number) {
		super();
		this.type = type;
		this.brend = brend;
		this.price = price;
		this.number = number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBrend() {
		return brend;
	}
	public void setBrend(String brend) {
		this.brend = brend;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public maker getMaker() {
		return maker;
	}
	public void setMaker(maker maker) {
		this.maker = maker;
	}
	
	

}
