<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> Detail Page</h1>
	
	<section class="container-fluid">
		<table border="1">
				<tr>
					<th>num</th>
					<th>title</th>
					<th>content</th>
					<th>Writer</th>
					<th>contents</th>
					<th>regDate</th>
					<th>hit</th>			
				</tr>
			<tr>
				<td>${detail.num}</td>
				<td>${detail.title}</td>
				<td>${detail.content}</td>
				<td>${detail.writer}</td>
				<td>${detail.regDate}</td>
				<td>${detail.hit}</td>
			</tr>
	</table>
	</section>
	<a href="update?num=${detail.num}">수정</a>
	<a href="delete?num=${detail.num}">삭제</a>
</body>
</html>