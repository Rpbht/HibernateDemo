<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<div align="center" class="container" style="margin:1%">
<H2>Welcome <c:out value="${sessionScope.name}" ></c:out> </H2> 
	<input type="button" class="btn btn-info" value="Edit Profile" onclick="location.href = '<%=request.getContextPath() %>/EditProfile';">
</div>

<div align="center" class="container" style="margin:1%">
<table border=1 class="table">
	<caption>My Workers</caption>
	<thead>
	<th align="center">Worker Name</th>
	<th align="center">Address</th>
	<th align="center">Remove Worker</th>
	</thead>
	<tbody>
 	<c:forEach items="${workers}" var="arr">
		<tr>
			<td>${arr.name}</td>
			<td>${arr.address}</td>
			<td><a href="<%=request.getContextPath()%>${'/DeleteWorker?id='}${arr.id}">Remove</a></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</div>
<br>
<a style="margin:1%" class="btn btn-Success" href="<%=request.getContextPath() %>/AddWorker.jsp">Add New Worker</a>
</body>
</html>