<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.btn-del{
	padding : 0; border: none; background-color: transparent; color : #ffc107;
}
form.btn:hover .btn-del{
	color : #fff;
}
form.btn{
	margin-bottom: 0;
}
</style>
</head>
<body>
<div class="container">
  <h2>공지사항</h2>
  <a href="<c:url value="/admin/notice/insert"></c:url>" class="btn btn-outline-warning mb-3">공지사항등록</a>
  <table class="table table-hover">
    <thead>
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성일</th>
        <th>기능</th>
      </tr>
    </thead>
    <tbody>
    	<c:forEach items="${list}" var="bo" varStatus="status">
	      <tr>
	        <td>${pm.totalCount - (pm.cri.page-1)*pm.cri.perPageNum - status.index}</td>
	        <td>
	        	<a href="<c:url value="/board/select?bd_num=${bo.bd_num}"></c:url>">${bo.bd_title}</a>
	        </td>
	        <td>${bo.bd_reg_date_str}</td>
	        <td>
	        	<a class="btn btn-outline-danger" href="<c:url value="/admin/notice/update?bd_num=${bo.bd_num}"></c:url>">수정</a>
	        	<form class="btn btn-outline-warning" action="<c:url value="/board/delete"></c:url>"  method="post">
	        		<button class="btn-del">삭제</button>
	        		<input type="hidden" name="bd_num" value="${bo.bd_num}">
	        		<input type="hidden" name="bd_type" value="${bo.bd_type}">
	        	</form>
	        </td>
	      </tr>
      </c:forEach>
    </tbody>
  </table>
  <ul class="pagination justify-content-center">
  	<li class="page-item <c:if test="${!pm.prev}">disabled</c:if>">
  		<a class="page-link" href="<c:url value="/admin/notice/list?page=1&search=${pm.cri.search}"></c:url>">처음</a>
  	</li>
  	<li class="page-item <c:if test="${!pm.prev}">disabled</c:if>">
  		<a class="page-link" href="<c:url value="/admin/notice/list?page=${pm.startPage-1}&search=${pm.cri.search}"></c:url>">이전</a>
  	</li>
  	
  	<c:forEach begin="${pm.startPage }" end="${pm.endPage }" var="i">
    	<li class="page-item <c:if test="${pm.cri.page == i}">active</c:if>">
    		<a class="page-link" href="<c:url value="/admin/notice/list?page=${i}&search=${pm.cri.search}"></c:url>">${i}</a>
    	</li>
    </c:forEach>

    <li class="page-item <c:if test="${!pm.next}">disabled</c:if>">
    	<a class="page-link " href="<c:url value="/admin/notice/list?page=${pm.endPage+1}&search=${pm.cri.search}"></c:url>">다음</a>
    </li>
    <li class="page-item <c:if test="${!pm.next}">disabled</c:if>">
    	<a class="page-link" href="<c:url value="/admin/notice/list?page=${pm.finalPage}&search=${pm.cri.search}"></c:url>">마지막</a>
    </li>
  </ul>
  <form>
  	<div class="input-group mb-3">
  		<input type="text" class="form-control" placeholder="제목으로 검색하세요." name="search" value="${pm.cri.search}">
		  <div class="input-group-append">
		    <button class="btn btn-success" type="submit">검색</button>
		  </div>
		</div>
  </form>
</div>

</body>
</html>