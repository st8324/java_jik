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
		<form method="post">
			<h1>회원가입</h1>
			<div class="form-group">
			  <label for="me_id">아이디:</label>
			  <input type="text" class="form-control" id="me_id" name="me_id">
			</div>
			<button class="btn btn-outline-success col-12" type="button" id="idCheck">아이디 중복 확인</button>
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
			  <input type="text" class="form-control" id="me_email" name="me_email">
			</div>
			<div class="form-group">
			  <label for="me_birth">생일:</label>
			  <input type="text" class="form-control" id="me_birth" name="me_birth">
			</div>
			<div class="form-group">
				<div class="form-check-inline">
				  <label class="form-check-label">
				    <input type="radio" class="form-check-input" name="me_gender" value="M">남성
				  </label>
				</div>
				<div class="form-check-inline">
				  <label class="form-check-label">
				    <input type="radio" class="form-check-input" name="me_gender" value="F">여성
				  </label>
				</div>
			</div>
			<button class="btn btn-outline-success col-12">회원가입</button>
		</form>
	</div>
	<script type="text/javascript">
	let idCheck = false;
	
	$(function(){
		$('#idCheck').click(function(){
			let me_id = $('[name=me_id]').val();
			if(me_id.trim().length == 0){
				alert('아이디를 입력하세요.')
				return;
			}
			
			let obj = {
					me_id : me_id
			}
			
			$.ajax({
	      async:false,
	      type:'POST',
	      data:JSON.stringify(obj),
	      url:"<%=request.getContextPath()%>/id/check",
	      dataType:"json",
	      contentType:"application/json; charset=UTF-8",
	      success : function(data){
	    	  //data.check
	    	  //data['check']
          if(data.check){
        	  alert('사용 가능한 아이디입니다.')
        	  idCheck = true;
          }else{
        	  alert('이미 사용중인 아이디입니다.')
          }
	      }
		  });
		});
		
		$('[name=me_id]').change(function(){
			idCheck = false;
		})
		$('form').submit(function(){
			if(idCheck)
				return true;
			
			alert('아이디 중복검사를 확인하세요.')
			return false;
		})	
	})
	</script>
</body>
</html>