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
	cursor: pointer; box-sizing: border-box; display: none;
}
#preview{
	
}
</style>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
<body>
<form class="container" enctype="multipart/form-data" method="post" action="<c:url value="/admin/product/update"></c:url>">
	<h2>제품 등록</h2>
	<div class="clearfix">
		<div class="float-left" style="width:auto; height: auto">
			<div class="box-thumb">+</div>
			<input type="file" name="file">
			<img id="preview" width="150" height="150" src="<c:url value="${pr.pr_thumb_url}"></c:url>">
		</div>
		<div class="float-right" style="width:calc(100% - 150px - 10px)">
			<div class="form-group">
			  <input class="form-control" name="pr_ca_name" type="text" readonly value="${pr.pr_ca_name}">
			</div>
			<div class="form-group">
			  <input type="text" class="form-control" readonly name="pr_code" readonly value="${pr.pr_code}">
			</div>
			<div class="form-group">
			  <input type="text" class="form-control" name="pr_price" placeholder="제품 가격(정수)" value="${pr.pr_price}">
			</div>
		</div>
	</div>
	<div class="form-group">
	  <input type="text" class="form-control" name="pr_title" placeholder="제품 제목" value="${pr.pr_title}">
	</div>
	<div class="form-group">
	  <textarea class="form-control" name="pr_content" placeholder="제품 설명">${pr.pr_content}</textarea>
	</div>
	<div class="form-group">
	  <textarea class="form-control" name="pr_spec" placeholder="제품 스펙">${pr.pr_spec}</textarea>
	</div>
	<button class="btn btn-outline-danger col-12">제품 수정</button>
</form>
<script type="text/javascript">
$(function(){
	$('.box-thumb, #preview').click(function(){
		$('[name=file]').click();
	})
	
	$('[name=file]').on('change', function(event) {
		if(event.target.files.length == 0){
			$('.box-thumb').show();
			$('#preview').hide();
			return;
		}else{
			$('.box-thumb').hide();
			$('#preview').show();
		}
		var file = event.target.files[0];
    var reader = new FileReader(); 
    reader.onload = function(e) {
      $('#preview').attr('src', e.target.result);
    }
    reader.readAsDataURL(file);
	});
	
	$('[name=pr_content]').summernote({
    placeholder: '제품 설명을 입력하세요.',
    tabsize: 2,
    height: 400
  });
	$('[name=pr_spec]').summernote({
	  placeholder: '제품 스펙을 입력하세요.',
	  tabsize: 2,
	  height: 400
  });
	
	$('form').submit(function(){
		
		let pr_price = $('[name=pr_price]').val();
		if(pr_ca_name == '' || !/\d+/.test(pr_price)){
			alert('올바른 가격을 입력하세요.');
			$('[name=pr_price]').focus();
			return false;
		}
		let pr_title = $('[name=pr_title]').val();
		if(pr_title == ''){
			alert('제품 제목을 입력하세요.');
			$('[name=pr_title]').focus();
			return false;
		}
		let pr_content = $('[name=pr_content]').val();
		if(pr_content == ''){
			alert('제품 내용을 입력하세요.');
			$('[name=pr_content]').focus();
			return false;
		}
		let pr_spec = $('[name=pr_spec]').val();
		if(pr_spec == ''){
			alert('제품 스펙을 입력하세요.');
			$('[name=pr_spec]').focus();
			return false;
		}
	});
})

</script>
</body>
</html>