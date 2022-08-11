<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="container">
	<button class="btn btn-outline-success btn-ajax1">ajax 테스트</button>
	<div class="box"></div>
</div>

<script>
	$(function(){
		$('.btn-ajax1').click(function(){
			let board = {
					bd_num : 1,
					bd_title : '제목',
					bd_content :'내용'
			}
			$.ajax({
				//비동기 : 작업이 끝날때까지 기다리지 않음, ajax가 동작중인지 끝났는지 상관없이 다음 작업을 함
				//동기 : 작업이 끝날때까지 기다림, ajax가 끝날때까지 기다린 다음 다음 작업을 함
        async:false, //비동기 여부 : true(비동기), false (동기)
        type:'POST',
        data: JSON.stringify(board),
        url: '<%=request.getContextPath()%>/test',
        dataType:"json", //서버에서 보내준 데이터의 타입
        contentType:"application/json; charset=UTF-8", //화면에서 ajax로 보내줄 데이터의 타입 data의 타입
        success : function(data){
        	console.log(data);
          console.log(data.bd_title)
        },
        error : function(a,b,c){
        }
	    });
			$.ajax({
				//비동기 : 작업이 끝날때까지 기다리지 않음, ajax가 동작중인지 끝났는지 상관없이 다음 작업을 함
				//동기 : 작업이 끝날때까지 기다림, ajax가 끝날때까지 기다린 다음 다음 작업을 함
        async:false, //비동기 여부 : true(비동기), false (동기)
        type:'POST',
        data: JSON.stringify(board),
        url: '<%=request.getContextPath()%>/test2',
        dataType:"json", //서버에서 보내준 데이터의 타입
        contentType:"application/json; charset=UTF-8", //화면에서 ajax로 보내줄 데이터의 타입 data의 타입
        success : function(data){
        	console.log(data);
          console.log(data[0].bd_title)
        },
        error : function(a,b,c){
        }
	    });
			$.ajax({
				//비동기 : 작업이 끝날때까지 기다리지 않음, ajax가 동작중인지 끝났는지 상관없이 다음 작업을 함
				//동기 : 작업이 끝날때까지 기다림, ajax가 끝날때까지 기다린 다음 다음 작업을 함
        async:false, //비동기 여부 : true(비동기), false (동기)
        type:'POST',
        data: JSON.stringify(board),
        url: '<%=request.getContextPath()%>/test3',
        dataType:"json", //서버에서 보내준 데이터의 타입
        contentType:"application/json; charset=UTF-8", //화면에서 ajax로 보내줄 데이터의 타입 data의 타입
        success : function(data){
        	console.log(data);
          console.log(data.board.bd_title)
        },
        error : function(a,b,c){
        }
	    });
			console.log('클릭을 종료합니다.')
		});
	})
</script>