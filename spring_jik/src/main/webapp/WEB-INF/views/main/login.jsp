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
		<form action="/spring/login" class="mt-3" method="post">
			<h1>로그인</h1>
			<div class="form-group">
			  <input type="text" class="form-control" name="me_id" placeholder="아이디">
			</div>
			<div class="form-group">
			  <input type="password" class="form-control" name="me_pw" placeholder="비밀번호">
			</div>
			<button class="btn btn-outline-success col-12 mb-3">전송</button>
		</form>	
		<a href="<c:url value="/find?type=id"></c:url>">아이디 찾기</a>/
		<a href="<c:url value="/find?type=pw"></c:url>">비번 찾기</a>
	</div>
</body>
</html>