<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<section class="container-fluid">
		<div class="row">
			<h1>${board}ListPage</h1>

			<table border="1">
				<thead>
					<tr>
						<th>num</th>
						<th>title</th>
						<th>writer</th>
						<th>regDate</th>
						<th>hit</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="dto">
						<tr>
							<td><a href="./detail?num=${dto.num}">${dto.title}</a></td>
							<td>${dto.title}</td>
							<td>${dto.writer}</td>
							<td>${dto.regDate}</td>
							<td>${dto.hit}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<nav aria-label="Page navigation example">
				<ul class="pagination">
					<c:if test="${pager.pre}">
						<li class="page-item"><a class="page-link"
							href="./list?page=${pager.startNum-1}">Previous</a></li>
					</c:if>
					<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
						<li class="page-item"><a class="page-link"
							href="./list?page=${i}">${i}</a></li>
					</c:forEach>
					
<%-- 					<c:choose>
						<c:when test="${pager.next}">
							<li class="page-item">
						</c:when>
						<otherwise>
							<li class="page-item disabled">
						</otherwise>
					</c:choose> --%>
					
					<li class="page-item ${pager.next?'':'disabled'}"><a class="page-link"
						href="./list?page=${pager.lastNum+1}">Next</a></li>
				</ul>
			</nav>
			<div class="mb-3">
				<a href="./add" class="btn btn-primary">글쓰기</a>
			</div>
		</div>
	</section>
	<c:import url="../template/footer.jsp"></c:import>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>

</body>
</html>