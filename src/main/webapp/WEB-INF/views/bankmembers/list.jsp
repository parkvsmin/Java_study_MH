
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<section class="container-fluid">
	<h1>Member List Page</h1>
	<table border="1" class="table table-striped">
	<thead>
	<tr>
	<th>ID</th>
	<th>Name</th>
	<th>Email</th>
	<th>Phone</th>
	</tr>
	</thead>
	<tbody>
		<c:forEach begin="10" end="0" var="i" step="2">
			<h3>${pageScope.i}</h3>
		</c:forEach>
		
		<c:forEach items="${requestScope.list}" var="dto">
		<tr>
			<td>${pageScope.dto.userName}</td>
			<td>${pageScope.dto.name}</td>
			<td>${pageScope.dto.email}</td>
			<td>${pageScope.dto.phone}</td>
		</tr>
		</c:forEach>
		
	</tbody>
	</table>
	</section>
	
	<c:import url="../template/footer.jsp"></c:import>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>