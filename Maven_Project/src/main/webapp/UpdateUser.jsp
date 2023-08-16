<%@ page errorPage="ErrorView.jsp" %>
<%@page import="in.co.rays.bean.Userbean"%>
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
		//from userRrgistrationCtl get
		Userbean bean = (Userbean) request.getAttribute("updatedata");
	%>
	<center>
		<h1>Update User</h1>
		<form action="UserRegistrationCtl" method="post">
			<table>
				<input type="hidden" name="id" value="<%=bean.getId()%>">
				<tr>
					<td>First Name</td>
					<th><input type="text" name="firstName" value="<%=bean.getFirstName()%>"></th>
				</tr>
				<tr>
					<td>Last Name</td>
					<th><input type="text" name="lastName" value="<%=bean.getLastName()%>"></th>
				</tr>
				<tr>
					<td>LoginId</td>
					<th><input type="text" name="loginId" value="<%=bean.getLoginId()%>"></th>
				</tr>
				<tr>
					<td>Password</td>
					<th><input type="text" name="password" value="<%=bean.getPassword()%>"></th>
				</tr>
				<tr>
					<td>DOB</td>
					<th><input type="date" name="dob" value="<%=bean.getDob()%>"></th>
				</tr>
				<tr>
					<td>Address</td>
					<th><input type="text" name="address" value="<%=bean.getAddress()%>"></th>
				</tr>
				<tr>
					<td></td>
					<th><input type="submit" name="operation" value="update"></th>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>