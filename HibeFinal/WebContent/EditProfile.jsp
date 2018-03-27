<!DOCTYPE html>
<%@page import="com.rahul.cignex.Owner"%>
<%@page import="com.rahul.cignex.Worker"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
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
<h4 style="color: navy;" align="center">Edit Profile</h4>
</div>
<div style="width: 100%">
<div class="col-sm-4">
</div>
<div class="col-sm-4">
<form action="<%=request.getContextPath() %>/Update" method ="post">

<% ArrayList<Owner> owner =(ArrayList<Owner>) request.getAttribute("owner"); %>
<br>
<input type="text" name="fname" class="form-control" required="required" value="<%=owner.get(0).getfName()%>" placeholder="FirstName"/>
<br>
<input type="text" name="lname" class="form-control" required="required" value="<%=owner.get(0).getlName()%>" placeholder="LastName"/>
<br>
<input type="text" name="address"class="form-control" required="required" value="<%=owner.get(0).getAddress()%>"placeholder="Address"/>
<br>
<input type="email" name = email class="form-control"required="required" value="<%=owner.get(0).getEmail()%>" placeholder="Enter Email">
<br>
<input type="password" name = password class="form-control"required="required" value="<%=owner.get(0).getPassword()%>" placeholder="Password">
<br>
<input type="password" name = cpassword class="form-control"required="required" value="<%=owner.get(0).getPassword()%>"placeholder="Confirm Password">

<br>
			<div align="center"><input type="submit" class="btn-success" value="Update"></div>
	      
</form>
</div>
<div class="col-sm-4">

</div>
</div>

</body>
</html>
