<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>New Joining</title>
	</head>
	<body>
	<jsp:include page="Head01.jsp"/>
	<jsp:include page="Head02.jsp"/>
	Welcome Mr./Ms. ${ sessionScope.userFullName }
	<!-- <a href="logout.do">Logout</a> -->
	<form action="submitJoinee.do" method="POST">
	${ message }
		<table>
			<tr><th>EmpId</th>
			<td><input type="text" name="empId"></td>
			</tr>
			<tr>
			<th>First Name</th>
				<td><input type="text" name="firstName"></td>
			</tr>
			<tr>
			<th>Last Name</th>
				<td><input type="text" name="lastName"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="GO"/></td>
			</tr>
		</table>
		<a href="mainMenu.do">Go back to Main Menu</a>
		</form>
	</body>
</html>