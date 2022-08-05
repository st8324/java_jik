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
		<c:if test="${board != null && 'N'.charAt(0) ==board.bd_del }">
			<h1>게시글 상세</h1>
			<div class="form-group">
			  <input type="text" class="form-control" name="bd_title" value="${board.bd_title }" readonly>
			</div>
			<div class="form-group">
			  <input type="text" class="form-control" name="bd_me_id" value="${board.bd_me_id }" readonly>
			</div>
			<div class="form-group">
			  <input type="text" class="form-control" name="bd_reg_date" value="${board.bd_reg_date_time_str}" readonly>
			</div>
			<div class="form-group">
			  <input type="text" class="form-control" name="bd_views" value="${board.bd_views}" readonly>
			</div>
			<div class="form-group">
			  <textarea class="form-control" rows="10" name="bd_content" readonly>${board.bd_content}</textarea>
			</div>
			<c:if test="${user != null && user.me_id == board.bd_me_id }">
				<a href="<%=request.getContextPath()%>/board/update/${board.bd_num}" class="btn btn-outline-danger">수정</a>
				<a href="<%=request.getContextPath()%>/board/delete/${board.bd_num}" class="btn btn-outline-danger">삭제</a>
			</c:if>
		</c:if>
		<c:if test="${board != null && 'A'.charAt(0) ==board.bd_del }">
			<h1>관리자에 의해 삭제된 게시글입니다.</h1>
		</c:if>
		<c:if test="${board != null && 'Y'.charAt(0) ==board.bd_del }">
			<h1>작성자에 의해 삭제된 게시글입니다.</h1>
		</c:if>
		<c:if test="${board == null}">
			<h1>잘못된 경로로 접근했습니다.</h1>
		</c:if>
	</div>
</body>
</html>