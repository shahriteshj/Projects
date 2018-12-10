<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.jp.hr.entities.Product"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product List</title>
</head>
<body>
	<jsp:include page="Header.jsp" />
	<jsp:include page="Header01.jsp" />
	${message}
	<table border="1">
		<tr>
			<th>Product Id</th>
			<th>View Details</th>

		</tr>
		<c:forEach items="${requestScope.productList }" var="prod">
			<tr>
				<td>${prod.prodID }</td>
				<td><a href="prodDetails.do?prodId=${ prod.prodID }">View
						Details</a></td>

			</tr>
		</c:forEach>
	</table>
	<a href="mainMenu.do">Go back to Main Menu</a>
</body>
</html>