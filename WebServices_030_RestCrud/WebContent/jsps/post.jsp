<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee</title>

</head>
<body>
<form name="frm" method="post" action="hr/emps">
	Enter Employee id: <input type="text" name="txtEmpId" required pattern="[1-9]{1,3}"/><br>
	Enter Employee First Name: <input type="text" name="txtFirstName" required pattern="[A-Za-z]+"/><br>
	Enter Employee Last Name: <input type="text" name="txtLastName" required pattern="[A-Za-z]+"/><br>
	
	<input type="submit" value="Add Employee" />
</form>
</body>
</html>