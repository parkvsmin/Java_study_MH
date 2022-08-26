<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<title>Insert title here</title>

</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<section class="container-fluid ">
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
	
	<div class="row">
		<img alt="" src="../resources/upload/member/${dto.bankMembersFileDTO.fileName}">
	</div>


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
	</section>
<c:import url="../template/footer.jsp"></c:import>	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>	
</body>
</html>