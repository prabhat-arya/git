<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script>
	function validatePwds() {
		var newPwd = $("#newPwd").val();
		var conformPwd = $("#conformPwd").val();
		if(newPwd!=conformPwd){
			$("#errId").text('new password and conform passowrd should be same');
			return false;
		}
		return true;
	}
</script>
</head>
<body>
<h1>Unlock Account</h1>
<font color="red"> ${errMsg} </font>
	<form:form action="unlockUserAcc" modelAttribute="unlockAcc" method="POST">
	
	<font color='red'><span id="errId"></span></font>
	
		<table>
		<tr>  
			<td>Your Email :</td>
			<td> <form:input path="email" readonly="true"/> </td>
		</tr>
		
		<tr>  
			<td>Enter Temporary password </td>
			<td> <form:password path="tempPwd"/> </td>
		</tr>
		<tr>  
			<td>Enter New password </td>
			<td> <form:password path="newPwd"/> </td>
		</tr>
		<tr>  
			<td>Conform New password </td>
			<td> <form:password path="conformPwd"/> </td>
		</tr>
		
		<tr>  
			<td></td>
			<td> <input type="submit" value="Unlock" onclick="javascript:return validatePwds()"/> </td>
		</tr>
		
		</table>
	</form:form>
</body>
</html>