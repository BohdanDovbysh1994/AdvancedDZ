package com.internetshop.daoImpl;
import java.util.List;

import com.internetshop.dao.UserDao;
import com.internetshop.entity.Orders;
import com.internetshop.entity.User;

public class UserDaoImpl extends GenericDaoIplementation<User, String> implements UserDao {

	public UserDaoImpl() {
		
	}

	public void addOrdersToUser(User user, Orders orders) {
	
		getEntityManager().getTransaction().begin();
		
		orders.setUser(user);
		
		getEntityManager().getTransaction().commit();
		

	}
	@Override
	 public void delete(String fieldName, String fieldValue) 
	 {
	  User user = super.getOne(fieldName, fieldValue);
	  List<Orders> orders = user.getOrders();
	  for (Orders order : orders) 
	  {
	   order.setUser(null);
	   getEntityManager().merge(order);
	  }
	  super.delete(fieldName, fieldValue);
	 }

}
