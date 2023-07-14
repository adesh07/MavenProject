<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- Maven -->
	<%
		String fname = (String) session.getAttribute("fName");
	%>
	<%
		if (fname != null) {
	%>
	<h2>
		Hello,
		<%=fname%></h2>
	<a href="UserListCtrl.do">UserList</a> | |
	<a href="LoginCtrl?operation=Logout">Logout</a>
	<%
		} else {
	%>
	<h2>Hello, Guest</h2>
	<%
		}
	%>
	<hr>
</body>
</html>