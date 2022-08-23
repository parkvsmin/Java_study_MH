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
	<h1>Update Page</h1>
	
		<form action="update.iu" method="post">
		Title <input type="text" name="title">
		Contents <input type="text" name="contents">
		Num <input type="hidden" name="num" value="${num}">
		<button type="submit">업데이트</button>
	</form>

</body>
</html>