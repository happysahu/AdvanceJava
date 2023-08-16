<%@ page errorPage="ErrorView.jsp" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<%@ include file="Header.jsp"%>
<body>
	<center>
		<form action="UserListCtl" method="post">
			<tr>
				<td><input type="text" name="firstName" placeholder="FirstName"><input
					type="text" name="lastName" placeholder="Lastname"><input
					type="date" name="dob"></td>
				<td></td>

				<th><input type="submit" name="operation" value="search">
					<input type="submit" name="operation" value="delete"></th>

				<br>

				<table border="2">

					<tr>
						<th>Select</th>
						<th>Serial No.</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Login Id</th>
						<th>Password</th>
						<th>DOB</th>
						<th>Address</th>
						<th>Edit</th>
					</tr>
					<%
						Integer pageNo = (Integer) request.getAttribute("pageNumber");
						List list = (List) request.getAttribute("list");
						int newList = (int) request.getAttribute("newList");
						Iterator it = list.iterator();
						int index = ((pageNo - 1) * 5) + 1;
						while (it.hasNext()) {
							Userbean bean = (Userbean) it.next();
					%>
					<tr>
						<th><input type="checkbox" name="id"
							value="<%=bean.getId()%>"></th>
						<th><%=index++%></th>
						<th><%=bean.getFirstName()%></th>
						<th><%=bean.getLastName()%></th>
						<th><%=bean.getLoginId()%></th>
						<th><%=bean.getPassword()%></th>
						<th><%=bean.getDob()%></th>
						<th><%=bean.getAddress()%></th>
						<th><a href="UserRegistrationCtl?id=<%=bean.getId()%>">Edit</a></th>
					</tr>
					<%
						}
					%>

				</table>

				<input type="hidden" name="pageNo" value="<%=pageNo%>">
				<%
					if (pageNo > 1) {
				%>
				<input type="submit" name="operation" value="previous">
				<%
					}
					if (newList != 0) {
				%>
				<input type="submit" name="operation" value="next">
				<%
					}
				%>
			
		</form>
	</center>
</body>
</html>