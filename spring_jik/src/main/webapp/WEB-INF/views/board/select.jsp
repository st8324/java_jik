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
				<div class="form-control" style="height:auto; min-height:400px">
			  ${board.bd_content}
			  </div>
			</div>
			<div class="form-group">
			  <label>첨부파일</label>
			  <c:if test="${fileList.size() == 0 }">없음</c:if>
			  <c:if test="${fileList.size() != 0 }">
			  	<c:forEach items="${fileList}" var="file">
				  	<a href="<c:url value="/file${file.fi_name}"></c:url>" class="form-control" download="${file.fi_ori_name}">${file.fi_ori_name}</a>
			  	</c:forEach>
			  </c:if>
			</div>
			<div class="list-comment">
				<div class="item-comment">
					<div class="co_me_id">작성자</div>
					<div class="co_content">내용</div>
					<div class="co_reg_date">작성일</div>
					<input value="1">
					<button class="btn-comment-delete">삭제</button>
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
			<c:if test="${user.me_id != board.bd_me_id }">
				<a href="<%=request.getContextPath()%>/board/insert?bd_ori_num=${board.bd_ori_num}&bd_depth=${board.bd_depth}&bd_order=${board.bd_order}" class="btn btn-outline-danger">답글</a>
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
		//댓글 등록 버튼 클릭
		$('.btn-comment-insert').click(function(){
			let co_content = $('[name=co_content]').val();
			let co_bd_num = '${board.bd_num}';
			
			if('${user.me_id}' == ''){
				if(confirm('로그인한 회원만 댓글 작성이 가능합니다. 로그인 하겠습니까?')){
					location.href = '<%=request.getContextPath()%>/login'
					return;
				}
			}
			
			
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
	
	$(function(){
		//댓글 삭제 버튼 클릭
		$(document).on('click','.btn-comment-delete',function(){
			let co_num = $(this).siblings('[name=co_num]').val()
			let obj ={
				co_num : co_num
			}
			$.ajax({
		    async: true,
		    type:'POST',
		    data: JSON.stringify(obj),
		    url: '<%=request.getContextPath()%>/ajax/comment/delete',
		    dataType:"json", 
		    contentType:"application/json; charset=UTF-8",
		    success : function(data){
		    	if(data.res){
		    		alert('삭제가 완료됐습니다.');
		    		getCommentList(criteria, bd_num);
		    	}else{
		    		alert('댓글 삭제에 실패했습니다.');
		    	}
		    }
			})
		})
	})
	
	$(function(){
		//수정 버튼 클릭
		$(document).on('click', '.btn-comment-update', function(){
			$('.btn-comment-update-cancel').click();
			$('.btn-cancel-reply').click();
			//기존 댓글 내용이 입력창으로 바뀌어야 함
			let co_content = $(this).siblings('.co_content').text();
			let str = '<textarea class="co_content2">'+co_content+'</textarea>';
			$(this).siblings('.co_content').after(str);
			$(this).siblings('.co_content').hide();
			$(this).hide();//수정버튼 감춤
			$(this).siblings('.btn-comment-delete').hide();//삭제버튼 감춤
			$(this).siblings('.btn-comment-reply').hide();//답글버튼 갑춤
			str = '<button class="btn-comment-update-complete">수정완료</button>'
			str += '<button class="btn-comment-update-cancel">취소</button>';
			$(this).parent().append(str);
		})
		//수정 완료 버튼 클릭
		$(document).on('click','.btn-comment-update-complete',function(){
			let co_num = $(this).siblings('[name=co_num]').val()
			let co_content = $(this).siblings('.co_content2').val()
			let obj ={
				co_num : co_num,
				co_content : co_content
			}
			$.ajax({
		    async: true,
		    type:'POST',
		    data: JSON.stringify(obj),
		    url: '<%=request.getContextPath()%>/ajax/comment/update',
		    dataType:"json", 
		    contentType:"application/json; charset=UTF-8",
		    success : function(data){
		    	if(data.res){
		    		alert('수정이 완료됐습니다.');
		    		getCommentList(criteria, bd_num);
		    	}else{
		    		alert('댓글 수정에 실패했습니다.');
		    	}
		    }
			})
		})
		//수정버튼 클릭 후 생기는 취소버튼 클릭
		$(document).on('click', '.btn-comment-update-cancel', function(){
			//기존 댓글 내용이 입력창으로 바뀌어야 함
			$(this).siblings('.co_content').show();
			$(this).siblings('.co_content2').remove();
			$(this).siblings('.btn-comment-update').show();//수정버튼 보임
			$(this).siblings('.btn-comment-delete').show();//삭제버튼 보임
			$(this).siblings('.btn-comment-reply').show();//답글버튼 보임
			$('.btn-comment-update-cancel').remove();
			$('.btn-comment-update-complete').remove();
		})
		//답글버튼 클릭
		$(document).on('click', '.btn-comment-reply', function(){
			let id = '${user.me_id}';
			if(id == ''){
				if(confirm('댓글 답글은 로그인을 해야 합니다. 로그인을 하시겠습니까?')){
					location.href = '<%=request.getContextPath()%>/login'
					return;
				}
			}
			//답글을 누른 댓글에만 답글을 입력하는 창이 나오게 하기 위해 모든 답글취소버튼을 클릭해서 없애줌
			$('.btn-cancel-reply').click();
			$('.btn-comment-update-cancel').click();
			let str = '<br><textarea class="co_content_reply"></textarea><br>';
			str += '<button class="btn-insert-reply">답글 등록</button>'
				str += '<button class="btn-cancel-reply">답글 취소</button>'
			$(this).after(str);
			$(this).hide();//답변버튼 감춤
			$(this).siblings('.btn-comment-update').hide();//수정버튼 감춤
			$(this).siblings('.btn-comment-delete').hide();//삭제버튼 감춤
		})
		//답글 등록버튼 클릭
		$(document).on('click', '.btn-insert-reply', function(){
			//co_ori_num, co_depth, co_order
			let co_ori_num = $(this).siblings('[name=co_ori_num]').val();
			let co_depth = $(this).siblings('[name=co_depth]').val();
			let co_order = $(this).siblings('[name=co_order]').val();
			let co_content = $(this).siblings('.co_content_reply').val();
			let co_bd_num = '${board.bd_num}';
			let obj = {
					co_ori_num : co_ori_num, 
					co_depth : co_depth,
					co_order : co_order,
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
		//답글취소버튼 클릭
		$(document).on('click', '.btn-cancel-reply', function(){
			$(this).siblings('.co_content_reply').remove();
			$(this).siblings('.btn-insert-reply').remove();
			$(this).siblings('br').remove();
			$(this).siblings('.btn-comment-reply').show();//답글 보임
			$(this).siblings('.btn-comment-update').show();//수정버튼 보임
			$(this).siblings('.btn-comment-delete').show();//삭제버튼 보임
			$(this).remove();
		});
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
						'<div class="co_content">'
						for(i = 2; i<=co.co_depth; i++)
							str += '└';
					
						str +=	
							co.co_content+'</div>' +
						'<div class="co_reg_date">'+co.co_reg_date_str+'</div>' +
						'<input value="'+co.co_num+'" name="co_num" type="hidden">'+
						'<input value="'+co.co_ori_num+'" name="co_ori_num" type="hidden">'+
						'<input value="'+co.co_depth+'" name="co_depth" type="hidden">'+
						'<input value="'+co.co_order+'" name="co_order" type="hidden">';
						if(co.co_me_id == '${user.me_id}'){
							str +=
							'<button class="btn-comment-delete">삭제</button>' +
							'<button class="btn-comment-update">수정</button>';
						}
					str +=
						'<button class="btn-comment-reply">답글</button>'+
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