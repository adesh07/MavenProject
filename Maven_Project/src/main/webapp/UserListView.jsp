<%@page import="java.util.Iterator"%>
<%@page import="in.co.rays.bean.UserBean"%>
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
	<!-- Maven  -->

	<%@ include file="Header.jsp"%>
	<form>
		<%
			List list = (List) request.getAttribute("list");
			Iterator itr = list.iterator();
		%>

		<table border=1>
			<tr>
				<th>Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Login Id</th>
				<th>Password</th>
				<th>D-O-B</th>
				<th>Edit</th>
			</tr>

			<%
				while (itr.hasNext()) {
					UserBean bean = (UserBean) itr.next();
			%>
			<tr>
				<td><%=bean.getId()%></td>
				<td><%=bean.getFirstName()%></td>
				<td><%=bean.getLastName()%></td>
				<td><%=bean.getLoginId()%></td>
				<td><%=bean.getPassword()%></td>
				<td><%=bean.getDob()%></td>
				<td><a href="UserCtrl.do?id=<%=bean.getId()%>">edit</a></td>
			</tr>
			<%
				}
			%>
		</table>
	</form>
</body>
</html>