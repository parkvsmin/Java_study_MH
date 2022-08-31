<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<h1>Login Page</h1>


	<c:import url="../template/header.jsp"></c:import>


	<section class="container-fluid ">
		<div class="row">
			<form action="./login" method="post" id="frm">
				<div class="mb-3">
					<label for="userName" class="form-label">ID</label> <input
						type="text" value="id1" name="userName" class="form-control"
						id="userName" aria-describedby="emailHelp">
					<div id="emailHelp" class="form-text">We'll never share your
						email with anyone else.</div>
				</div>
				<div class="mb-3">
					<label for="password" class="form-label">Password</label>
					<input type="password" value="pw1" name="password" class="form-control"
						id="password">
				</div>
				<div class="mb-3 form-check">
					<input type="checkbox" class="form-check-input" id="exampleCheck1">
					<label class="form-check-label" for="exampleCheck1">Check
						me out</label>
				</div>
				<button type="button" class="btn btn-primary" id="btn">Submit</button>
			</form>


		</div>
	</section>

	<c:import url="../template/footer.jsp"></c:import>
	<script src="/resources/js/member.js"></script>
	<script>
		loginCheck();
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>
</body>
</html>