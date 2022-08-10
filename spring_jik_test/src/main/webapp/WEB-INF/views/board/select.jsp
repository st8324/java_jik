<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<c:if test="${board.bd_del == 'N' }">
			<h1>게시글 상세</h1>
			<div class="form-group">
			  <label for="">제목:</label>
			  <input type="text" class="form-control" readonly value="${board.bd_title }">
			</div>
			<div class="form-group">
			  <label for="">작성자:</label>
			  <input type="text" class="form-control" readonly value="${board.bd_me_id}">
			</div>
			<div class="form-group">
			  <label for="">작성일:</label>
			  <input type="text" class="form-control" readonly value="${board.bd_reg_date_time_str }">
			</div>
			<div class="form-group">
			  <label for="">최종수정일:</label>
			  <input type="text" class="form-control" readonly value="${board.bd_up_date_time_str}">
			</div>
			<div class="form-group">
			  <label for="">조회수:</label>
			  <input type="text" class="form-control" readonly value="${board.bd_views}">
			</div>
			<div class="form-group">
			  <label for="">내용:</label>
			  <textarea class="form-control" rows="10" readonly>${board.bd_content}</textarea>
			</div>
			<c:if test="${board.bd_me_id == user.me_id }">
				<a href="<c:url value="/board/update/${board.bd_num}"></c:url>" class="btn btn-outline-success">수정</a>
				<a href="<c:url value="/board/delete/${board.bd_num}"></c:url>" class="btn btn-outline-success">삭제</a>
			</c:if>
		</c:if>
		<c:if test="${board.bd_del =='Y' }">
			<h1>작성자에 의해 삭제된 게시글입니다.</h1>
		</c:if>
		<c:if test="${board.bd_del =='A' }">
			<h1>관리자에 의해 삭제된 게시글입니다.</h1>
		</c:if>
	</div>
</body>
</html>