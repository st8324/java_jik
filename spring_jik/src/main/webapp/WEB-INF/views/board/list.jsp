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
	<h1>게시글 리스트</h1>
	<div class="form-group">
		<form class="input-group">
			<select class="input-group-prepend form-control col-2" name="searchType">
		    <option value="all" <c:if test="${pm.cri.searchType == 'all' }">selected</c:if>>전체</option>
		    <option value="bd_title" <c:if test="${pm.cri.searchType == 'bd_title' }">selected</c:if>>제목</option>
		    <option value="bd_me_id" <c:if test="${pm.cri.searchType == 'bd_me_id' }">selected</c:if>>작성자</option>
		  </select>
			<input type="text" class="form-control col-8" name="search" value="${pm.cri.search}">
			<button class="btn btn-outline-success col-2">검색</button>
		</form>
	</div>
	<table class="table table-striped table-hover">
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
	        	<a href="<%=request.getContextPath()%>/board/select/${board.bd_num}">
	        	<c:forEach begin="2" end="${board.bd_depth}">&nbsp;&nbsp;</c:forEach>
	        	<c:if test="${board.bd_num != board.bd_ori_num }">└</c:if>
	        		${board.bd_title}
	        	</a>
	        </td>
	        <td>${board.bd_me_id}</td>
	        <td>${board.bd_reg_date_str}</td>
	        <td>${board.bd_views}</td>
	        <td>${board.bd_up}/${board.bd_down }</td>
	      </tr>
      </c:forEach>
    </tbody>
  </table>
  <ul class="pagination justify-content-center">
  	<c:if test="${pm.prev}">
    	<li class="page-item"><a class="page-link" href="<c:url value="/board/list?page=${pm.startPage-1}&search=${pm.cri.search}&searchType=${pm.cri.searchType}"></c:url>">이전</a></li>
    </c:if>
    <c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="i">
    	<li class="page-item <c:if test="${i == pm.cri.page }">active</c:if>">
    		<a class="page-link" href="<c:url value="/board/list?page=${i}&search=${pm.cri.search}&searchType=${pm.cri.searchType}"></c:url>">${i}</a>
    	</li>
    </c:forEach>
    <c:if test="${pm.next}">
    	<li class="page-item"><a class="page-link" href="<c:url value="/board/list?page=${pm.endPage+1}&search=${pm.cri.search}&searchType=${pm.cri.searchType}"></c:url>">다음</a></li>
    </c:if>
  </ul>
  <a href="<%=request.getContextPath()%>/board/insert" class="btn btn-outline-warning">글쓰기</a>
</div>
</body>
</html>