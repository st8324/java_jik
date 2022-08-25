<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.delete{
	font-size : 30px; height : 21px; vertical-align : top;
	line-height: 21px; float: right;
}
.delete:hover{
	color : red;
}
</style>
</head>
<body>
<c:if test="${board.bd_del == 'N' }">
	<form class="container" method="post" enctype="multipart/form-data">
		<h1>게시글 수정</h1>
		<div class="form-group">
		  <label for="bd_title">제목:</label>
		  <input type="text" class="form-control" name="bd_title" id="bd_title" value="${board.bd_title }">
		</div>
		<div class="form-group">
		  <label for="bd_content">내용:</label>
		  <textarea class="form-control" rows="10" name="bd_content" id="bd_content">${board.bd_content }</textarea>
		</div>
		<div class="form-group">
		  <label for="">첨부파일</label>
		  <c:forEach items="${fileList}" var="fi">
			  <a href="javascript:0;" class="form-control"  style="vertical-align: top">${fi.fi_ori_name }<span class="delete" data-target="${fi.fi_num}">&times;</span></a>
		  </c:forEach>
		  <c:forEach begin="1" end="${3-fileList.size()}">
		  	<input type="file" class="form-control" name="files">
		  </c:forEach>
	  </div>
		<button class="btn btn-outline-success col-12">게시글 수정</button>
	</form>
</c:if>
<c:if test="${board.bd_del == 'Y' }">
	<h1 class="container">작성자에 의해 삭제된 게시글입니다.</h1>
</c:if>
<c:if test="${board.bd_del == 'A' }">
	<h1 class="container">관리자에 의해 삭제된 게시글입니다.</h1>
</c:if>

<script type="text/javascript">
	$(function(){
		$('.delete').click(function(){
			let fi_num = $(this).data('target');
			let str1 = '<input type="hidden" name="nums" value="'+fi_num+'">';
			let str2 = '<input type="file" class="form-control" name="files">';
			$(this).parents('.form-group').append(str1);
			$(this).parents('.form-group').append(str2);
			$(this).parent().remove();
		})
	})
</script>
</body>
</html>