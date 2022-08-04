<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/additional-methods.min.js"></script>
<style>
.error{
	color:red;
}
</style>

</head>
<body>
${user}
	<div class="container">
		<form action="<%=request.getContextPath()%>/signup" method="post">
			<h1 class="text-center">회원가입</h1>
			<div class="form-group">
			  <label for="me_id">아이디:</label>
			  <input type="text" class="form-control" id="me_id" name="me_id">
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
			  <label>성별:</label>
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
				<div>
					<label class="error" id="me_gender-error" for="me_gender"></label>
				</div>
			</div>
			<div class="form-group">
			  <label for="me_email">이메일</label>
			  <input type="text" class="form-control" id="me_email" name="me_email">
			</div>
			<div class="form-group">
			  <label for="me_birth">생년월일</label>
			  <input type="text" class="form-control" id="me_birth" name="me_birth">
			</div>
			<button class="btn btn-outline-success col-12 mb-5">회원가입</button>
		</form>
	</div>
	
	<script type="text/javascript">
		$(function(){
			$( "#me_birth" ).datepicker({
	      changeMonth: true,
	      changeYear: true,
	      dateFormat: 'yy-mm-dd',
	      yearRange: "1900:2022"
			});
		})
		
		$(function(){
    	$("form").validate({
        rules: {
          me_id: {
            required : true
          },
          me_pw: {
            required : true
          },
          me_pw2: {
            required : true,
            equalTo : me_pw
          },
          me_gender: {
            required : true
          },
          me_email: {
            required : true,
            email : true
          },
          me_birth: {
            required : true
          }
        },
        //규칙체크 실패시 출력될 메시지
        messages : {
          me_id: {
            required : "필수항목입니다."
          },
          me_pw: {
        	  required : "필수항목입니다."
          },
          me_pw2: {
        	  required : "필수항목입니다.",
            equalTo : "비밀번호와 비밀번호 확인이 일치하지 않습니다."
          },
          me_gender: {
        	  required : "필수항목입니다."
          },
          me_email: {
        	  required : "필수항목입니다.",
        	  email : "이메일 형식에 맞지 않습니다."
          },
          me_birth: {
        	  required : "필수항목입니다."
          }
        }
    	});
		})
		$.validator.addMethod(
	    "regex",
	    function(value, element, regexp) {
	        var re = new RegExp(regexp);
	        return this.optional(element) || re.test(value);
	    },
	    "Please check your input."
		);
	</script>
</body>
</html>