<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<jsp:include page="Header.jsp" />
	<form id="loginfrm" name="loginfrm" method="POST"
		action="registration.do">
		<div style="color: red">${errMsg}</div>
		Full Name: <input type="text" name="name"> <br /> <br />
		User Name: <input type="text" name="username"> <br /> <br />
		Password: <input type="password" name="password"> <br /> <br />
		Email: <input type="text" name="email"> <br /> <br />
		<input type="submit" name="submit" value="Register"> <input
			type="reset" name="reset" value="Cancel">
			<a href="/login.do" >Back to Login</a>
	</form>
</body>
</html>