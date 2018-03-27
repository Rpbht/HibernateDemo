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
<div class="container" align="center"  style="margin-top: 10%">
<h4 style="color: navy;" align="center">Add New Worker</h4>
</div>
<div style="width: 100%">
<div class="col-sm-4">
</div>
<div class="col-sm-4">
<form action="<%=request.getContextPath() %>/Add_Worker" method ="post">
<br>
<input type="text" name="name" class="form-control" required="required" placeholder="Name"/>
<br>
<input type="text" name = "address" class="form-control"required="required"placeholder=Address>

<br>
			<div align="center"><input type="submit" class="btn-success" value="Add"></div>
	      
</form>
</div>
<div class="col-sm-4">

</div>
</div>

</body>
</html>
