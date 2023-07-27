<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<form action="WelcomeCtl" method="post">
		<%
			String str = (String) request.getAttribute("update");
		%>
		<h1>Welcome</h1>
		<%
			if (str != null) {
		%>

		<%=str%>
		<%
			}
		%>
	</form>
</body>
</html>