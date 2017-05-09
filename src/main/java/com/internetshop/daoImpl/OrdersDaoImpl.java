package com.internetshop.daoImpl;
import com.internetshop.dao.OrdersDao;
import com.internetshop.entity.Orders;
import com.internetshop.entity.User;


public class OrdersDaoImpl extends GenericDaoIplementation<Orders, String> implements OrdersDao {


public OrdersDaoImpl() {
	// TODO Auto-generated constructor stub
}

	public void addUserToOrders(Orders orders, User user) {
		getEntityManager().getTransaction().begin();

		orders.setUser(user);

		getEntityManager().getTransaction().commit();
	}
}
