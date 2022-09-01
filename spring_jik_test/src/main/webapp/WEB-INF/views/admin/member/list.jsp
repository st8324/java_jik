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
  <table class="table table-hover">
    <thead>
      <tr>
        <th>아이디</th>
        <th>등급</th>
      </tr>
    </thead>
    <tbody>
    	<c:forEach items="${list}" var="m">
	      <tr>
	        <td class="me_id">${m.me_id }</td>
	        <td class="form-group">
		        <select class="form-control me_authority">
		        	<c:forEach begin="1" end="${user.me_authority - 1}" var="i">
					    	<option <c:if test="${m.me_authority == i }">selected</c:if>>${i}</option>
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
	$('.me_authority').change(function(){
		let me_authority = $(this).val();
		let me_id = $(this).parents('tr').find('.me_id').text();
		let obj = {
				me_id : me_id,
				me_authority : me_authority
		}
		ajaxPost(false, obj, '/admin/user/update', function(data){
			if(data.res){
				alert('회원 등급을 변경했습니다.')
			}else{
				alert('잘못 접근했습니다.')
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