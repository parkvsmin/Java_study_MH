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
	<h1>Join Page</h1>
  <div class="mb-3">
    <label for="exampleInputId1" class="form-label">Id</label>
    <input type="text" class="form-control" id="exampleInputId1" aria-describedby="idHelp">
  </div>
  
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1">
  </div>
  
    <div class="mb-3">
    <label for="exampleInputName1" class="form-label">Name</label>
    <input type="text" class="form-control" id="exampleInputName1" aria-describedby="nameHelp">
  </div>
  
    <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Email address</label>
    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
  </div>
  
  <div class="mb-3">
    <label for="exampleInputPhone1" class="form-label">Phone</label>
    <input type="number" class="form-control" id="exampleInputPhone1">
  </div>
  <input class="btn btn-primary" type="submit" value="Submit">
  </div>
  </section>
<c:import url="../template/footer.jsp"></c:import>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
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