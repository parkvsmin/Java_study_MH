<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Book Detail Page</h1>
	
	<table border="1">
		<thead>
			<tr>
				<th>BookNum</th>
				<th>BookName</th>
				<th>BookRate</th>
				<th>BookSale</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${detail.bookNum}</td>
				<td>${detail.bookName}</td>
				<td>${detail.bookRate}</td>
				<td>${detail.bookSale}</td>
			</tr>
		</tbody>
	</table>
	
	<a href="update?bookNum=${detail.bookNum}">수정</a>
	<a href="delete?bookNum=${detail.bookNum}">삭제</a>
</body>
</html>