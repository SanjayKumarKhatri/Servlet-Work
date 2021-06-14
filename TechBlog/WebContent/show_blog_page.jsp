<%@page import="java.text.DateFormat"%>
<%@page import="com.tech.blog.dao.Userdao"%>
<%@page import="com.tech.blog.entities.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tech.blog.entities.Posts"%>
<%@page import="com.tech.blog.dao.PostDao"%>
<%@page import="com.tech.blog.entities.User"%>
<%@page errorPage="error_page.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%User user = (User)session.getAttribute("currentuser");
if(user == null){
	response.sendRedirect("login.jsp");
}

%>    
    
    <%
    	int postid = Integer.parseInt(request.getParameter("post_id"));
    	PostDao pd = new PostDao();
    	Posts p = pd.getpostbypostId(postid);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><%=p.getpTitle() %></title>
<!-- Css -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel = "stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
.post-title{
	font-weight:100%;
	font-size: 30px;
	
}
.post-date{
	font-style: italic;
	font-weight: bold;
}
.post-user-info{
	font-size: 20px;
	font-weight: 200px;
}
.row-user{
	border: 1px solid #e2e2e2;
	padding-top: 15px;
}

body{
	background: url("images/bg1.jpg");
	background-size: cover;
	background-attachment: fixed;
}
</style>
</head>
<body>

	<!-- navbar -->
	<nav class="navbar navbar-expand-lg navbar-dark primary-background">
  <a class="navbar-brand" href="index.jsp"><span class="fa fa-asterisk"></span>TechBlog</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="profile.jsp"><span class="fa fa-bell-o"></span>LearnCodeWithExperts <span class="sr-only">(current)</span></a>
      </li>
            <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><span class="	fa fa-check-circle-o"></span>
          Categories
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Programming</a>
          <a class="dropdown-item" href="#">DataStructure</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Project Implementation</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#"><span class = "fa fa-drivers-license"></span>Contact</a>
      </li>
		
	<li class="nav-item">
        <a class="nav-link" href="#" data-toggle="modal" data-target="#add-postmodel"><span class = "fa fa-asterisk"></span>Do Post</a>
      </li>
      
    </ul>
    <ul class="navbar-nav mr-right">
		<li class="nav-item">
        <a class="nav-link" href="#!" data-toggle="modal" data-target="#profile_model"><span class = "fa fa-user-circle "></span><%= user.getName() %></a>
      </li>
	<li class="nav-item">
        <a class="nav-link" href="LogoutServlet"><span class = "fa fa-user-plus"></span>Logout</a>
      </li> 	
    </ul>
    
  </div>
</nav>
	<!-- end of navbar -->
	<!-- main content of the body -->
	<div class="row my-4"> 
		<div class="col-md-8 offset-md-2">
			<div class="card">
				
				<div class="card-header primary-background text-white text-center">
				
					<h4 class="post-title"><%=p.getpTitle() %></h4>
				</div>
				<div class="card-body">
					<img class="card-img-top my-2" src="blogpic/<%=p.getpPic() %>" alt="Card-img-cap" >
					<div class="row my-3 row-user">
						<div class="col-md-8">
						<%Userdao ud = new Userdao(); %>
							<p class="post-user-info"><a href="#!"><%=ud.getUserbyuserId(p.getUserId()).getName() %> </a>has posted : </p>
						</div>
						<div class="col-md-4">
							<p class="post-date"><%=DateFormat.getDateInstance().format(p.getpDate()) %></p>
						</div>
					</div>
					<p class="post-content"><%=p.getpContent() %></p>
					<br>
					<div class="post-code">
					<pre><%=p.getpCode() %></pre>
					</div>
				</div>
				<div class="card-footer primary-background">
					<a href="#!" class="btn btn-outline-light btn-sm"><i class="fa fa-thumbs-o-up"></i><span>10</span></a>
						 
						<a href="#!" class="btn btn-outline-light btn-sm"><i class="fa fa-commenting-o"></i><span>10</span></a>
				</div>
			</div>
		</div>
	</div>
	<!-- end of main content of the body -->

<!-- Modal -->
<div class="modal fade" id="profile_model" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header primary-background text-white">
        <h5 class="modal-title" id="exampleModalLabel">TechBlog</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="container text-center">
        <img src="pics/<%= user.getProfile()%>" class="img-fluid" style="border-radius: 50%; max-width: 150px;">
        	
        	<h5 class="modal-title mt-3 " id="exampleModalLabel"><%=user.getName()%></h5>
        	<!-- detail tables -->
  <div id= "profile_details">      	
 <table class="table" style="height: 50%;">
  
  <tbody>
    <tr>
      <th scope="row">1</th>
      
      <td>ID</td>
      <td><%= user.getId() %></td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Email</td>
      <td><%= user.getEmail() %></td>
      
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>Gender</td>
      <td><%= user.getGender() %></td>
      
    </tr>
     <tr>
      <th scope="row">4</th>
      <td>Status</td>
      <td><%=user.getAbout()%></td>
      
    </tr>
    <tr>
      <th scope="row">5</th>
      <td>Registered On</td>
      <td><%= user.getDatetime().toString()%></td>
      
    </tr>
  </tbody>
