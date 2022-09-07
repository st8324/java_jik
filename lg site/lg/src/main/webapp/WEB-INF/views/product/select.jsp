<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
[name=file]{
	display: none;
}
.box-thumb{
	width: 150px; height: 150px; border:1px solid red;
	text-align: center; font-size : 50px; line-height: 148px;
	cursor: pointer; box-sizing: border-box;
}
.fa-regular{
	line-height: 1;
}
.display-none{
	display: none;
}
.likes{
	color : red; cursor: pointer;
}
</style>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
<body>
<div class="container">
	<h2 class="clearfix">
		<span class="float-left">제품 상세</span> 
		
		<i class="fa-regular fa-heart float-right likes <c:if test="${li != null }">display-none</c:if>"></i>
		<i class="fa-solid fa-heart float-right likes likes-ok <c:if test="${li == null }">display-none</c:if>"></i>
		
	</h2>
	<div class="clearfix">
		<div class="float-left" style="width:auto; height: auto">
			<img id="preview" width="150" height="150" src="<c:url value="${p.pr_thumb_url}"></c:url>">
		</div>
		<div class="float-right" style="width:calc(100% - 150px - 10px)">
			<div class="form-group">
			  <input type="text" class="form-control" value="제품종류 : ${p.pr_ca_name }" readonly>
			</div>
			<div class="form-group">
			  <input type="text" class="form-control" value="제품번호 : ${p.pr_code }" readonly>
			</div>
			<div class="form-group">
			  <input type="text" class="form-control" value="제품가격 : ${p.pr_price }" readonly>
			</div>
		</div>
	</div>
	<div class="form-group">
	  <input type="text" class="form-control" value="${p.pr_title }" readonly>
	</div>
	<div class="form-group">
	  <div class="form-control" style="height:auto">${p.pr_content }</div>
	</div>
	<div class="form-group">
		<label>제품 스펙</label>
	  <div class="form-control" style="height:auto">${p.pr_spec }</div>
	</div>
	<div class="box-qna">
		<h4>QnA</h4>
		<table class="table table-hover">
	    <thead>
	      <tr>
	        <th>제목</th>
	        <th>작성자</th>
	      </tr>
	    </thead>
	    <tbody>
	      <tr>
	        <td>John</td>
	        <td>Doe</td>
	      </tr>
	    </tbody>
	  </table>
	  <ul class="pagination justify-content-center">
	  	<li class="page-item <c:if test="${!pm.prev}">disabled</c:if>">
	  		<a class="page-link" href="<c:url value="/board/list?page=1&search=${pm.cri.search}&bd_type=${bd_type}"></c:url>">처음</a>
	  	</li>
	  	<li class="page-item <c:if test="${!pm.prev}">disabled</c:if>">
	  		<a class="page-link" href="<c:url value="/board/list?page=${pm.startPage-1}&search=${pm.cri.search}&bd_type=${bd_type}"></c:url>">이전</a>
	  	</li>
	  	
	  	<c:forEach begin="${pm.startPage }" end="${pm.endPage }" var="i">
	    	<li class="page-item <c:if test="${pm.cri.page == i}">active</c:if>">
	    		<a class="page-link" href="<c:url value="/board/list?page=${i}&search=${pm.cri.search}&bd_type=${bd_type}"></c:url>">${i}</a>
	    	</li>
	    </c:forEach>
	
	    <li class="page-item <c:if test="${!pm.next}">disabled</c:if>">
	    	<a class="page-link " href="<c:url value="/board/list?page=${pm.endPage+1}&search=${pm.cri.search}&bd_type=${bd_type}"></c:url>">다음</a>
	    </li>
	    <li class="page-item <c:if test="${!pm.next}">disabled</c:if>">
	    	<a class="page-link" href="<c:url value="/board/list?page=${pm.finalPage}&search=${pm.cri.search}&bd_type=${bd_type}"></c:url>">마지막</a>
	    </li>
	  </ul>
	  <a href="<c:url value="/board/insert?bd_type=QNA&bd_pr_code=${p.pr_code}"></c:url>" class="btn btn-outline-success">QnA 등록</a>
	</div>
</div>
<script type="text/javascript">
$(function(){
	$('.likes').click(function(){
		let li_me_email = '${user.me_email}';
		if(li_me_email == ''){
			alert('로그인이 필요한 서비스입니다.');
			return;
		}
		let li_pr_code = '${p.pr_code}';
		let likes = {
				li_me_email : li_me_email,
				li_pr_code : li_pr_code
		}
		ajaxPost(false, likes, '/likes', function(data){
			if(data.res == 0){
				$('.likes').removeClass('display-none');
				$('.likes-ok').addClass('display-none');
				alert('찜한 제품을 취소했습니다.')
			}else if(data.res == 1){
				$('.likes').addClass('display-none');
				$('.likes-ok').removeClass('display-none');
				alert('해당 제품을 찜했습니다.');
			}else{
				alert('잘못된 접근입니다.')
			}
		})
	})
})
</script>
</body>
</html>