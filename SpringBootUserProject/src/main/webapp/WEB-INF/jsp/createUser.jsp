<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to User Page</title>
</head>
<body bgcolor="lightblue">
<form action="insertUser" method="post">
<table border="1">
<tr>
<td>Id:</td>
<td><input type="text" name="id"></td>
</tr>
<tr>
<td>User Name:</td>
<td><input type="text" name="username"></td>
</tr>
<tr>
<td>Department:</td>
<td><input type="text" name="department"></td>
</tr>
<tr><td><input type="submit" value="Save"></td></tr>
</table>
</form>
</body>
</html>