</table>
</div>
        	<!-- end detail tables -->
        	
        	<div id="profile_edit" style="display: none;">
        		<h3 class="mt-3">Please Edit Carefully...</h3>
        		<form action="EditServlet" method="post" enctype="multipart/form-data">
        			<table class="table">
        				<tr>
        					<td>ID :</td>
        					<td><%= user.getId() %></td>
        				</tr>
        				<tr>
        					<td>Name :</td>
        					<td><input type="text" class="form-control" name = "inputname" value="<%= user.getName()%>"></td>
        				</tr>
        				<tr>
        					<td>Email :</td>
        					<td><input type="email" class="form-control" name = "inputemail" value="<%= user.getEmail()%>"></td>
        				</tr>
        				<tr>
        				<td>Password :</td>
        					<td><input type="password" class="form-control" name = "inputpass" value="<%= user.getPassword()%>"></td>
        				</tr>
        				<tr>
        				<td>Gender :</td>
        				<td><%= user.getGender().toUpperCase() %></td>
        				</tr>
        				<tr>
        				<td>About :</td>
        					<td><textarea class="form-control" rows="3" name = "abouttextarea" ><%=user.getAbout()%></textarea></td>
        				</tr>
        				<tr>
        					<td>New Profile :</td>
        					<td><input type="file" class="form-control" name = "image"></td>
        				</tr>
        			</table>
        			<div class="container">
        				<button type="submit" class="btn-outline-primary" style="width: 20%;">Save</button>
        			</div>
        		</form>
        	</div>
        	</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" id = "btn-edit-button" class="btn btn-primary">Edit</button>
      </div>
    </div>
  </div>
</div>
	<!-- end of profile model -->
	
	<!-- add post model -->
	
<!-- Modal -->
<div class="modal fade" id="add-postmodel" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Provide the post details...</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form id="add-postform" action="AddPostServlet" method="post" enctype="multipart/form-data">
        	<div class="form-group">
        	<select class="form-control" name="cid">
        		<option selected disabled>---Select---</option>
  				<%
  				PostDao pdao = new PostDao();
  				ArrayList<Category> list = pdao.getAllCategory();
  				for(Category c : list){
  					
  				
  				%>
  				<option value="<%=c.getCid()%>"><%=c.getCname() %></option>
  				<% } %>
  				        	</select>
        	</div>
        	<div class="form-group">
        		<input type="text" name="Ptitle" placeholder="Enter Post Title" class="form-control">
        	</div>
        	<div class="form-group">
        		<textarea class="form-control" name="Pcontent" placeholder="Enter your content..." style="height: 150px;"></textarea>
        	</div>
        
        	<div class="form-group">
        		<textarea class="form-control" name="Pcode" placeholder="Enter your program (If Any)" style="height: 150px;"></textarea>
        	</div>
        	<div class="form-group">
        		<label>Select your picture </label>
        		<br>
        		<input type="file" name="pic">
        	</div>
        	<div class="container text-center">
        		<button type="submit" class="btn btn-outline-primary">Post</button>
        	</div>
        </form>
      </div>
      
    </div>
  </div>
</div>
	<!-- end of add post model -->
<!-- javascript -->
	<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
	<script src="js/myjs.js" type="text/javascript""></script>
	
	<script>
		$(document).ready(function() {
			let editStatus = false;
			$('#btn-edit-button').click(function() {
				if(editStatus == false){
					$("#profile_details").hide()
					$("#profile_edit").show();
					editStatus = true;
					$(this).text("Back")
				}else{
					$("#profile_details").show()
					$("#profile_edit").hide();
					editStatus = false;
					$(this).text("Edit")
				}
			})
		})
	</script>
	<!-- add post using js -->
	<script>
			$(document).ready(function (e) {
					$("#add-postform").on("submit", function(event) {
						
						event.preventDefault();
						console.log("you have clicked on submit")
						let form = new FormData(this);
						//now requesting to server
						$.ajax({
							url: "AddPostServlet",
							type: 'POST',
							data: form,
							success: function(data,textStatus,jqXHR) {
								if(data.trim() == 'done'){
								swal("Good job!", "Saved Successfully!", "success");
								$('#add-postmodel').modal('hide');
								}else{
									swal("Error", "Something wen't wrong!", "error");
								}
								
							},
							error: function(jqXHR,textStatus,errorThrown) {

								swal("Error", "Something wen't wrong!", "error");
							
							},
							processData: false,
							contentType: false
						});
					});
			})
	</script>

</body>
</html>