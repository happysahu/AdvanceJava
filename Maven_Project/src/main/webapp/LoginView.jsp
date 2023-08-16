<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<%@ include file="Header.jsp"%>

	<center>
		<h1>Login</h1>
		<form action="LoginCtl" method="post">
			<%
				String msg = (String) request.getAttribute("msg");
			%>
			<table>
				<%
					if (msg != null) {
				%>
				<%=msg%>
				<%
					}
				%>
				<tr>
					<td>LoginId</td>
					<td><input type="text" name="loginId"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="text" name="password"></td>
				</tr>
				<tr>
					<td></td>
					<th><input type="submit" name="operation" value="signIn"><input
						type="submit" name="operation" value="signUp"></th>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>