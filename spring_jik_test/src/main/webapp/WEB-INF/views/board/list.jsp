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
	<h1>게시글</h1>
  <table class="table table-bordered table-hover">
    <thead>
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회수</th>
        <th>추천</th>
      </tr>
    </thead>
    <tbody>
    	<c:forEach items="${list}" var="board">
	      <tr>
	        <td>${board.bd_num}</td>
	        <td>
	        	<a href="<c:url value="/board/select/${board.bd_num}"></c:url>">${board.bd_title}</a>
					</td>
	        <td>${board.bd_me_id}</td>
	        <td>${board.bd_reg_date_str}</td>
	        <td>${board.bd_views}</td>
	        <td>${board.bd_up}/${board.bd_down}</td>
	      </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>