<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
<!-- Css -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel = "stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">



</head>
<body>
<%@include file="normalnavbar.jsp" %>
<main class="primary-background" style="padding-bottom:80px; padding-top:20px;">
<div class="container">
	<div class="col-md-4 offset-md-4" >
		<div class="card">
			<div class="card-header text-center primary-background text-white"><span class="fa fa-3x fa-user-circle "></span><br>Register Here</div>
			<div class="card-body">
				<form id = "reg-form" action="RegisterServlet" method="post">
				  <div class="form-group">
				    <label for="Username">Enter Name</label>
				    <input type="text" name = "name" class="form-control" id="Username"  placeholder="Enter name">
				  </div>
				  
				  <div class="form-group">
				    <label for="exampleInputEmail1">Email address</label>
				    <input type="email" name = "emailaddress" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
				    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
				  </div>
				  
				  <div class="form-group">
				    <label for="exampleInputPassword1">Password</label>
				    <input type="password" name = "pass" class="form-control" id="exampleInputPassword1" placeholder="Password">
				  </div>
				  
				  <div class="form-group">
				    <label for="gender">Select gender</label>
				    <br>
				    <input type="radio" id="gender" name = "gender" value="male">Male
				    <input type="radio" id="gender" name = "gender" value="female">Female			    
				  </div>
				  
				  
				  <div class="form-group">
				   <textarea name = "about" class="form-control" rows="5"  placeholder="Enter something about yourself..."></textarea>
				  </div>
				  
				  <div class="form-check">
				    <input type="checkbox" name = "check" class="form-check-input" id="exampleCheck1">
				    <label class="form-check-label" for="exampleCheck1">agree terms and condition</label>
				  </div>
				  <div class="container text-center" id = "loader" style="display: none;">
				  	<span class="fa fa-refresh fa-spin fa-3x">
				  	<h3>Please wait...</h3>
				  	</span>
				  </div>
				  <button type="submit" class="btn btn-primary" id = "btn-submit">Submit</button>
				
				</form>
			</div>
			
		</div>
	</div>
</div>

</main>
<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script src="js/myjs.js" type="text/javascript""></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
	<script>
		$(document).ready(function (){
			console.log("loaded...")
			
			$('#reg-form').on('submit', function (event) {
				event.preventDefault();
				let form = new FormData(this);
				$("#btn-submit").hide();
				$("#loader").show();
				
				//send register servlet
				$.ajax({
					url: "RegisterServlet",
					type: 'POST',
					data: form,
					success: function(data, textStatus,jqXHR) {
						console.log(data)
						
						$("#btn-submit").show();
						$("#loader").hide();
						if(data.trim() === 'done'){
						swal("Registered successfully..we are going to redirecting to login page")
						.then((value) => {
							window.location = "login.jsp";
						});
				}else{
					swal(data);
				}
					},
					error: function(jqXHR, textStatus,errorThrown) {
						$("#btn-submit").show();
						$("#loader").hide(); 	
						swal("something went wrong.. try again..")

					},
					processData: false,
					contentType: false
				});
			});
		})
	
	</script>
</body>
</html>