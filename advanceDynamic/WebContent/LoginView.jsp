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
	<%@ include file="Header.jsp"%>
	<center>
		<form action="LoginCtl" method="post">

			<%
				String str = (String) request.getAttribute("msg");
			%>
			<table>
				<h1>Login</h1>
				<%
					if (str != null) {
				%>

				<%=str%>
				<%
					}
				%>
				<tr>
					<th>Login ID</th>
					<th><input type="text" name="loginId"></th>
				</tr>
				<tr>
					<th>Password</th>
					<th><input type="text" name="password"></th>
				</tr>
				<tr>
					<td></td>
					<th><input type="submit" name="operation" value="signIn">
						<input type="submit" name="operation" value="signUp"></th>
				</tr>

			</table>
		</form>
	</center>
</body>
</html>