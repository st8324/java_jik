<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
<body>
	<div class="container">
		<form method="post" class="mt-5" enctype="multipart/form-data">
			<h1>게시글 수정</h1>
			<div class="form-group">
			  <input type="text" class="form-control" name="bd_title" placeholder="제목" value="${board.bd_title }">
			</div>
			<div class="form-group">
			  <textarea class="form-control" rows="10" name="bd_content" placeholder="내용" id="sn">${board.bd_content}</textarea>
			</div>
			<div class="form-group">
				<label>첨부파일</label>
				<c:forEach items="${fileList}" var="file">
					<a href="javascript:0;" class="form-control">${file.fi_ori_name}<span data-target="${file.fi_num}" class="btn-del float-right" >X</span></a>
				</c:forEach>
				<c:forEach begin="1" end="${3-fileList.size()}">
					<input type="file" class="form-control" name="files">
				</c:forEach>
				
			</div>
			<button class="btn btn-outline-primary col-12 mb-3">게시글 수정</button>
		</form>
	</div>
	<script type="text/javascript">
	$(function(){
		//첨부파일에서 x버튼 클릭
		$('.btn-del').click(function(){
			let str = '<input type="file" class="form-control" name="files">';
			$(this).parent().after(str);
			let fi_num = $(this).data('target');
			str = '<input type="hidden" name="delFiles" value="'+fi_num+'">';
			$(this).parent().after(str);
			$(this).parent().remove();
		})
		$('#sn').summernote({
		  placeholder: 'Hello Bootstrap 4',
		  tabsize: 2,
		  height: 400,
		  callbacks: {
		    onImageUpload: function(files) {
		    	let data = new FormData();
					data.append('file', files[0]);
					let thisObj = $(this)
					$.ajax({
						data : data,
						type : 'post',
						url : '<%=request.getContextPath()%>/board/img/upload',
						contentType : false,
						processData : false,
						dataType: "json",
						success : function(data){
							let url = '<%=request.getContextPath()%>/simg' + data.url;
							thisObj.summernote('insertImage', url);		
						}
					})
		    }
		  }
		});
	})
	</script>
</body>
</html>