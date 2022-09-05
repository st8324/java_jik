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
#preview{
	display: none;
}
</style>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
<body>
<form class="container" enctype="multipart/form-data" method="post">
	<h2>제품 등록</h2>
	<div class="clearfix">
		<div class="float-left" style="width:auto; height: auto">
			<div class="box-thumb">+</div>
			<input type="file" name="file">
			<img id="preview" width="150" height="150">
		</div>
		<div class="float-right" style="width:calc(100% - 150px - 10px)">
			<div class="form-group">
			  <select class="form-control" name="pr_ca_name">
			  	<option value="0">제품 카테고리를 선택하세요.</option>
			  	<c:forEach items="${list}" var="ca">
			  		<option value="${ca.pr_code}">${ca.ca_name}</option>
			  	</c:forEach>
			  </select>
			</div>
			<div class="form-group">
			  <input type="text" class="form-control" readonly value="제품번호" name="pr_code">
			</div>
			<div class="form-group">
			  <input type="text" class="form-control" name="pr_price" placeholder="제품 가격(정수)">
			</div>
		</div>
	</div>
	<div class="form-group">
	  <input type="text" class="form-control" name="pr_title" placeholder="제품 제목">
	</div>
	<div class="form-group">
	  <textarea class="form-control" name="pr_content" placeholder="제품 설명"></textarea>
	</div>
	<div class="form-group">
	  <textarea class="form-control" name="pr_spec" placeholder="제품 스펙"></textarea>
	</div>
	<button class="btn btn-outline-danger col-12">제품 등록</button>
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
	$('[name=pr_ca_name]').change(function(){
		$('[name=pr_code]').val($(this).val());
	})
	$('form').submit(function(){
		let thumb_img = $('[name=file]').val();
		if(thumb_img == ''){
			alert('썸네일 이미지를 선택하세요.');
			$('[name=file]').click();
			return false;
		}
		let pr_ca_name = $('[name=pr_ca_name]').val();
		if(pr_ca_name == '0'){
			alert('제품 종류를 선택하세요.');
			$('[name=pr_ca_name]').focus();
			return false;
		}
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