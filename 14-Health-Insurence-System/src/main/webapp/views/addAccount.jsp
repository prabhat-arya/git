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
$(document).ready(function(e){
	$("#contactEmail").blur(function(event){
		$("#dupEmail").html("");
		var emailId = $("#contactEmail").val();
		$.ajax({
			url : 'validateEmail?email=' +emailId,
			success : function(abc){
				if(abc == 'Duplicate'){
					$("#dupEmail").html("Email already register");
					$("#contactEmail").focus();
				}
			}		
		});
	});

});

</script> 
<script>
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
</script>
 

</head>
<body>
<h1>Create Admin/CaseWorker</h1>

<h2><font color='green'>${succMsg}</font></h2>
<h2><font color='red'>${errMsg}</font></h2>
<h2><font color='yellow'>${updMsg}</font></h2>


	<form:form action="saveAccount" id="sc"
			   modelAttribute="adminModel" 
			   method="POST">
		<table>
			<tr>
			<form:hidden path="id"/>
				<td>Name : </td>
				<td><form:input path="name"/></td>
			</tr>
			
			<tr>
				<td>Email : </td>
				<td><form:input path="emailId"/>
				<font color='red'>
					<div id="dupEmail"></div>
				</font>
				</td>
			</tr>
			
			<tr>
				<td>Gender :</td>
				<td>Male <form:radiobutton path="gender" value="Male" />
					Female <form:radiobutton path="gender" value="Female" />
				</td>
			</tr>
			
			<tr>
				<td>Role:</td>

				<td><form:select path="role">
						<form:option value="-" label="-Please Select-" />
						<form:options items="${role}" />
					</form:select></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset"/></td>
				<td><input type="submit" id="sub" value="Save"/></td>
			</tr>
			
		</table>
	
	</form:form>
<br>
<br>
<a href="viewAccounts">View all Accounts</a>



</body>
</html>