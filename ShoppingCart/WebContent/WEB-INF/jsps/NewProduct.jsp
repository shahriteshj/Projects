<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Product</title>
</head>
<body>
	
	<jsp:include page="Header01.jsp" />
	<form method="POST" action="addProduct.do" enctype="multipart/form-data">
		${message}
		<table>
			<tr>
				<th>Product Id</th>
				<td><input type="text" name="prodID"></td>
			</tr>
			<tr>
				<th>Category</th>
				<td><input type="text" name="category"></td>
			</tr>
			<tr>
				<th>Name</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>Price</th>
				<td><input type="text" name="price"></td>
			</tr>
			<tr>
				<th>Image</th>
				<td><input type="file" name="filetoupload"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Go" /></td>
			</tr>
		</table>
		<a href="mainMenu.do">Go back to Main Menu</a>
	</form>
</body>
</html>