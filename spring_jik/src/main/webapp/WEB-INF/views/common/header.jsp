<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
	<div class="container">
	  	<a class="navbar-brand" href="<%=request.getContextPath()%>/">Home</a>
	  	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
	    	<span class="navbar-toggler-icon"></span>
	  	</button>
	  	<div class="collapse navbar-collapse" id="collapsibleNavbar">
	    	<ul class="navbar-nav">
	    		<c:if test="${user == null }">
		      	<li class="nav-item">
		        	<a class="nav-link" href="<%=request.getContextPath()%>/login">로그인</a>
		      	</li>
		      	<li class="nav-item">
		        	<a class="nav-link" href="<%=request.getContextPath()%>/signup">회원가입</a>
		      	</li>
		      </c:if>
		      <c:if test="${user != null }">
		      	<li class="nav-item">
		        	<a class="nav-link" href="<%=request.getContextPath()%>/logout">로그아웃</a>
		      	</li> 
	      	</c:if>  
	      	<li class="nav-item">
	        	<a class="nav-link" href="<%=request.getContextPath()%>/board/list">게시글</a>
	      	</li>  
	    	</ul>
		</div> 
   	<c:if test="${user != null }">
   		<a href="javascript:0;" class="float-right" style="color:#fff;">${user.me_id}님 환영합니다.</a>
   	</c:if>
	</div> 
</nav>