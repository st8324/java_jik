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
	<form class="input-group mb-4">
		<select class="form-control col-2" name="searchType">
	    <option value="all" <c:if test="${pm.cri.searchType == 'all' }">selected</c:if>>전체</option>
	    <option value="bd_title" <c:if test="${pm.cri.searchType == 'bd_title' }">selected</c:if>>제목</option>
	    <option value="bd_me_id" <c:if test="${pm.cri.searchType == 'bd_me_id' }">selected</c:if>>작성자</option>
	  </select>
	  <input type="text" class="form-control col-8" name="search" value="${pm.cri.search }">
	  <button class="btn btn-outline-success col-2">검색</button>
	</form>
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
  <ul class="pagination justify-content-center">
  	<c:if test="${pm.prev}">
    	<li class="page-item"><a class="page-link" href="<c:url value="/board/list?page=${pm.startPage-1}&search=${pm.cri.search}&searchType=${pm.cri.searchType}"></c:url>">이전</a></li>
    </c:if>
    <c:forEach begin="${pm.startPage}" end="${pm.endPage }" var="i">
    	<li class="page-item <c:if test="${pm.cri.page == i}">active</c:if>">
    		<a class="page-link" href="<c:url value="/board/list?page=${i}&search=${pm.cri.search}&searchType=${pm.cri.searchType}"></c:url>">${i}</a>
    	</li>
    </c:forEach>
    <c:if test="${pm.next}">
    	<li class="page-item"><a class="page-link" href="<c:url value="/board/list?page=${pm.endPage+1}&search=${pm.cri.search}&searchType=${pm.cri.searchType}"></c:url>">다음</a></li>
    </c:if>
  </ul>
  <a href="<c:url value="/board/insert"></c:url>" class="btn btn-outline-success btn-board-insert">글쓰기</a>
</div>
<script type="text/javascript">
$(function(){
	$('.btn-board-insert').click(function(e){
		if('${user.me_id}' == ''){
			if(confirm('회원만 가능합니다. 로그인페이지로 이동하겠습니까?')){
				e.preventDefault();
				location.href = '<%=request.getContextPath()%>/login'
			}
		}
	})
})
</script>
</body>
</html>