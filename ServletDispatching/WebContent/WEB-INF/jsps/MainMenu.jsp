<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import='java.util.Iterator'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu</title>
</head>
<body>
	<h1>Menu</h1>
	<% 		
	Iterator<String> resHeaderNamesIT = response.getHeaderNames().iterator();
	while(resHeaderNamesIT.hasNext())
	{
		System.out.println("in res for");
		String headerName = resHeaderNamesIT.next();
		System.out.println( headerName + ": " + response.getHeader(headerName));
	} %>
</body>
</html>