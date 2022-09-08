<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
<style>
.btn-del{
	padding : 0; border: none; background-color: transparent; color : #ffc107;
}
form.btn:hover .btn-del{
	color : #fff;
}
form.btn{
	margin-bottom: 0;
}
</style>
</head>
<body>
<div class="container">
	<h2>게시글 상세</h2>
	<div class="form-group">
	  <input type="text" class="form-control" value="${bo.bd_title}">
	</div>
	<div class="form-group">
	  <div class="form-control" style="height:auto; min-height: 300px">${bo.bd_content }</div>
	</div>
	<c:if test="${user.me_email == bo.bd_me_email && bo.bd_type != 'NOTICE' }">
		<a href="<c:url value="/board/update?bd_num=${bo.bd_num}"></c:url>" class="btn btn-outline-warning">수정</a>
		<form class="btn btn-outline-warning" action="<c:url value="/board/delete"></c:url>"  method="post">
   		<button class="btn-del">삭제</button>
   		<input type="hidden" name="bd_num" value="${bo.bd_num}">
   		<input type="hidden" name="bd_type" value="${bo.bd_type}">
   	</form>
	</c:if>
</div>
</body>
</html>