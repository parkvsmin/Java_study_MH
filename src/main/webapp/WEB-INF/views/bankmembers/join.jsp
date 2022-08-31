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
	<!-- header import -->
	<c:import url="../template/header.jsp"></c:import>
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-6">
				<h1 class="text-center">Join page</h1>
			</div>
		</div>

		<div class="row mb-3">
			<div class="col-lg-6">
				<form action="./join" id="joinForm" method="post" enctype="multipart/form-data">
					<div class="row">
						<label for="inputUserName" class="col-sm-2 col-form-label">ID</label>
						<div class="col">
							<input type="text" name="userName" class="form-control"
								id="userName" placeholder="ID 입력">
								<div id="userNameResult"></div>
						</div>
					</div>
					<div class="row mb-3">
						<label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
						<div class="col-sm-10">
							<input type="password" name="passWord" class="form-control"
								id="passWord" placeholder="Password 입력">
								<div id="passwordResult"></div>
						</div>
					</div>
					<div class="row mb-3">
						<label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
						<div class="col-sm-10">
							<input type="password" name="passwordCheck" class="form-control"
								id="passwordCheck" placeholder="Password 입력">
								<div id="pwResult"></div>
						</div>
					</div>
					<div class="row mb-3">
						<label for="inputName" class="col-sm-2 col-form-label">Name</label>
						<div class="col-sm-10">
							<input type="text" name="name" class="form-control"
								id="name" placeholder="이름 입력">
								<div id="nameResult"></div>
						</div>
					</div>

					<div class="row mb-3">
						<label for="inputEmail" class="col-sm-2 col-form-label">Email</label>
						<div class="col-sm-10">
							<input type="email" required name="email" class="form-control"
								id="email" placeholder="Email 입력">
								<div id="emailResult"></div>
						</div>
					</div>

					<div class="row mb-3">
						<label for="inputPhone" class="col-sm-2 col-form-label">Phone</label>
						<div class="col-sm-10">
							<input type="text" name="phone" class="form-control"
								id="phone" placeholder="전화번호 입력">
								<div id="phoneResult"></div>
						</div>
					</div>

					<div class="row mb-3">
						<label for="files" class="col-sm-2 col-form-label">Photo</label> <input
							type="file" name="photo" class="form-control" id="files"
							placeholder="파일 입력">
					</div>
					<input class="btn btn-primary" type="submit" value="Submit">
				</form>
			</div>
			<div class="row justify-content-end">
				<div>
					<button type="button" id="joinButton" class="btn btn-primary mb-3">Sign in</button>
				</div>

			</div>
		</div>
	</div>
	<c:import url="../template/footer.jsp"></c:import>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>
		<script src="/resources/js/member.js"></script>
		<script>
			joinCheck();
		</script>

</body>
</html>

<!-- 	<form action="join" method="post">
		<h3>아이디</h3>
		<input type="text" name="userName">
		<h3>비밀번호</h3>
		<input type="text" name="password">
		<h3>이름</h3>
		<input type="text" name="name">
		<h3>이메일</h3>
		<input type="email" name="email">
		<h3>휴대전화</h3>
		<input type="number" name="phone">
		<div>
			<input type="submit" value="가입하기">
		</div>
	</form> -->