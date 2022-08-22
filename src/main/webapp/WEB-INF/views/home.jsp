<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<h3>Hello</h3>

	<P>The time on the server is ${serverTime}.</P>

	<c:if test="${empty sessionScope.bankmembers}">
		<a href="./bankmembers/login">Login</a>
		<a href="./bankmembers/join">Join</a>
	</c:if>
	<c:if test="${not empty sessionScope.bankmembers}">
		<a href="./bankmembers/logout">Logout</a>
		<a href="#">MyPage</a>
	</c:if>

	<a href="./bankmembers/search">Search</a>
	<a href="./bankbook/list">BookList</a>
	<a href="./bankbook/add">Add</a>
	<!--  <a href="./bankmembers/myPage">MyPage</a> -->
</body>
</html>