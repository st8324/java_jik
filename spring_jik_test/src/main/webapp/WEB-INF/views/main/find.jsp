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
  <br>
  <ul class="nav nav-tabs" role="tablist">
    <li class="nav-item">
      <a class="nav-link active" data-toggle="tab" href="#id">아이디 찾기</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-toggle="tab" href="#pw">비번찾기</a>
    </li>
  </ul>

  <!-- Tab panes -->
  <div class="tab-content">
    <div id="id" class="container tab-pane active"><br>
      <h3>아이디 찾기</h3>
			<div class="form-group">
				<input type="text" class="form-control me_email" placeholder="이메일을 입력하세요">
			</div>      
			<div class="form-group">
				<input type="text" class="form-control me_birth" placeholder="생일을 입력하세요(1990-01-01)">
			</div>
			<button class="btn btn-outline-success btn-find-id col-12">아이디 찾기</button>
    </div>
    <div id="pw" class="container tab-pane fade"><br>
      <h3>비번찾기</h3>
			<div class="form-group">
				<input type="text" class="form-control me_email" placeholder="이메일을 입력하세요">
			</div>      
			<div class="form-group">
				<input type="text" class="form-control me_birth" placeholder="생일을 입력하세요(1990-01-01)">
			</div>
			<button class="btn btn-outline-success btn-find-pw col-12">비밀번호 찾기</button>
    </div>
  </div>
</div>
<script type="text/javascript">
	$(function(){
		$('[href="#${type}"').click();
		
		$('.btn-find-id').click(function(){
			let me_email = $('#id .me_email').val();
			let me_birth = $('#id .me_birth').val();
			
			if(me_email.trim() == ''){
				alert('이메일을 입력하세요.');
				$('#id .me_email').focus();
				return;
			}
			let birthRegex = /^\d{4}-\d{2}-\d{2}$/
			if(!birthRegex.test(me_birth)){
				alert('생일을 올바르게 입력하세요.');
				$('#id .me_birth').focus();
				return;
			}
			let obj = {
					me_email : me_email,
					me_birth : me_birth
			}
			ajaxPost(false, obj, '/ajax/find/id', function(data){
				if(data.id == null){
					alert('일치하는 아이디가 없습니다.')
				}else{
					alert('회원님의 아이디는 아래와 같습니다.\n'+data.id)
				}
			})
		})
		
		$('.btn-find-pw').click(function(){
			let me_email = $('#pw .me_email').val();
			let me_birth = $('#pw .me_birth').val();
			
			if(me_email.trim() == ''){
				alert('이메일을 입력하세요.');
				$('#pw .me_email').focus();
				return;
			}
			let birthRegex = /^\d{4}-\d{2}-\d{2}$/
			if(!birthRegex.test(me_birth)){
				alert('생일을 올바르게 입력하세요.');
				$('#pw .me_birth').focus();
				return;
			}
			let obj = {
					me_email : me_email,
					me_birth : me_birth
			}

			ajaxPost(false, obj, '/ajax/find/pw', function(data){
				if(data.res){
					alert('입력한 이메일로 새 비밀번호를 발송했습니다.')
				}else{
					alert('없는 정보입니다.')
				}
			})
		})
	})
	
	function ajaxPost(async, dataObj, url, success){
		$.ajax({
      async:async,
      type:'POST',
      data:JSON.stringify(dataObj),
      url:"<%=request.getContextPath()%>"+url,
      dataType:"json",
      contentType:"application/json; charset=UTF-8",
      success : function(data){
    	  success(data);
      }
	  });
	}
</script>
</body>
</html>