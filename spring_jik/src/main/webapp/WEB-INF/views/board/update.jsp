<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<form method="post" class="mt-5">
			<h1>게시글 수정</h1>
			<div class="form-group">
			  <input type="text" class="form-control" name="bd_title" placeholder="제목" value="${board.bd_title }">
			</div>
			<div class="form-group">
			  <textarea class="form-control" rows="10" name="bd_content" placeholder="내용">${board.bd_content}</textarea>
			</div>
			<button class="btn btn-outline-primary col-12 mb-3">게시글 수정</button>
		</form>
	</div>
</body>
</html>