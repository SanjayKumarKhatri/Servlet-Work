<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>JSP Page</title>
	</head>
	<body style="background-color: red">
		<h1>This is page Two</h1>
		
		//redirection
		<%
			//response.sendRedirect("page3.jsp");
			
			response.sendRedirect("https://www.techsoftindia.co.in");
		
		
		%>
	</body>
</html>