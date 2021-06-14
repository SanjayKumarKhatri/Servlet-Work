<%@page import="com.sun.glass.ui.Application"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="t" uri="/WEB-INF/tlds/mylib.tld" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>JSP Page</title>
	</head>
	<body>
		<h1>Hello Word!!</h1>
		
		<t:mytag/>
		<hr>
		
		<t:printTable number="100" color="red"/>
		<t:printTable number="10" color="blue"/>
		<t:printTable number="30" color="pink"/>
		<t:printTable number="9" color="green"/>
		
		
		
		<!-- JSP Implicit Object -->
		
		<%
			
			out.println("This is my implicit objects");
			
			request.getParameter("");
			
		    response.sendRedirect("");
		    
		  // config(SerevletConfig)
		  
		  //application(ServletContext)
		  
		 // session
		 
		 //page: current jsp page
		 
		 //exception : Throwable...
		 
		// pageContext : pageContext.. 
		 
		 out.println(session.isNew());
		 session.setAttribute("name", 23);
			 
		
		
		%>
		
		
		
	

	</body>
</html>