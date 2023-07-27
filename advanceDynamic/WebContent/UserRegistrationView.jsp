<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="Header.jsp" %>
	<center>
		<form action="UserRegistrationCtl" method="post">
			<h1>User Registration</h1>
			<table>
				<tr>
					<th>First Name</th>
					<th><input type="text" name="firstName"></th>
				</tr>
				<tr>
					<th>Last Name</th>
					<th><input type="text" name="lastName"></th>
				</tr>
				<tr>
					<th>Login ID</th>
					<th><input type="text" name="loginId"></th>
				</tr>
				<tr>
					<th>DOB</th>
					<th><input type="date" name="dob"></th>
				</tr>
				<tr>
					<th>Address</th>
					<th><input type="text" name="address"></th>
				</tr>
				<tr>
					<th>Password</th>
					<th><input type="text" name="password"></th>
				</tr>
				<tr>
					<td></td>
					<th><input type="submit" name="operation" value="register"></th>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>