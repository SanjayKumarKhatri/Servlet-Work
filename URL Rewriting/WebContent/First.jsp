<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background: #e2e2e2">

	<h1>First JSP page</h1>
	 
	 <%!
	 	int a = 10;
	 	int b = 50;
	 	String name = "Sanjay Kumar";
	 	
	 	public int doSum() {
	 		return a + b;
	 		
	 	}
	 	
	 	public String reverse() {
	 		
	 		StringBuffer br = new StringBuffer(name);
	 		return br.reverse().toString();
	 	}
	 %>
	 
	 <%
	 	out.println(a);
	 	out.println("<br>");
	 	out.println(b);
	 	out.println("<br>");
	 	out.println("Sum is :"+doSum());
	 	out.print("<br>");
	 	out.println(reverse());
	 %>
	 
	 <h1 style="color: red">Sum is : <%= doSum() %></h1>
	 <h1><%= a %></h1>
	 <h1><%= name %></h1>
	 
	 
</body>
</html>