<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
	
<script>
	$(document).ready(function() {
		$('#contactTbl').DataTable({
			"pagingType" : "full_numbers"
		});
	});
	
	/* function deleteConfirm(){
		return confirm("Are you sure, you want to delete?");
	} */
</script>
</head>
<body>
	<h1>View all Account</h1>

	<a href="addAdmin">Add New Account</a>

	<table border="1" id="contactTbl">
		<thead>
			<tr>
				<th>S.no</th>
				<th>Name</th>
				<th>Email</th>
				<th>Gender</th>
				<th>role</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
		
		<c:forEach items="${accounts}" var="c" varStatus="index">
				<tr>
					<td>${index.count}</td>
					<td>${c.name}</td>
					<td>${c.emailId}</td>
					<td>${c.gender}</td>
					<td>${c.role}</td>
					<td><a href="editAccount?id=${c.id}">Edit</a> 
					<a href="deleteAccount?id=${c.id}" onclick="return confirm('Are you sure you want to delete this item?')">Delete</a>
					</td>
				</tr>
			</c:forEach>
		
			

		</tbody>
	</table>

</body>
</html>