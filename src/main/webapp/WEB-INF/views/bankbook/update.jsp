<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Book Update Page</h1>
	
	<form action="update" method="post">
		Name <input type="text" name="bookName">
		Rate <input type="text" name="bookRate">
		<input type="hidden" name="bookNum" value="${num}">
		<button type="submit">추가</button>
	</form>
</body>
</html>