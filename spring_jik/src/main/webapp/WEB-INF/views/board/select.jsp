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
			
			<div class="list-comment">
				<div class="item-comment">
					<div class="co_me_id">작성자</div>
					<div class="co_content">내용</div>
					<div class="co_reg_date">작성일</div>
					<input value="1">
				</div>
			</div>
			<ul class="pagination justify-content-center"></ul>
			<div class="form-group mt-5">
				<textarea class="form-control" name="co_content"></textarea>
				<button class="btn btn-outline-success col-12 btn-comment-insert">댓글등록</button>
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
	let criteria = {
			page       : 1,
			perPageNum : 5
	}
	let bd_num = '${board.bd_num}'
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
	
	$(function(){
		$('.btn-comment-insert').click(function(){
			let co_content = $('[name=co_content]').val();
			let co_bd_num = '${board.bd_num}';
			let obj = {
					co_content : co_content,
					co_bd_num : co_bd_num
			}
			$.ajax({
		    async: true,
		    type:'POST',
		    data: JSON.stringify(obj),
		    url: '<%=request.getContextPath()%>/ajax/comment/insert',
		    dataType:"json", 
		    contentType:"application/json; charset=UTF-8",
		    success : function(data){
		    	alert(data.res);
		    	getCommentList(criteria, bd_num);
		    }
		  });
		})
	})
	
	function getCommentList(cri, bd_num){
		$.ajax({
	    async: true,
	    type:'POST',
	    data: JSON.stringify(cri),
	    url: '<%=request.getContextPath()%>/ajax/comment/list/'+bd_num,
	    dataType:"json", 
	    contentType:"application/json; charset=UTF-8",
	    success : function(data){

	    	let str = '';
	    	for( co of data.list){
		    	str += 
		    	'<div class="item-comment">' + 
						'<div class="co_me_id"><b>'+co.co_me_id+'</b></div>' + 
						'<div class="co_content">'+co.co_content+'</div>' + 
						'<div class="co_reg_date">'+co.co_reg_date_str+'</div>' +
						'<input value="'+co.co_num+'" name="co_num" type="hidden">' +
					'</div>'
	    	}
	    	$('.list-comment').html(str);
	    	let pm = data.pm;
        let pmStr = ''; 
      	if(pm.prev){
      		pmStr +=
        	'<li class="page-item">' +
        		'<a class="page-link" href="javascript:0;" onclick="criteria.page='+(pm.statrPage-1)+';getCommentList(criteria, bd_num)">이전</a>' +
        	'</li>';
      	}
        for(let i = pm.startPage; i<=pm.endPage; i++){
      	  let active = pm.cri.page == i ? 'active' : '';
      	  pmStr +=
        	'<li class="page-item '+active+'">'+
        		'<a class="page-link" href="javascript:0;" onclick="criteria.page='+(i)+';getCommentList(criteria, bd_num)">'+ i +'</a>'+
        	'</li>';
        }
        if(pm.next){
      	  pmStr +=
        	'<li class="page-item">' + 
        		'<a class="page-link" href="javascript:0;" onclick="criteria.page='+(pm.endPage+1)+';getCommentList(criteria, bd_num)">다음</a>' + 
        	'</li>';
        }
        $('.pagination').html(pmStr);
	    }
	  });
	}
	getCommentList(criteria, bd_num)
	</script>
</body>
</html>