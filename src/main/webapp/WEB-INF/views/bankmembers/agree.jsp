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
	<h2>약관 동의 페이지</h2>

    <div>
        전체동의<input type="checkbox" name="" id="all">
        동의1(필수)<input type="checkbox" name="" id="" class="cb req">
        동의2(필수)<input type="checkbox" name="" id="" class="cb req">
        동의3(선택)<input type="checkbox" name="" id="" class="cb">
    </div>
	
	<form action="./join" id="frm">
		<button type="button" id="join">회원가입</button>
	</form>
	
<c:import url="../template/header.jsp"></c:import>

<!-- <div class="agreement-container">
	<div class="agreement-allcheck">
    	<input type="checkbox" id="allcheck" class="input-text">
        <label for="allcheck">전체동의</label>
    </div>
    
    <div class="check-group">
    	<input type="checkbox" id="check_01" class="input-text">
        <label for="check_01">선택1</label>
    </div>
     <div class="check-group">
    	<input type="checkbox" id="check_02" class="input-text">
        <label for="check_02">선택2</label>
    </div>
     <div class="check-group">
    	<input type="checkbox" id="check_03" class="input-text">
        <label for="check_03">선택3</label>
    </div>    
</div> -->

<c:import url="../template/footer.jsp"></c:import>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>
        <script src="/resources/js/member.js"></script>
        <script>
         check();
        </script>
</body>
</html>