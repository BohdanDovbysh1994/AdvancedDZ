<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*,com.internetshop.entity.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AddUser</title>
</head>
<body>
<div style ="text-align: center; margin-top: 15%">
<form action="AddUser" method="get">
Email <input type="email" name ="mail">
<br>
 Name <input type="text" name="username">
<br>
Password <input type="password" name="pass">
<br>
<button>Add User</button>
<br>

</form>

</div>
 <hr><ol> <%
 @SuppressWarnings("unchecked") 
 List<User> users = (List<User>)request.getAttribute("users");
 for (User user : users) { %>
     <li> <%= user %> </li> <%
 } %>
</ol><hr>

</body>
</html>