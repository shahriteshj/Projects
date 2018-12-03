<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
	
	<form id="loginfrm" name="loginfrm" method="POST"
		action="registration.do">
		<div style="color: red">${errMsg}</div>
		Full Name: <input type="text" name="name" required> <br /> <br />
		User Name: <input type="text" name="username" required> <br /> <br />
		Password: <input type="password" name="password" required> <br /> <br />
		Email: <input type="text" name="email" required> <br /> <br />
		<input type="submit" name="submit" value="Register"> <input
			type="reset" name="reset" value="Cancel">
			<a href="login.do" >Back to Login</a>
	</form>
</body>
</html>