package com.internetshop.dao;


import com.internetshop.entity.Orders;
import com.internetshop.entity.User;

public interface OrdersDao extends GenericDao<Orders, String>  {

	void addUserToOrders( Orders orders, User user);

}
