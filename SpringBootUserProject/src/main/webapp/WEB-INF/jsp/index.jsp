<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Home Page</title>
</head>
<body>
<h1>Users List</h1>
<a href="/showCreate">Create New User</a>
<br><br>
<table border="1" cellpadding="10">
	<tr>
		<th>User Id</th>
		<th>User Name</th>
		<th>Department</th>
		<th>Actions</th>
	</tr>  
	<c:forEach var="user" items="${listusers}">   
		<tr>
			<td>${user.id}</td>  
   			<td>${user.username}</td>  
   			<td>${user.department}</td> 
   			<td>
   				<a href="edituser/${user.id}">Edit</a>
   				&nbsp;&nbsp;&nbsp;  
   				<a href="deleteuser/${user.id}">Delete</a>
   			</td>   
		</tr>
	</c:forEach>

</table>
</body>
</html>