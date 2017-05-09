package com.internetshop.entity;

import java.time.LocalDateTime;
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
public class Orders extends AbstractEntity {
	private LocalDateTime date;
	@ManyToOne
	private User user;
	
	@ManyToMany
	 @JoinTable(name = "Orders_ComputerComodity", joinColumns = 
	 @JoinColumn(name = "OrdersID"), inverseJoinColumns
	 = @JoinColumn(name = "ComputerComodityID"))
	 public List<ComputerComodity> computerComodities;
	
	@ManyToMany
	 @JoinTable(name = "Orders_householdAppliances", joinColumns = 
	 @JoinColumn(name = "OrdersID"), inverseJoinColumns
	 = @JoinColumn(name = "householdAppliancesID"))
	 public List<householdAppliances> householdAppliances ;
	
	 public Orders() {
		// TODO Auto-generated constructor stub
	}
	public Orders(LocalDateTime date) {
		super();
		this.date = date;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	 

}
