<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P> 안녕하세요. 제 이름은 ${name} 입니다. </P>
<a href="/spring?age=20">나이는 20살입니다.</a>
<form action="/spring" method="get">
	<input type="text" name="hobby"> <br>
	<input type="text" name="id" placeholder="아이디"> <br>
	<input type="password" name="pw" placeholder="비번"> <br>
	<button>전송</button>
</form>
<a href="/spring/login">로그인 페이지로</a>
</body>
</html>
