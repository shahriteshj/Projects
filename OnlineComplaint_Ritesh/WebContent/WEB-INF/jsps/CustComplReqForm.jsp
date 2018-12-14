<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Complaint Form</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/custom.css">
<style>
* {
	box-sizing: border-box
}
</style>
<script>
	function validateForm() {
		var z = document.forms["regFrm"]["accountId"].value;
		if (!z.match(/^\d+/)) {
			alert("Please enter only numeric characters for your Account Id")
			document.forms["regFrm"]["accountId"].focus();
			return false;
		}
 		if (z.length != 10) {
			alert("Please enter valid 10 digit Account Id")
			document.forms["regFrm"]["accountId"].focus();
			return false;
		} 

	}
</script>

</head>
<body>
	<div class="container">
		<springForm:form id="regFrm" method="POST" commandName="complaint"
			action="submitComplaintData.compl">
			<table id="complaints">
				<tr>
					<td colspan="3" align="center"><h3>Customer Complaint
							Request Form</h3></td>
				</tr>
				<tr>
					<td><label>Account Id: <span class="redText">*</span>
					</label>(Numeric: 10 digits)</td>
					<td><springForm:input id="accountId" path="accountId"
							required="true" minlength="10" maxlength="10" onblur="validateForm()" /></td>
					<td><springForm:errors path="accountId" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label>Branch Code: <span class="redText">*</span>
					</label></td>
					<td><springForm:input path="branchCode" required="true" /></td>
					<td><springForm:errors path="branchCode" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label>Email Id: <span class="redText">*</span>
					</label></td>
					<td><springForm:input path="emailId" required="true" /></td>
					<td><springForm:errors path="emailId" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label>Complaint Category: <span class="redText">*</span>
					</label></td>
					<td><springForm:select path="category" required="true">
							<springForm:option value="">Select</springForm:option>
							<springForm:option value="INTERNET_BANKING">Internet Banking</springForm:option>
							<springForm:option value="GENERAL_BANKING">General Banking</springForm:option>
							<springForm:option value="OTHERS">Others</springForm:option>
						</springForm:select></td>
					<td><springForm:errors path="category" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label>Description: <span class="redText">*</span>
					</label></td>
					<td><springForm:textarea path="description" rows="5" cols="40"
							required="true" /></td>
					<td><springForm:errors path="description" cssClass="error" /></td>
				</tr>
				<tr>
					<td colspan="3" align="center"><springForm:button
							onClick="return validateForm()">Submit</springForm:button></td>
				</tr>
				<tr>
					<td colspan="3" align="center"><a
						href="getComplaintStatus.compl" style="color: dodgerblue">Check
							Status</a></td>
				</tr>
			</table>
		</springForm:form>
	</div>
</body>
</html>