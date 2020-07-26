<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User Details</title>
</head>
<body>
<h1>Edit Employee</h1>

<form:form action="editSave" method="post">
	<table border="1">
		<tr>
			<td>Id:</td>
			<td><form:hidden path="id" /></td>
		</tr>
		<tr>
			<td>User Name:</td>
			<td><form:input path="username" /></td>
		</tr>
		<tr>
			<td>Department:</td>
			<td><form:input path="department" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="Update"></td>
		</tr>
	</table>

</form:form>

</body>
</html>