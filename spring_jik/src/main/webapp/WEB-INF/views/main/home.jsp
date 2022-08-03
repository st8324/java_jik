<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="container">
	<h6>안녕하세요. ${name}입니다. 제 나이는 ${age}살입니다.</h6>
	<a href="/spring?hobby=운동&time=2">a태그를 이용한 데이터 전송</a>
	<form action="/spring/" class="mt-3" method="post">
		<div class="form-group">
		  <input type="text" class="form-control" name="hobby" placeholder="취미">
		</div>
		<div class="form-group">
		  <input type="text" class="form-control" name="time" placeholder="시간">
		</div>
		<button class="btn btn-outline-success col-12 mb-3">전송</button>
	</form>
	<a href="/spring/hobby/운동/3">경로 변수 연습링크</a>
	<script type="text/javascript">
	/* 
	- 서버에서 보낸 데이터를 스크립트에서 활용할 때 ''붙여서 문자열로 저장한 후 활용하는 것이 좋다
	  => 서버에서 보낸 데이터에 값이 없는 경우, ''가 없으면 해당 위치에 코드가 비어 있게 되어서 에러가
	     발생되어 이후 코드가 실행되지 않음
	  => 서버에서 보낸 데이터에 값이 없는 경우, ''가 있으면 해당 위치에 빈 문자열이 들어가게 되어 정상적인
	     결과는 아닐 수 있지만 에러가 발생하지 않아 이후 코드가 실행됨
	*/
	/*
		$(function(){
			let age = '${age1}';
			age = parseInt(age) + 10;
			console.log(age)
		})
	*/
	$(function(){
		$('form').submit(function() {
			let hobby = $('[name=hobby]').val()
			if(hobby.length == 0){
				alert('취미를 입력하세요')
				$('[name=hobby]').focus();
				return false;
			}
			
			let time = $('[name=time]').val();
			let timeRegex = /^[0-9]+$/
			if(!timeRegex.test(time)){
				alert('정수만 입력하세요');
				$('[name=time]').focus();
				return false;
			}
		})
	})
	</script>
	${user.id} <!-- user.getId()  -->
</div>