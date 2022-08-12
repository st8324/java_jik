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
		<c:if test="${board != null && 'N'.charAt(0) ==board.bd_del }">
			<h1>게시글 상세</h1>
			<div class="form-group">
			  <input type="text" class="form-control" name="bd_title" value="${board.bd_title }" readonly>
			</div>
			<div class="form-group">
			  <input type="text" class="form-control" name="bd_me_id" value="${board.bd_me_id }" readonly>
			</div>
			<div class="form-group">
			  <input type="text" class="form-control" name="bd_reg_date" value="${board.bd_reg_date_time_str}" readonly>
			</div>
			<div class="form-group">
			  <input type="text" class="form-control" name="bd_views" value="${board.bd_views}" readonly>
			</div>
			
			
			<div class="form-group">
				<button type="button" class="btn btn<c:if test="${likes.li_state != 1}">-outline</c:if>-primary up btn-likes" >추천</button>
				<button type="button" class="btn btn<c:if test="${likes.li_state != -1}">-outline</c:if>-danger down btn-likes">비추천</button>
			</div>
			<div class="form-group">
			  <textarea class="form-control" rows="10" name="bd_content" readonly>${board.bd_content}</textarea>
			</div>
			<c:if test="${user != null && user.me_id == board.bd_me_id }">
				<a href="<%=request.getContextPath()%>/board/update/${board.bd_num}" class="btn btn-outline-danger">수정</a>
				<a href="<%=request.getContextPath()%>/board/delete/${board.bd_num}" class="btn btn-outline-danger">삭제</a>
			</c:if>
		</c:if>
		<c:if test="${board != null && 'A'.charAt(0) ==board.bd_del }">
			<h1>관리자에 의해 삭제된 게시글입니다.</h1>
		</c:if>
		<c:if test="${board != null && 'Y'.charAt(0) ==board.bd_del }">
			<h1>작성자에 의해 삭제된 게시글입니다.</h1>
		</c:if>
		<c:if test="${board == null}">
			<h1>잘못된 경로로 접근했습니다.</h1>
		</c:if>
	</div>
	<script>
		$(function(){
			$('.btn-likes').click(function(){

				let li_state = $(this).hasClass('up') ? 1 : -1;
				let obj = {
					li_bd_num : '${board.bd_num}',
					li_state : li_state,
					li_me_id : '${user.me_id}'
				}
				if(obj.li_me_id == ''){
					if(confirm('추천/비추천은 로그인을 해야 합니다. 로그인을 하시겠습니까?')){
						location.href='<%=request.getContextPath()%>/login'
					}
					else
						return;
				}
				$.ajax({
	        async:true,
	        type:'POST',
	        data: JSON.stringify(obj),
	        url: '<%=request.getContextPath()%>/board/likes',
	        contentType:"application/json; charset=UTF-8",
	        success : function(data){
	        	$('.btn-likes.up').removeClass('btn-primary').addClass('btn-outline-primary');
	        	$('.btn-likes.down').removeClass('btn-danger').addClass('btn-outline-danger');
	        	if(data == '1'){
	        		alert('해당 게시글을 추천했습니다.')
	        		$('.btn-likes.up').addClass('btn-primary').removeClass('btn-outline-primary');
	        	}else if(data == '-1'){
	        		alert('해당 게시글을 비추천했습니다.')
	        		$('.btn-likes.down').addClass('btn-danger').removeClass('btn-outline-danger');
	        	}else if(data == '10'){
	        		alert('해당 게시글 추천을 취소했습니다.')
	        	}else if(data == '-10'){
	        		alert('해당 게시글 비추천을 취소했습니다.')
	        	}else
	        		alert('잘못된 접근입니다.');
	        }
		    });
			})
		})
	</script>
</body>
</html>