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
  <h2>회원 등급 관리</h2>
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>아이디</th>
        <th>등급</th>
      </tr>
    </thead>
    <tbody>
    	<c:forEach items="${list}" var="member">
	      <tr>
	        <td class="me_id">${member.me_id}</td>
	        <td class="form-group me_authority">
					  <select class="form-control">
					  	<c:forEach begin="1" end="${user.me_authority - 1 }" var="i">
						    <option <c:if test="${i == member.me_authority}">selected</c:if> >${i}</option>
					    </c:forEach>
					  </select>
					</td>
	      </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
<script type="text/javascript">
$(function(){
	$('.me_authority select').change(function(){
		let me_authority = $(this).val();
		let me_id = $(this).parent().siblings('.me_id').text();
		let obj = {
				me_id : me_id,
				me_authority : me_authority
		}
		$.ajax({
	    async: true,
	    type:'POST',
	    data: JSON.stringify(obj),
	    url: '<%=request.getContextPath()%>/admin/authority/update',
	    dataType:"json", 
	    contentType:"application/json; charset=UTF-8",
	    success : function(data){
	    	if(data.res)
	    		alert('회원 등급 변경이 완료됐습니다.')
	    	else
	    		alert('잘못된 접근입니다.')
	    	
	    }
	  });
	});
})
</script>
</body>
</html>