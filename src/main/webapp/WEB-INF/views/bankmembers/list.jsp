
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member List Page</h1>
	<table>
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
</body>
</html>