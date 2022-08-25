<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<h1>${board} Detail Page</h1>
	
	<div class="row">
		<a href="./reply?num=${boardDTO.num}" class="btn btn-danger">Reply</a>
	</div>
	
	<section class="container-fluid">
		<table border="1">
				<tr>
					<th>num</th>
					<th>title</th>
					<th>contents</th>
					<th>Writer</th>
					<th>regDate</th>
					<th>hit</th>			
				</tr>
			<tr>
				<td>${boardDTO.num}</td>
				<td>${boardDTO.title}</td>
				<td>${boardDTO.contents}</td>
				<td>${boardDTO.writer}</td>
				<td>${boardDTO.regDate}</td>
				<td>${boardDTO.hit}</td>
			</tr>
	</table>
	</section>
	<a href="update?num=${boardDTO.num}">수정</a>
	<a href="delete?num=${boardDTO.num}">삭제</a>
	<c:import url="../template/footer.jsp"></c:import>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>
</body>
</html>