<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>

	<P>The time on the server is ${serverTime}.</p>

	<form action="user" method="post">
	EmployeeID 	    <input type="text" name="empid"><br> 
	Employee Name	<input type="text" name="empname"><br> 
	Employee Address<input type="text" name="empaddress"><br>
	Employee Salary <input type="text" name="salary"><br>
	Employee Age    <input type="text" name="empAge"><br>
	<input type="submit" value="Login">
	</form>
</body>
</html>