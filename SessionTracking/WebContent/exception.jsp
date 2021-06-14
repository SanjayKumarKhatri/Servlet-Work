<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error_page.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Example of exception</title>
</head>
<body>
	<h1>Example of exception</h1>
	
	<%!
		int n1 = 20;
		int n2 = 0;
	%>
	
	<%
		int division = n1/n2;
	%>
	
	<h1>Division = <%= division %></h1>

</body>
</html>