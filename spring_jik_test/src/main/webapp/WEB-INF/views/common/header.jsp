<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
	<div class="container">
	 	<a class="navbar-brand" href="<c:url value="/"></c:url>">HOME</a>
  	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    	<span class="navbar-toggler-icon"></span>
  	</button>
  	<div class="collapse navbar-collapse" id="collapsibleNavbar">
    	<ul class="navbar-nav">
    		<c:if test="${user == null}">
	      	<li class="nav-item">
	        	<a class="nav-link" href="<c:url value="/signup"></c:url>">회원가입</a>
	      	</li>
	      	<li class="nav-item">
	        	<a class="nav-link" href="<c:url value="/login"></c:url>">로그인</a>
	      	</li>
      	</c:if>
      	<c:if test="${user != null }">
	      	<li class="nav-item">
	        	<a class="nav-link" href="<c:url value="/logout"></c:url>">로그아웃</a>
	      	</li> 
      	</c:if>   
      	<li class="nav-item">
        	<a class="nav-link" href="<c:url value="/board/list"></c:url>">게시글</a>
      	</li> 
    	</ul>
		</div> 
	</div> 
</nav>