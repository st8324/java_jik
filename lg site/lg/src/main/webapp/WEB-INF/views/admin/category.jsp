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
  <h2>카테고리 목록</h2>
  <form method="post">
	  <div class="input-group mb-3">
	    <input type="text" class="form-control" placeholder="카테고리명" name="ca_name">
	    <input type="text" class="form-control" placeholder="카테고리코드" name="ca_code">
	    <div class="input-group-append">
	    	<button class="btn btn-outline-success">등록</button>
	  	</div>
	  </div>
  </form>
  <table class="table table-striped">
    <thead>
      <tr>
        <th>카테고리명</th>
        <th>카테고리코드</th>
      </tr>
    </thead>
    <tbody>
    	<c:forEach items="${list }" var="ca">
	      <tr>
	        <td>${ca.ca_name }</td>
	        <td>${ca.ca_code }</td>
	      </tr>
      </c:forEach>
    </tbody>
  </table>
</div>

</body>
</html>