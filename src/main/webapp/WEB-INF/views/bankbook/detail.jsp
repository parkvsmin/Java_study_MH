<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<h1>Book Detail Page</h1>
	
	<c:import url="../template/header.jsp"></c:import>
	
	<section class="container-fluid">
		<div class="row">
	
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
	</div>
	</section>
	<a href = "./list" class="btn btn-info">상품 목록 보기</a>
	<a href="update?bookNum=${detail.bookNum}" class="btn btn-primary">수정</a>
	<a href="delete?bookNum=${detail.bookNum}" class="btn btn-danger">삭제</a>

	<!-- comment -->
	<div class="row">
		<div class="mb-3">
			<label for="writer" class="form-label">USERNAME</label>
			<input type="text" class="form-control" id="writer" placeholder="Enter USERNAME">
		  </div>

		  <div class="mb-3">
			<label for="contents" class="form-label">WRITE CONTENTS</label>
			<textarea class="form-control" id="contents" rows="3"></textarea>
		  </div>

		  <div class="mb-3">
			<button type="button" id="b1" data-booknum="${detail.bookNum}">댓글작성</button>
		  </div>

		  <!-- comment List 출력 -->
		  <div id="commentList">
			
		  </div>

	</div>
	<!-- comment -->
	<c:import url="../template/footer.jsp"></c:import>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<script src="/resources/js/bankbookComment.js"></script>
</body>
</html>