<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.product-box{
	height: 300px; border-radius: 16px; box-shadow: 2px 4px 16px 0 rgba(0,0,0,0.14);
	margin-bottom: 20px; padding: 20px; display: block;
}
.product-box>.float-right{
	width : calc(100% - 200px - 100px); height: 200px;
	padding-top: 30px; box-sizing: border-box;
}
.btn-more{
	border-radius: 16px; box-shadow: 2px 4px 16px 0 rgba(0,0,0,0.14);
}
</style>
</head>
<body>
<div class="container product-container">
  <h2>찜한 목록</h2>
  <c:forEach items="${list }" var="p">
	  <a class="product-box clearfix" href="<c:url value="/product/select?pr_code=${p.pr_code}"></c:url>">
	  	<div class="float-left">
	  		<img src="<c:url value="${p.pr_thumb_url }"></c:url>" width="200" height="200">
	  	</div>
	  	<div class="float-right">
	  		<h3 class="pr_title">${p.pr_title }</h3>
	  		<h4 class="pr_code">${p.pr_code }</h4>
	  		<h4 class="pr_price">${p.pr_price_str }</h4>
	  		</div>
	  	<hr class="float-left w-100">
	  </a>
  </c:forEach>
  <c:if test="${list.size() == 0}">
  	<h3>찜한 제품이 없습니다.</h3>
  </c:if>
</div>

</body>
</html>