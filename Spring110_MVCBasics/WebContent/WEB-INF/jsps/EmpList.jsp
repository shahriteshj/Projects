<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.jp.hr.entities.Employee"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee List</title>
</head>
<body>
	<jsp:include page="Header.jsp" />
	<jsp:include page="Header01.jsp" />
	<table border="1">
		<tr>
			<th>Employee Id</th>
			<th>View Details</th>

		</tr>

<%-- 		for (Employee emp : (ArrayList<Employee>) request.getAttribute("empList")) {	
		<!-- <tr> -->
		<td><%=emp.getEmpId()%></td>
		<td><%=emp.getFirstName()%></td>
		<td><%=emp.getLastName()%></td>
		<!-- </tr> -->
		}	
 --%>
		<c:forEach items="${requestScope.empList }" var="emp">
			<tr>
				<td>${emp.empId }</td>
				<td><a href="empDetails.hr?empId=${ emp.empId }">View
						Details</a></td>

			</tr>
		</c:forEach>



	</table>

	<a href="homePage.hr">Go back to Main Menu</a>

</body>
</html>