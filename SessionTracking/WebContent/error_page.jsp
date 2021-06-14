<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sorry !! something went to wrong....</title>
	<style type="text/css">
	*{
		padding: 0px;
		margin: 0px;
	}
	</style>
</head>
<body>
	<div style="padding: 20pd;color: blue;background: #e2e2e2;">
		<h1>Sorry !! something went to wrong....</h1>
		<p><%=exception%></p>
	</div>
	

</body>
</html>