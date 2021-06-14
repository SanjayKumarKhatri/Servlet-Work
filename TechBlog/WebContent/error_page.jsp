<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sorry ! something went wrong...</title>
<!-- Css -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel = "stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

	

</head>
<body>
	<div class = "container text-center">
		<img src="images/error.png" class="img-fluid">
		<h3 class="display-3">Sorry ! something went wrong...</h3>
		<%= exception %>
		<a href="index.jsp" class="btn primary-background btn-lg text-white mt-3">Home</a>
	</div>
</body>
</html>