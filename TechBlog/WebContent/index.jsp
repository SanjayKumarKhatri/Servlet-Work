<!DOCTYPE html>
<%@page import="com.tech.blog.dao.PostDao"%>
<%@page import="com.tech.blog.entities.Posts"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.tech.blog.helper.DBConnection"%>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Technical Blog</title>
<!-- Css -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel = "stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
	.banner-background{
		clip-path: polygon(50% 0%, 100% 0, 100% 43%, 100% 99%, 73% 89%, 40% 100%, 0 87%, 0% 43%, 0 0);
		
	}

</style>
</head>
<body>
	<%
	Connection con = DBConnection.getmeconnect();
	
	
	%>
	<!-- navbar -->
	<%@include file="normalnavbar.jsp" %>
	
	<!-- banner -->
	<div class="container-fluid m-0 p-0">
		<div class="jumbotron primary-background text-white">
			<div class="container">
				<h3 class="display-4">Welcome to TechBlog</h3>
				<p>Welcome to technical blog, world of technology
					Computer programming is the process of designing and building an executable computer program to accomplish a specific computing result. 
				</p>
				<p>Programming involves tasks such as: analysis, generating algorithms, profiling algorithms' accuracy and resource consumption, and the implementation of algorithms in a chosen programming language (commonly referred to as coding).</p>
				<a class="btn btn-outline-light btn-lg" href="Registerpage.jsp"><span class="fa fa-user-plus"></span>Start ! it's Free</a>
				<a class="btn btn-outline-light btn-lg" href="login.jsp"><span class="fa fa-user-circle fa-spin"></span>Login</a>	
			</div>
		</div>
	</div>
	<!-- cards -->
	<div class="container">
		<div class="row mb-2">
			<%
	PostDao pd = new PostDao();
	
	List<Posts> posts = null;
		posts = pd.getallposts();
		for(Posts p : posts){
		%>

			
			<div class="col-md-4">
				<div class="card">
					<img class="card-img-top img-fluid" src="blogpic/<%=p.getpPic() %>" alt="Card-img-cap" >	
  				 <div class="card-body">
			    <h5 class="card-title"><%=p.getpTitle() %></h5>
			    <p class="card-text"><%=p.getpContent() %></p>
			    <a href="show_blog_page.jsp?post_id=<%=p.getPid() %>" class="btn btn-primary text-white">Read more..</a>
  				</div>
				</div>
				
			</div>
			<%
		}
%>
				</div>
	
	</div>
	<!-- javascript -->
	<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script src="js/myjs.js" type="text/javascript""></script>
	
</body>
</html>