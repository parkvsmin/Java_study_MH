<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<c:if test="${empty sessionScope.member}">
	<a href="./member/login">Login</a>
	<a href="./member/join">Join</a>
	</c:if>
	<c:if test="${empty sessionScope.member}">
	<a href="./member/logout">Logout</a>
	</c:if>
	
	<a href="./member/search">Search</a>
	<a href="./bankbook/list">BookList</a>
</body>
</html>