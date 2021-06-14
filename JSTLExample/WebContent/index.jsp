<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>JSTL Example</title>
	</head>
	<body>
		<h1>This is JSTL Example</h1>
		
		<!--1.   out tag :   -->
		
		<!--2.   set tag :     -->
		
		<c:set var="i" value="230" scope="application"></c:set>
		
		<h1> <c:out value="${i}"></c:out> </h1>
		
		<!--3. remove tag  -->
		
		<%-- <c:remove var="i"/> --%>
		
		<h1> <c:out value="${i}">This is default value</c:out> </h1>
		
		<hr>
		
		<!-- 4. if : test condition : true => print..... -->
		<c:if test="${i > 23 }">
			<h1>yes i > 23 and condition is true </h1>
			<p>this is paragraph,hello how are you</p>
		</c:if>
		
		<!-- 5. choose, when ,otherwise : java Switch case -->
		
		<c:choose>
			<c:when test="${i > 0 }">
				<h1>This is my first case</h1>
				<h1>The number is positive</h1>
			</c:when>
			
			<c:when test="${i <0 }">
				<h1>This is my Second case</h1>
				<h1>The number is negative</h1>
			</c:when>
			
			<c:otherwise>
				<h1>Default case......otherwise</h1>
				<h1>The number is zero</h1>
			</c:otherwise>
		</c:choose>
		
		<!-- 6. forEach tag: for repeating and traversing -->
		
		<c:forEach var="j" begin="1" end="10">
			<h1>value of j<c:out value="${j}"></c:out></h1>
		</c:forEach>
		
		<!-- 7. url,param -->
		
		<c:url var="myurl" value="https://www.google.com/search">
			<c:param name="q" value="learn code with durgesh sevlet"></c:param>
		</c:url>
		
		<h1> <c:out value="${myurl}"></c:out> </h1>
		
		<!-- 8. re direct -->
		
		<c:redirect url="${myurl }"> </c:redirect>
		
		
	
	</body>
</html>