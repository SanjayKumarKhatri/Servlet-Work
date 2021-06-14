<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>JSP Page</title>
	</head>
	<body>
		<h1>Fun Page:</h1>
		<p>This page is all about using functions tags</p>
		<c:set var="name" value="TECHSOFT INDIA"></c:set>
		<h1> <c:out value="${name}"></c:out> </h1>
		
		<h1>Length of number is <c:out value="${fn:length(name)}"></c:out></h1>
		<h1> <c:out value="${fn:toLowerCase(name)}"></c:out></h1>
		<br>
		<h1> <c:out value="${fn:contains(name,'INDIA')}"></c:out> </h1>
	</body>
</html>