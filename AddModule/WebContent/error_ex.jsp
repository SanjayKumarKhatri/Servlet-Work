<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Sorry !! Something went wrong......</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	</head>
	<body>
		<div class="container p-3 text-center">
		<img src="img/error.jpg" class="img-fluid">
		
		<h1>Sorry ! something went wrong....</h1>
		<p><%= exception %></p>
		<a class="btn btn-outline-primary" href="index.html">Home Page</a>
		</div>
		
	</body>
</html> 