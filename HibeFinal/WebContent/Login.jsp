<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>



<div class="container" align="center" style="margin-top: 15%;">
<h4 style="color: navy;" align="center">Login</h4>
</div>
<div style="width: 100%">
<div class="col-sm-4">
</div>
<div class="col-sm-4">

<c:out value="${msg}"></c:out>
<br>

<form action="<%=request.getContextPath() %>/Login_Servlet" method="post">
<input type="email" name="email" class="form-control" required="required" placeholder="Email"/>
<br>
<input type="password" name="password" class="form-control" required="required" placeholder="Password"/>


	      <br>
			<div align="center"><input type="submit" class="btn-success" value="Login"></div>
	      
</form>
</div>
<div class="col-sm-4">

</div>
</div>

</body>
</html>







































<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Here</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/Login_Servlet" method="post">
	<table>
	<tr>
		<td><label>Email :</label></td>
		<td><input type="email" name="uname" required/></td>
	</tr>
	<tr>
		<td><label>Password :</label></td>
		<td><input type="password" name="password" required/></td>
	</tr>
	<tr>
	<td colspan="2">
	<br>
	<div align="center"><input type="submit" value="Login"></div>
	</td>
	</tr>
	</table>
</form>
 --%>