<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Details</title>
</head>
<body>
	
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
		<tr>
			<td>${requestScope.prodDetails.prodID}</td>
			<td>${requestScope.prodDetails.category}</td>
			<td>${requestScope.prodDetails.name}</td>
			<td>${requestScope.prodDetails.price}</td>
			<td><img src="data:image/jpg;base64,${requestScope.prodDetails.base64Image}" alt="No image"></td>
			<td><a
				href="editProduct.do?prodID=${requestScope.prodDetails.prodID}">Edit</a></td>
			<td><a
				href="deleteProduct.do?prodID=${requestScope.prodDetails.prodID}">Delete</a></td>
		</tr>
	</table>
	<a href="productList.do">Go back to Product List</a>
</body>
</html>