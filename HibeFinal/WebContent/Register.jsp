<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" align="center">
<h4 style="color: navy;" align="center">Sign-Up</h4>
</div>
<div style="width: 100%">
<div class="col-sm-4">
</div>
<div class="col-sm-4">
<form action="<%=request.getContextPath() %>/Register_Servlet" method ="post">
<br>
<input type="text" name="fname" class="form-control" required="required" placeholder="FirstName"/>
<br>
<input type="text" name="lname" class="form-control" required="required" placeholder="LastName"/>
<br>
<input type="text" name="address"class="form-control" required="required" placeholder="Address"/>
<br>
<input type="email" name = email class="form-control"required="required" placeholder="Enter Email">
<br>
<input type="password" name = password class="form-control"required="required" placeholder="Password">
<br>
<input type="password" name = cpassword class="form-control"required="required"placeholder="Confirm Password">
<br>
<br>
<div align="center"><input type="submit" class="btn-success" value="Register"></div>
	      
</form>
</div>
<div class="col-sm-4">

</div>
</div>

</body>
</html>
