<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ page errorPage="error_page.jsp" %>
 
   
 <!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
			<title>Example of Taglib directive</title>
	</head>
		<body>
			<h1>Taglib Directive tutorial:</h1>
			<hr>
			
			<c:set var="name" value="Sanjay"></c:set>
			
			<c:out value="${name}"></c:out>		
			
			<c:if test="${3 > 2}">
			<h1>This is true block yes 3 > 2</h1>
			</c:if>
			
			<%!
				int n1 = 20;
				int n2 = 10;
				String content = null;
			
			%>
			
			<%
				int division = n1/n2;
			%>
			
			<h1> Division = <%= division %> </h1>
			<%= content.length() %>
			
		
	

	</body>
</html>