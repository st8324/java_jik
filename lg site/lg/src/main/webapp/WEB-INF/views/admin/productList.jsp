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
  <h2>제품 리스트</h2>
  <a href="<c:url value="/admin/product/insert"></c:url>" class="btn btn-outline-warning mb-3">제품등록</a>
  <table class="table table-hover">
    <thead>
      <tr>
        <th>제품 이미지</th>
        <th>종류</th>
        <th>코드</th>
        <th>제목</th>
        <th>가격</th>
        <th>기능</th>
      </tr>
    </thead>
    <tbody>
    	<c:forEach items="${list}" var="pro">
	      <tr>
	        <td>
	        	<img alt="제품이미지" src="<c:url value="/product/img${pro.pr_thumb}"></c:url>" width="150" height="150">
	        </td>
	        <td>${pro.pr_ca_name}</td>
	        <td>${pro.pr_code}</td>
	        <td>
	        	<a href="<c:url value="/product/select?pr_code=${pro.pr_code}"></c:url>">${pro.pr_title}</a>
	        </td>
	        <td>${pro.pr_price}</td>
	        <td>
	        	<a class="btn btn-outline-danger" href="<c:url value="/product/update?pr_code=${pro.pr_code}"></c:url>">수정</a>
	        	<a class="btn btn-outline-warning" href="<c:url value="/product/delete?pr_code=${pro.pr_code}"></c:url>">삭제</a>
	        </td>
	      </tr>
      </c:forEach>
    </tbody>
  </table>
  <ul class="pagination justify-content-center">
  	<li class="page-item"><a class="page-link" href="javascript:void(0);">처음</a></li>
    <li class="page-item"><a class="page-link" href="javascript:void(0);">이전</a></li>
    <li class="page-item"><a class="page-link" href="javascript:void(0);">1</a></li>
    <li class="page-item"><a class="page-link" href="javascript:void(0);">다음</a></li>
    <li class="page-item"><a class="page-link" href="javascript:void(0);">마지막</a></li>
  </ul>
  <form>
  	<div class="input-group mb-3">
  		<select class="form-control">
  			<option>카테고리</option>
  		</select>
		  <input type="text" class="form-control" placeholder="Search">
		  <div class="input-group-append">
		    <button class="btn btn-success" type="submit">Go</button>
		  </div>
		</div>
  </form>
</div>
</body>
</html>