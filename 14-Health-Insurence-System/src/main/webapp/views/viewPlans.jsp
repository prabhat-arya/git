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

	<a href="addPlan">Add New Plan</a>

	<table border="1" id="contactTbl">
		<thead>
			<tr>
				<th>S.no</th>
				<th>Plan Name</th>
				<th>Description</th>
				<th>Plan Start Date</th>
				<th>Plan End Date</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
		
		<c:forEach items="${plans}" var="c" varStatus="index">
				<tr>
					<td>${index.count}</td>
					<td>${c.planName}</td>
					<td>${c.descriptions}</td>
					<td>${c.planStartDate}</td>
					<td>${c.planEndDate}</td>
					<td><a href="editPlan?id=${c.id}">Edit</a> 
					<a href="deletePlan?id=${c.id}" onclick="return confirm('Are you sure you want to delete this item?')">Delete</a>
					</td>
				</tr>
			</c:forEach>
		
			

		</tbody>
	</table>

</body>
</html>