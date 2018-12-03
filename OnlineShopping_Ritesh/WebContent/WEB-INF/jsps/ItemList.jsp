<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Shopping</title>
</head>
<body>
<br/><br/><br/>
	<div class="container text-center">
		${message}
		<table border="1">
			<tr>
				<th width="100px" align="center">Item Id</th>
				<th width="100px">Name</th>
				<th width="150px"></th>
				<th width="150px"></th>
			</tr>
			<c:forEach items="${requestScope.itemList }" var="item">
				<tr>
					<td>${item.itemId }</td>
					<td>${item.name }</td>
					<td><a href="itemDetails.do?itemId=${ item.itemId }">Show
							Details</a></td>
					<td><a href="addToCart.do?itemId=${ item.itemId }">Add to
							Cart</a></td>
				</tr>
			</c:forEach>

		</table>
		
	</div>
	
		<div class="container">
		<br/><br/>
		
	<span><a href="cart.do">View Cart</a>  </span> 
	<span>	<a href="home.do">Go back to Main Menu</a></span>
	</div>
</body>
</html>