<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
		</tr>
		<tr>
			<td>${requestScope.itemDetails.itemId}</td>
			<td>${requestScope.itemDetails.name}</td>
			<td>${requestScope.itemDetails.category}</td>
			<td>${requestScope.itemDetails.price}</td>
		</tr>
	</table>
	<br/>
	<br/>

</div>
	<div class="container">
		<br/><br/>
		
	<p><a href="itemList.do">Go back to Item List</a></p>
	</div>
</body>
</html>