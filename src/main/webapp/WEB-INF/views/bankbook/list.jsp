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
      <!-- header import -->
      <c:import url="../template/header.jsp"></c:import>
      	<section class="container-fluid">
		<div class="row">
	<h1>BookList Page</h1>
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
			<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.bookNum}</td>
					<td><a href="detail?bookNum=${dto.bookNum}">${dto.bookName}</a></td>
					<td>${dto.bookRate}</td>
					<td>${dto.bookSale}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	</section>
</body>
</html>