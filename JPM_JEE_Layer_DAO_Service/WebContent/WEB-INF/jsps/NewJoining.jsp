<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Joining</title>
</head>
<body>
	<jsp:include page="Header.jsp" />
	<jsp:include page="Header01.jsp" />
	<form method="POST" action="submitJoinee.do">
		${message}
		<table>
			<tr>
				<th>First Name</th>
				<td><input type="text" name="firstName"></td>
			</tr>
			<tr>
				<th>Last Name</th>
				<td><input type="text" name="lastName"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Go" /></td>
			</tr>
		</table>
		<a href="mainMenu.do">Go back to Main Menu</a>
	</form>
</body>
</html>