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
	<%@ include file="Header.jsp"%>
	<center>
		<h2>
			<u>Login Page</u>
		</h2>
		<%
			String msg = (String) request.getAttribute("msg");
			String uri = (String) request.getAttribute("uri");
			String register = (String) request.getAttribute("signup");
		%>
		<%
			if (register != null) {
		%>
		<h2>
			<font color="green"><%=register%></font>
		</h2>
		<%
			}
		%>
		<%
			if (msg != null) {
		%>
		<h3>
			<font color="red"> <%=msg%>
			</font>
		</h3>
		<%
			}
		%>
		<form action="LoginCtrl" method="post">
			<table
				style="border: 2px solid blue; padding: 30px; margin-top: 150px">
				<tr>
					<th>Login Id :</th>
					<td><input type="text" name="loginId"
						placeholder="Enter Login Id"></td>
				</tr>
				<tr>
					<th>Password :</th>
					<td><input type="password" name="password"
						placeholder="Enter password"></td>
				<tr>
					<th></th>
					<td><input type="submit" name="operation" value="Login"></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="operation" value="Sign-up"></td>
				</tr>
			</table>
			<input type="hidden" name="uri" value=<%=uri%>>
		</form>
	</center>
	<%@ include file="Footer.jsp"%>
</body>
</html>