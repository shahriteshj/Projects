<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Product</title>
</head>
<body>
	<jsp:include page="Header.jsp" />
	<jsp:include page="Header01.jsp" />
	<form method="POST" action="modifyProduct.do">

		<table>
			<tr>
				<th>Product Id</th>
				<td><input type="text" name="prodID"
					value="${requestScope.productDetails.prodID}" readonly></td>
			</tr>
			<tr>
				<th>Category</th>
				<td><input type="text" name="category"
					value="${requestScope.productDetails.category}"></td>
			</tr>
			<tr>
				<th>Name</th>
				<td><input type="text" name="name"
					value="${requestScope.productDetails.name}"></td>
			</tr>
			<tr>
				<th>Price</th>
				<td><input type="text" name="price"
					value="${requestScope.productDetails.price}"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Update" /></td>
			</tr>
		</table>
		<a href="productList.do">Go back to Product List</a>
	</form>
</body>
</html>