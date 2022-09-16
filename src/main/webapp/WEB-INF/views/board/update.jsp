<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<script type="text/javascript" src="//code.jquery.com/jquery-3.6.0.min.js"></script>
<title>Insert title here</title>
<!-- include summernote css/js-->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<body>
	<h1>${board}Update Page</h1>
	
		<c:import url="../template/header.jsp"></c:import>
	
<section class="container-fluid col-lg-4">
	
	<div class="row">
		<form action="./update" method="post" enctype="multipart/form-data">
			<input type="hidden" name="num" value="${boardDTO.num}" >
			<div class="mb-3">
			  <label for="title" class="form-label">Title</label>
			  <input type="text" name="title" value="${boardDTO.title}" class="form-control" id="title" placeholder="제목 입력">
			</div>
			<div class="mb-3">
			  <label for="writer" class="form-label">Writer</label>
			  <input type="text" name="writer" value="${boardDTO.writer}"  class="form-control" id="Writer" placeholder="작성자 입력">
			</div>
			<div class="mb-3">
			  <label for="contents" class="form-label">Contents</label>
			  <textarea class="form-control" name="contents" id="contents" rows="3">${boardDTO.contents}</textarea>
			</div>
			
			<c:forEach items="${boardDTO.boardFileDTOs}" var="fileDTO">
            <div class="mb-3">
               <span class="form-control">${fileDTO.oriName}</span>
               <button type="button" class="fileDelete" data-file-num="${fileDTO.fileNum}">삭제</button>
               </div>
         </c:forEach>

		 <div id="addFiles">
			<button type="button" id="fileAdd">파일추가</button>
		</div>
			  
			</div>
			
			<div class="mb-3">
				<button class="btn btn-success">제출</button>
			</div>
			
		</form>
	</div>
</section>
	<c:import url="../template/footer.jsp"></c:import>

<script src="/resources/js/add.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>

<script>
	setCount(${boardDTO.boardFileDTOs.size()});
	$("#contents").summernote();
</script>

</body>
</html>