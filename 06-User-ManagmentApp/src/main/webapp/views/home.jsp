<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project home</title>
</head>
<body>
<h1 style="color: red">Mini-Project 2</h1>

<form:form action="login" modelAttribute="userAcc" method="get">
	<table>
	<h2>Login here</h2>
	<tr>
		<td>Email : </td>
		<td><form:input path="emailId"/> </td>
	 </tr>
	 
	 <tr>
		<td>Pssword : </td>
		<td><form:input path="password"/> </td>
	 </tr>
	 <tr>
		<td><input type="submit" value="Sing In"></td>
	 </tr>
	</table>
	
</form:form>
<h2><a href="http://localhost:8081/loadForm">Sign Up</a></h2>
<h2><a href="http://localhost:8081/loadForm">Sign Up</a></h2>

</body>
</html>