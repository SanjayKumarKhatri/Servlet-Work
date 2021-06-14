<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>JSP Page</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	
	</head>
	<body>
		<h1>All user are:</h1>
		<sql:setDataSource driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/usindh" user="root" password="root" var="ds"/>
		<sql:query dataSource="${ds}" var="rs">select * from register;</sql:query>
		
		<div class="container">
		
		<table class="table">
			<tr>
				<td>USER ID</td>
				<td>USER NAME</td>
				<td>USER EMAIL</td>
			</tr>
			
			<c:forEach items="${rs.rows}" var="row">
			
				<tr>
					<td><c:out value="${ row.id}"></c:out></td>
					<td><c:out value="${ row.name}"></c:out></td>
					<td><c:out value="${ row.email}"></c:out></td>
				</tr>
				
			</c:forEach>
		
		
		</table>
		
		
		
		
		</div>
	</body>
</html>