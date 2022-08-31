<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
<body>
	<form class="container" method="post" enctype="multipart/form-data">
		<h1>게시글 등록</h1>
		<div class="form-group">
		  <label for="bd_title">제목:</label>
		  <input type="text" class="form-control" name="bd_title" id="bd_title">
		</div>
		<div class="form-group">
		  <label for="bd_content">내용:</label>
		  <textarea class="form-control" rows="10" name="bd_content" id="bd_content"></textarea>
		</div>
		<div class="form-group">
		  <label>첨부파일(최대 3개):</label>
		  <input type="file" class="form-control" name="files">
		  <input type="file" class="form-control" name="files">
		  <input type="file" class="form-control" name="files">
		</div>
		<button class="btn btn-outline-success col-12">게시글 등록</button>
	</form>
<script type="text/javascript">
$(function(){
	$('#bd_content').summernote({
    placeholder: 'Hello Bootstrap 4',
    tabsize: 2,
    height: 400,
    callbacks: {
			onImageUpload: function(files) {
				if(files == null || files.length == 0)
					return;
				for(file of files){
					let data = new FormData();
					data.append('file', file);
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
					});
				}
			}
    }
 	});
})
</script>
</body>
</html>