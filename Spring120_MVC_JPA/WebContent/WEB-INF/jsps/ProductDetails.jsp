<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Details</title>
</head>
<body>
	<jsp:include page="Header.jsp" />
	<jsp:include page="Header01.jsp" />
	<table border="1">
		<tr>
			<th>Product Id</th>
			<th>Category</th>
			<th>Name</th>
			<th>Price</th>
			<th></th>
			<th></th>
		</tr>
		<tr>
			<td>${requestScope.prodDetails.prodId}</td>
			<td>${requestScope.prodDetails.category}</td>
			<td>${requestScope.prodDetails.name}</td>
			<td>${requestScope.prodDetails.price}</td>
			<td><a
				href="editProduct.prdt?prodId=${requestScope.prodDetails.prodId}">Edit</a></td>
			<td><a
				href="deleteProduct.prdt?prodId=${requestScope.prodDetails.prodId}">Delete</a></td>
		</tr>
	</table>
	<a href="getProdList.prdt">Go back to Product List</a>
</body>
</html>