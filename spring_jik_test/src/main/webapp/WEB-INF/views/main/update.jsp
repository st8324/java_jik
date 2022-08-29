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
			<h1>회원 정보 수정</h1>
			<div class="form-group">
			  <label for="me_id">아이디:</label>
			  <input type="text" class="form-control" id="me_id" name="me_id" readonly value="${user.me_id}">
			</div>
			<div class="form-group">
			  <label for="me_pw">비밀번호:</label>
			  <input type="password" class="form-control" id="me_pw" name="me_pw">
			</div>
			<div class="form-group">
			  <label for="me_pw2">비밀번호 확인:</label>
			  <input type="password" class="form-control" id="me_pw2" name="me_pw2">
			</div>
			<div class="form-group">
			  <label for="me_email">이메일:</label>
			  <input type="text" class="form-control" id="me_email" name="me_email" value="${user.me_email}">
			</div>
			<div class="form-group">
			  <label for="me_birth">생일:</label>
			  <input type="text" class="form-control" id="me_birth" name="me_birth" value="${user.me_birth_str}">
			</div>
			<div class="form-group">
				<div class="form-check-inline">
				  <label class="form-check-label">
				    <input type="radio" class="form-check-input" name="me_gender" value="M"<c:if test="${user.me_gender == 'M' }"> checked</c:if> >남성
				  </label>
				</div>
				<div class="form-check-inline">
				  <label class="form-check-label">
				    <input type="radio" class="form-check-input" name="me_gender" value="F"<c:if test="${user.me_gender == 'F' }"> checked</c:if>>여성
				  </label>
				</div>
			</div>
			<button class="btn btn-outline-success col-12">회원정보수정</button>
		</form>
	</div>
	<script type="text/javascript">
	$(function(){
		$('form').submit(function(){
			let pw = $('[name=me_pw]').val();
			if(pw.trim() == ''){
				if(!confirm('기존 비밀번호로 유지하겠습니까?')){
					return false;
				}
			}
			let pw2 = $('[name=me_pw2]').val();
			if(pw != pw2){
				alert('비밀번호와 비밀번호 확인이 다릅니다.');
				return false;
			}
			return true;
		})	
	})
	</script>
</body>
</html>