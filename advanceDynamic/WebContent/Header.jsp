
<%@page import="in.co.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		UserBean bean1 = (UserBean) session.getAttribute("user");
		if (bean1 != null) {
	%>
	<h4>
		<a href="UserRegistrationCtl">Add User</a>
	</h4>
	<h3>
		Hi, <a href="WelcomeCtl.do"><%=bean1.getFirstName()%>
	</h3>
	</a>
	<h3>
		<a href="UserListCtl.do">UserList</a>|<a
			href="LoginCtl?operation=logout">LogOut</a>
	</h3>
	<%
		} else {
	%>
	<h3>Hi, Guest</h3>
	<%
		}
	%>
	<hr>
</body>
</html>