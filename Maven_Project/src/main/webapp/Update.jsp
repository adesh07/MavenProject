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
		UserBean bean = (UserBean) request.getAttribute("bean");
	%>

	<%@ include file="Header.jsp"%>

	<form action="UserCtrl.do" method="post">
		<td><input type="hidden" name="id" value="<%=bean.getId()%>"></td>
		<table>
			<tr>
				<th>First Name :</th>
				<td><input type="text" name="firstName"
					value="<%=bean.getFirstName()%>"></td>
			</tr>
			<tr>
				<th>Last Name :</th>
				<td><input type="text" name="lastName"
					value="<%=bean.getLastName()%>"></td>
			</tr>
			<tr>
				<th>LoginId :</th>
				<td><input type="text" name="loginId"
					value="<%=bean.getLoginId()%>"></td>
			</tr>
			<tr>
				<th>Password :</th>
				<td><input type="text" name="password"
					value="<%=bean.getPassword()%>"></td>
			</tr>
			<tr>
				<th>D-O-B :</th>
				<td><input type="Date" name="dob" value="<%=bean.getDob()%>"></td>
			</tr>
			<tr>
				<td><input type="submit" name="operation" value="update"></td>
			</tr>
		</table>
	</form>

</body>
</html>