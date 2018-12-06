<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.jp.shopping.entity.ItemMaster"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
</head>
<body>
<br/><br/><br/>
<div class="container text-center">
	<table border="1">
		<tr>
			<th width="100px">Item Id</th>
			<th width="100px">Name</th>
			<th width="100px">Category</th>
			<th width="100px">Price</th>
			<th width="100px">Quantity</th>
		</tr>
				<c:forEach items="${sessionScope.shoppingcart }" var="item">
			<tr>
				<td>${item.itemId }</td>
				<td>${item.name }</td>
				<td>${item.category }</td>
				<td>${item.price }</td>
				<td>1</td>
				
			</tr>
		</c:forEach>
		<tr>
		<td colspan=5>Total =${requestScope.TotalPrice } </td>
		</tr>
	</table>
</div>
	<div class="container">
		<br/><br/>
		
	<span><a href="itemList.do">Item List</a></span>
	<span><a href="placeOrder.do">Place Order</a></span>
	</div>
</body>
</html>