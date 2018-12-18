<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Product</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>
	<jsp:include page="Header.jsp" />
	<jsp:include page="Header01.jsp" />
	<div style="color:red">${msg}</div>
	   <springForm:form method="POST" commandName="product"
        action="saveProduct.prdt">
		
		<table>
			<tr>
				<th>Product Id</th>
				<td><springForm:input path="prodId" /></td>
				  <td><springForm:errors path="prodId" cssClass="error" /></td>
			</tr>
			<tr>
				<th>Category</th>
				<td><springForm:input path="category" /></td>
				<td><springForm:errors path="category" cssClass="error" /></td>
			</tr>
			<tr>
				<th>Name</th>
				<td><springForm:input path="name" /></td>
				<td><springForm:errors path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<th>Price</th>
				<td><springForm:input path="price" /></td>
				<td><springForm:errors path="price" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Save" /></td>
			</tr>
		</table>
		<a href="homePage.hr">Go back to Main Menu</a>
	</springForm:form>
</body>
</html>