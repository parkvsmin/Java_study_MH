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
      
	<h1>Search Page</h1>
	<form class="row g-3" action="./search" method="post">
  <div class="col-auto">
    <label for="search" class="visually-hidden">Search</label>
    <input type="text" class="form-control" id="search">
  </div>
  <div class="col-auto">
    <label for="search" class="visually-hidden">Search</label>
    <input type="text" class="form-control" id="search" placeholder="Search">
  </div>
  <div class="col-auto">
    <button type="submit" class="btn btn-primary mb-3">검색</button>
  </div>
</form>
</div>
</section>

 <!--        <input type="text" name="search">
        <button type="submit">Search</button> -->
     <c:import url="../template/footer.jsp"></c:import>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>