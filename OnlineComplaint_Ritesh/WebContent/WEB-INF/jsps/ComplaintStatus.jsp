<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Complaint Status</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/custom.css">
<style>
* {
	box-sizing: border-box
}
</style>
</head>
<body>
	<div class="container">
		<form name="statusfrm" method="GET" action="getComplaintDetails.compl">
			<table id="complaints">
				<tr>
					<td colspan="2" align="center"><h3>Check Status</h3></td>
				</tr>
				<!-- 		<tr>
			<td colspan="2"><hr>
			</td>
		</tr> -->
				<tr>
					<td><label>Complaint Id: </label></td>
					<td><input type="number" name="complaintId" required /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><button name="submit">Check
							Status</button></td>
				</tr>
				<tr>
					<td colspan="2" align="center" class="error">${msg }</td>
				</tr>

			</table>
		</form>
		<br />
		<br />
		<table id="complaints">
			<tr>
				<th>Complaint Id</th>
				<th>Description</th>
				<th>Status</th>
			</tr>
			<tr>
				<td align="center">${requestScope.complaintDetails.complaintId}</td>
				<td>${requestScope.complaintDetails.description}</td>
				<td align="center">${requestScope.complaintDetails.status}</td>
			</tr>
		</table>
		<br />
		<br /> <a href="homePage.compl" style="color: dodgerblue">Raise
			Complaint</a>
	</div>
</body>
</html>