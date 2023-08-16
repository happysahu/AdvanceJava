<%@ page errorPage="ErrorView.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
</head>
<body>
	<center>
		<h1>REGISTRATION</h1>
		<form action="UserRegistrationCtl" method="post">
			<table>
				<tr>
					<td>First Name</td>
					<th><input type="text" name="firstName"></th>
				</tr>
				<tr>
					<td>Last Name</td>
					<th><input type="text" name="lastName"></th>
				</tr>
				<tr>
					<td>LoginId</td>
					<th><input type="text" name="loginId"></th>
				</tr>
				<tr>
					<td>Password</td>
					<th><input type="text" name="password"></th>
				</tr>
				<tr>
					<td>DOB</td>
					<th><input type="date" name="dob"></th>
				</tr>
				<tr>
					<td>Address</td>
					<th><input type="text" name="address"></th>
				</tr>
				<tr>
					<td></td>
					<th><input type="submit" name="operation" value="add"></th>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>