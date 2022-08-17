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
	<h1>게시글 리스트</h1>
	<div class="form-group">
		<form class="input-group">
			<select class="input-group-prepend form-control col-2" name="searchType">
		    <option value="all">전체</option>
		    <option value="bd_title">제목</option>
		    <option value="bd_me_id">작성자</option>
		  </select>
			<input type="text" class="form-control col-8" name="search" value="${pm.cri.search}">
			<button class="btn btn-outline-success col-2 btn-search" type="button">검색</button>
		</form>
	</div>
	<table class="table table-striped table-hover">
    <thead>
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회수</th>
        <th>추천</th>
      </tr>
    </thead>
    <tbody></tbody>
  </table>
  <ul class="pagination justify-content-center"></ul>
  <a href="<%=request.getContextPath()%>/board/insert" class="btn btn-outline-warning">글쓰기</a>
</div>
<script>
$(function(){
	getBoardList({page : 1})
	$('.btn-search').click(function(){
		let search = $('[name=search]').val();
		let searchType = $('[name=searchType]').val();
		let cri = {
				search : search,
				searchType : searchType,
				page : 1
		}
		getBoardList(cri);
	})
})


function getBoardList(cri){
	$.ajax({
    async: true,
    type:'POST',
    data: JSON.stringify(cri),
    url: '<%=request.getContextPath()%>/ajax/board/list',
    dataType:"json", 
    contentType:"application/json; charset=UTF-8",
    success : function(data){
    	let str = '';
    	for(board of data.list){
	    	str += 
	    	`<tr>`+
	        `<td>`+board.bd_num+`</td>`+
	        `<td>`+
	        	`<a href="<%=request.getContextPath()%>/board/select/` +
	        		board.bd_num +
	        		`">` +
	        		board.bd_title +
	        		`</a>`+
	        `</td>`+
	        `<td>`+board.bd_me_id+`</td>`+
	        `<td>`+board.bd_reg_date_str+`</td>`+
	        `<td>`+board.bd_views+`</td>`+
	        `<td>`+board.bd_up+`/`+board.bd_down+`</td>`+
	      `</tr>`;
    	}
      $('tbody').html(str);
      let pm = data.pm;
      let pmStr = ''; 
    	if(pm.prev){
    		pmStr +=
      	'<li class="page-item">' +
      		'<a class="page-link" href="javascript:0;" onclick="getBoardList({page : '+(pm.startPage-1)+'})">이전</a>' +
      	'</li>';
    	}
      for(let i = pm.startPage; i<=pm.endPage; i++){
    	  let active = pm.cri.page == i ? 'active' : '';
    	  pmStr +=
      	'<li class="page-item '+active+'">'+
      		'<a class="page-link" href="javascript:0;" onclick="getBoardList({page : '+i+'})">'+ i +'</a>'+
      	'</li>';
      }
      if(pm.next){
    	  pmStr +=
      	'<li class="page-item">' + 
      		'<a class="page-link" href="javascript:0;" onclick="getBoardList({page : '+(pm.endPage+1)+'})">다음</a>' + 
      	'</li>';
      }
      $('.pagination').html(pmStr);
    }
  });
}
</script>
</body>
</html>