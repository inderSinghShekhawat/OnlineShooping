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

	<form action="home" method="post" modelAttribute="AUTH">
	UserID:<input type="text" name="username"/><br/><br/>  
    Password:<input type="password" name="password"/><br/><br/>  
	<input type="submit" value="Login">
	</form>
</body>
</html>
