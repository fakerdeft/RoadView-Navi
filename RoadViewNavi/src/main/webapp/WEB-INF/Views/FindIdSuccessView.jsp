<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기 성공</title>
<style>
	div#head{
	        font-size: 40px;
	        width: 1000px;
	        padding: 50px;
	        margin-bottom: 50px;
	        border-bottom: 2px solid lightgray;
    }
</style>
</head>
<body>
<%@include file = "../Views/common.jsp" %>
<div align="center" style="width:1900px; position:relative;">
   	<div id="head" align="center">아이디 찾기 성공</div>
   		<div>
   			<h2>${findUserId}</h2>
   		</div>
   	<div>
   	<br>
   		<button type="button" class="btn btn-info" id="btn-findPw" onclick="location.replace('findPw.do')">비밀번호 찾기</button>
   		<button type="button" class="btn btn-primary" id="btn-goHome" onclick="location.replace('/RoadViewNavi')">홈으로 가기</button>
   	</div>
</div>	
</body>
</html>