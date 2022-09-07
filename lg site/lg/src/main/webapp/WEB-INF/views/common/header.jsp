<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>    
<head>
<script src="https://kit.fontawesome.com/b1e3c8f87d.js" crossorigin="anonymous"></script>
<style>
.home{
	background-image: url(<%=request.getContextPath()%>/resources/img/logo.svg);
	width: 100px; height: 29px; display: block; background-size: 100% 100%
}
.member .dropdown-toggle::after{
	display: none;
}
.fa-regular{
	line-height: 1.5;
}
</style>
</head>    
<body>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
	<div class="container" style="position: relative;">
  	<a class="navbar-brand home" href="<c:url value="/"></c:url>"></a>
  	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    	<span class="navbar-toggler-icon"></span>
  	</button>
  	<div class="collapse navbar-collapse" id="collapsibleNavbar">
    	<ul class="navbar-nav category">
      	<li class="nav-item dropdown member" style="position:absolute; right: 0">
			    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"><i class="fa-regular fa-user"></i></a>
			    <div class="dropdown-menu">
			    	<c:if test="${user == null }">
				      <a class="dropdown-item" href="<c:url value="/signup"></c:url>">회원가입</a>
				      <a class="dropdown-item" href="<c:url value="/login"></c:url>">로그인</a>
			      </c:if>
			      <c:if test="${user != null }">
			      	<a class="dropdown-item" href="<c:url value="/likes/list"></c:url>">찜 목록</a>
				      <a class="dropdown-item" href="<c:url value="/mypage"></c:url>">회원정보수정</a>
				      <a class="dropdown-item" href="<c:url value="/logout"></c:url>">로그아웃</a>
			      </c:if>
			    </div>
			  </li>
			  <c:if test="${user.me_authority == 10 }">
	      	<li class="nav-item">
	        	<a class="nav-link" href="<c:url value="/admin"></c:url>">관리자</a>
	      	</li>
      	</c:if>
      	<c:if test="${user.me_authority != 10 }">
	      	<li class="nav-item">
	        	<a class="nav-link" href="<c:url value="/board/list?bd_type=NOTICE"></c:url>">공지사항</a>
	      	</li>
      	</c:if>
    	</ul>
		</div> 
	</div> 
</nav>
<script type="text/javascript">
$(function(){
	ajaxPost(false, null, '/category/list', function(data){
		if('${user.me_authority}' == 10){
			return;
		}
		let str = ''; 
		for(c of data.list){
			str += '<li class="nav-item">';
      str += 	'<a class="nav-link" href="<%=request.getContextPath()%>/product/list?ca_name='+c.ca_name+'">'+c.ca_name+'</a>';
     	str += '</li>' 
		}
		$('.category').prepend(str);
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