<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>List Page</h1>

	<table border="1">
	<thead>
		<tr>
			<th>num</th>
			<th>title</th>
			<th>writer</th>
			<th>contents</th>
			<th>regDate</th>
			<th>hit</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="dto">
			<tr>
				<td><a href="./detail.iu?num=${dto.num}">${dto.title}</a></td>
				<td>${dto.title}</td>
				<td>${dto.writer}</td>
				<td>${dto.contents}</td>
				<td>${dto.regDate}</td>
				<td>${dto.hit}</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>

</body>
</html>