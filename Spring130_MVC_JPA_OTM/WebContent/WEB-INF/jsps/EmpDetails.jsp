<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Details</title>
</head>
<body>
	<jsp:include page="Header.jsp" />
	<jsp:include page="Header01.jsp" />
	<table border="1">
		<tr>
			<th>Employee Id</th>
			<th>Name</th>
			<th>Salary</th>
			<th>Dept No</th>
			<th>Dept Name</th>
		</tr>
		<tr>
			<td>${requestScope.empDetails.empNo}</td>
			<td>${requestScope.empDetails.empNm}</td>
			<td>${requestScope.empDetails.empSal}</td>
			<td>${requestScope.empDetails.dept.deptNo}</td>
			<td>${requestScope.empDetails.dept.deptNm}</td>
		</tr>
	</table>
	<a href="getDeptList.hr">Go back to list</a>
</body>
</html>