<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
    
 <%@page import="java.util.Random" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Page</title>
	<style type="text/css">
		*{
			margin: 0px;
			padding: 0px;
		
		}
	
	
	</style>
</head>

	<body>
		<%@include file="header.jsp" %>
		<h1>Random Number is :
		
		<%
			Random r = new Random();
			int n = r.nextInt(10);
		%>
		<%= n %>
	    
	    </h1>

	</body>
</html>