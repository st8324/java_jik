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
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<style>
.error{
	color:red;
}
</style>

</head>
<body>
<div class="container">
	<form action="<%=request.getContextPath()%>/signup" method="post">
		<h1 class="text-center">회원가입</h1>
		<div class="form-group">
		  <label for="me_email">이메일:</label>
		  <input type="text" class="form-control" id="me_email" name="me_email">
		  <label id="me_email-error" class="error" for="me_email"></label>
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
		  <label for="me_birth">생년월일</label>
		  <input type="text" class="form-control" id="me_birth" name="me_birth">
		</div>
		<div class="form-group">
			<div class="input-group mb-3">
		    <input type="text" id="me_post_code" placeholder="우편번호" name="me_post_code" class="form-control">
				<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기" class="form-control ">
		  </div>
			<div class="input-group mb-3">
				<input type="text" id="me_addr" placeholder="주소" name="me_addr" class="form-control">
			</div>
			<div class="input-group mb-3">
				<input type="text" id="me_addr_detail" placeholder="상세주소" name="me_addr_detail" class="form-control">
			</div>
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
       me_pw: 	{	required : true       },
       me_pw2: 	{
         required : true,
         equalTo : me_pw
       },
       me_email: {
         required : true,
         email : true
       },
       me_birth: {  required : true     }
     },
     //규칙체크 실패시 출력될 메시지
     messages : {
       me_pw: {	  required : "필수항목입니다."      },
       me_pw2: {
     	  required : "필수항목입니다.",
         equalTo : "비밀번호와 비밀번호 확인이 일치하지 않습니다."
       },
       me_email: {
     	  required : "필수항목입니다.",
     	  email : "이메일 형식에 맞지 않습니다."
       },
       me_birth: { required : "필수항목입니다."      }
    },
    submitHandler: function(form) {
     	if(!idCheck){
				$('#me_email-error').text('이미 사용중인 이메일입니다.').show();
				$('#me_email').focus();
				return false;
			}  
     	return true;
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
	
$(function(){
	$('[name=me_email]').on('input',function(){
		idCheck = false;
		let me_email = $(this).val();
		console.log(me_email)
		if(me_email.length == 0)
			return;
		
		let obj = {
				me_email : me_email
		}
		ajaxPost(false, obj, '/check/email', function(data){
			idCheck = data.res;
		})
	})
})

let idCheck = false;

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
function execDaumPostcode() {
	new daum.Postcode({
		oncomplete: function(data) {
	
	    // 각 주소의 노출 규칙에 따라 주소를 조합한다.
	    // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	    var addr = ''; // 주소 변수
	
	    //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	    if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	        addr = data.roadAddress;
	    } else { // 사용자가 지번 주소를 선택했을 경우(J)
	        addr = data.jibunAddress;
	    }
	
	    // 우편번호와 주소 정보를 해당 필드에 넣는다.
	    document.getElementById('me_post_code').value = data.zonecode;
	    document.getElementById("me_addr").value = addr;
	    // 커서를 상세주소 필드로 이동한다.
	    document.getElementById("me_addr_detail").focus();
		}						
	}).open();
}
</script>
</body>
</html>