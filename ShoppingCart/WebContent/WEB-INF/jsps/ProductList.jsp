<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.jp.shopping.entities.Product"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product List</title>
</head>
<body>

	<jsp:include page="Header01.jsp" />
	${message}
	<table border="1">
		<tr>
			<th>Product Id</th>
			<th>Category</th>
			<th>Name</th>
			<th>Price</th>
			<th>Image</th>
			<th></th>
			<th></th>

		</tr>
		<c:forEach items="${requestScope.productList }" var="prod">
			<tr>
				<td>${prod.prodID }</td>
				<td>${prod.category}</td>
				<td>${prod.name}</td>
				<td>${prod.price}</td>
				<td><img
					src="data:image/jpg;base64,${prod.base64Image}"
					alt="No image"></td>
				<td><a
					href="editProduct.do?prodID=${prod.prodID}">Edit</a></td>
				<td><a
					href="deleteProduct.do?prodID=${prod.prodID}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="mainMenu.do">Go back to Main Menu</a>
</body>
</html>