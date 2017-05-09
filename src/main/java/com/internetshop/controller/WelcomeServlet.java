package com.internetshop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.internetshop.dao.UserDao;
import com.internetshop.daoImpl.UserDaoImpl;
import com.internetshop.entity.User;

public class WelcomeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("username");
		String email = req.getParameter("mail");
		  String password = req.getParameter("pass");
		  UserDao userDao = new UserDaoImpl();
		  if(name!=null && email!=null && password!=null){
		  userDao.add(new User(name, email, password));
		  }
		  List<User> users = userDao.getAll();
		  req.setAttribute("users", users);
		  req.getRequestDispatcher("User.jsp").forward(req, resp);
		 
	}
	

}
