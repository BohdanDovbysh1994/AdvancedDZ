package com.internetshop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class ComputerComodity extends AbstractEntity {
	private int price;
	private String brend;
	private String model;
	private int number;
	
	@ManyToMany
	 @JoinTable(name = "Orders_ComputerComodity", joinColumns = 
	 @JoinColumn(name = "ComputerComodityID"), inverseJoinColumns
	 = @JoinColumn(name = "OrdersID"))
	 public List<Orders> orders ;
	
	@ManyToOne
	private maker maker;
	
	public ComputerComodity(int price, String brend, String model, int number) {
		super();
		this.price = price;
		this.brend = brend;
		this.model = model;
		this.number = number;
	}

	
	public ComputerComodity() {
		// TODO Auto-generated constructor stub
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


	public String getBrend() {
		return brend;
	}


	public void setBrend(String brend) {
		this.brend = brend;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public maker getMaker() {
		return maker;
	}


	public void setMaker(maker maker) {
		this.maker = maker;
	}
	
	

}
