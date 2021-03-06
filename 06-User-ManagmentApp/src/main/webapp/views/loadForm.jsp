<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="./js/app.js"></script>
<script>
	$(document).ready(function(e) {
		$("#emailId").blur(function(event) {
			$("#dupEmail").html("");
			var emailId = $("#emailId").val();
			$.ajax({
				url : 'validateEmail?email=' + emailId,
				success : function(abc) {
					if (abc == 'Duplicate') {
						$("#dupEmail").html("Email already register");
						$("#mailId").focus();
					}
				}
			});
		});
		
		$('#sub').submit(function(e){
		    e.preventDefault();
		    e.stopImmediatePropagation();
		    $.ajax({
		        type: "POST",
		        url: $(this).attr( 'action' ),
		        data: $(this).serialize(),
		        success: function( response ) {
		            console.log( response );
		        }
		    });

		    return false;
		});
	});
</script>
</head>
<body>
	<h1 style="color: red">User Registration</h1>

	<h2>
		<font color='green'>${succMsg}</font>
	</h2>
	<h2>
		<font color='red'>${errMsg}</font>
	</h2>
	<h2>
		<font color='yellow'>${updMsg}</font>
	</h2>


	<form:form action="saveUser" id="sc" 
	    modelAttribute="user"
		method="POST">
		<table>
			<tr>
				<td>First Name :</td>
				<td><form:input path="firstName" /></td>
			</tr>

			<tr>
				<td>Last Name :</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>Email ID :</td>
				<td><form:input path="emailId" /> <font color='red'>
						<div id="dupEmail"></div>
				</font></td>
			</tr>
			<tr>
				<td>Phone Number :</td>
				<td><form:input path="phoneNumber" /></td>
			</tr>
			<tr>
				<td>DOB :</td>
				<td><form:input path="dob" /></td>
			</tr>

			<tr>
				<td>Gender :</td>
				<td>Male <form:radiobutton path="gender" value="Male" />
					Female <form:radiobutton path="gender" value="Female" />
				</td>
			</tr>
			<tr>
				<td>Country:</td>

				<td><form:select path="country">
						<form:option value="-" label="-Please Select-" />
						<form:options items="${country}" />
					</form:select></td>
			</tr>
			<tr>
				<td>State:</td>

				<td><form:select path="state">
						<form:option value="">-please select-</form:option>
						
					</form:select></td>
			</tr>
			<tr>
				<td>City:</td>

				<td><form:select path="city">
						<form:option value="-" label="-Please Select-" />
						<form:options items="${countryOptions}" />
					</form:select></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset" /></td>
				<td><input type="submit" id="sub" value="Save" /></td>
			</tr>

		</table>

	</form:form>

	<a href="viewContacts">View all contacts</a>



</body>
</html>