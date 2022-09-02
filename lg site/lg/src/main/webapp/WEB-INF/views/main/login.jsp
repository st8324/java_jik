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
		<form method="post">
			<h1>로그인</h1>
			<div class="form-group">
			  <label for="me_email">이메일:</label>
			  <input type="text" class="form-control" id="me_email" name="me_email">
			</div>
			<div class="form-group">
			  <label for="me_pw">비밀번호:</label>
			  <input type="password" class="form-control" id="me_pw" name="me_pw">
			</div>
			<div class="form-check">
			  <label class="form-check-label">
			    <input type="checkbox" class="form-check-input" value="true" name="autoLogin">자동로그인
			  </label>
			</div>
			<button class="btn btn-outline-success col-12">로그인</button>
		</form>
		<a href="<c:url value="/find?type=id"></c:url>">아이디 찾기</a>/
		<a href="<c:url value="/find?type=pw"></c:url>">비밀번호 찾기</a>
	</div>
</body>
</html>