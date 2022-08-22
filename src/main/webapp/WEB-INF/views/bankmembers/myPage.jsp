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

	<h1>My Page</h1>
	<p>ID : ${requestScope.dto.userName}</p>
	<p>NAME : ${dto.name}</p>
	<p>EMAIL : ${dto.email}</p>
	<p>PHONE : ${dto.phone}</p>

	<c:forEach items="${dto.bankAccountDTOs}" var="dto">
		<p>${pageScope.dto.accountNum}</p>
		<p>${dto.bankBookDTO.bookName}</p>
		<p>${dto.accountDate}</p>

	</c:forEach>


	<%-- 		<h1>${map}</h1>
	<p>ID : ${map.dtp.userName}</p>
	<p>NAME : ${map.dtp.name}</p>
	<p>EMAIL : ${map.dtp.email}</p>
	<p>PHONE : ${map.dtp.phone}</p>
	
	<c:forEach items="${map.list}" var="dto">
		<p>${dto.accountNum}</p>
		<p>${dto.bankBookDTO.bookName}</p>
		<p>${dto.accountDate}</p>
		
	</c:forEach> --%>


</body>
</html>