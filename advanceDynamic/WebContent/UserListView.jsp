<%@ page errorPage="ErrorView.jsp"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="Header.jsp"%>
	<%
		String str = (String) session.getAttribute("update");
	%>
	<center>
		<h1>User List</h1>
		<form action="UserListCtl.do" method="post">
			<tr>
				<td><input type="text" name="firstName">
				<td></td>
				<input type="date" name="dob">
				</td>
				<th><input type="submit" name="operation" value="Search">
					<input type="submit" name="operation" value="delete"></th>
			</tr>
			<%
				Integer pageNo = (Integer) request.getAttribute("pageNo");
				List list = (List) request.getAttribute("list");
				Iterator it = list.iterator();
				int index = ((pageNo - 1) * 5) + 1;
			%>
			<table border="1">

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
					while (it.hasNext()) {
						UserBean bean = (UserBean) it.next();
				%>
				<tr>
					<th><input type="checkbox" name="id" value="<%=bean.getId()%>"></th>
					<th><%=index++%></th>
					<th><%=bean.getFirstName()%></th>
					<th><%=bean.getLastName()%></th>
					<th><%=bean.getLoginId()%></th>
					<th><%=bean.getPassword()%></th>
					<th><%=bean.getDob()%></th>
					<th><%=bean.getAddress()%></th>
					<th><a href="UserRegistrationCtl?id=<%=bean.getId()%>">edit</a></th>
				</tr>
				<%
					}
				%>
			</table>
			<input type="hidden" name="pageNo" value="<%=pageNo%>">
			<th><input type="submit" name="operation" value="previous"></th>
			<th><input type="submit" name="operation" value="next"></th>
		</form>
		<%
			if (str != null) {
		%>
		<h1><%=str%></h1>
		<%
			}
		%>
	</center>
</body>
</html>