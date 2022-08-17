<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Book Add Page</h1>
	
	<form action="add" method="post">
		Name <input type="text" name="bookName">
		Rate <input type="text" name="bookRate">
	
		<button type="submit">추가</button>
	</form>
</body>
</html>