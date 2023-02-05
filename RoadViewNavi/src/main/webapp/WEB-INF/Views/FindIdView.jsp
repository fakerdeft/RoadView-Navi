<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<style>
	div#head{
        font-size: 40px;
        width: 1000px;
        padding: 50px;
        margin-bottom: 50px;
        border-bottom: 2px solid lightgray;
    }
    .inputs{
        border: 1px solid lightgray;
        border-radius: 3px;
        width: 300px;
        height: 40px;
    }
</style>
</head>
<body>
<%@include file = "../Views/common.jsp" %>
<div align="center">
  	<div id="head" align="center">아이디 찾기</div>
  	<form action="findId.do" method="post" id="login-form">         
	    <table align="center" id="login1">
	        <tr align="center">
	            <td style="padding:50px"></td>
	        </tr>
	        <tr align="center">
	            <td><input type="text" name="userName" class="inputs" id="userName" placeholder="이름" required></td>
	        </tr>
	        <tr align="center">
	            <td style="padding:10px"></td>
	        </tr>
	        <tr align="center">
	            <td><input type="text" name="userPhone" class="inputs" id="userPhone" placeholder="핸드폰 번호" required></td>
	        </tr>
	        <tr align="center">
		        <td style="padding:50px">
		            <button type="submit" class="btn btn-primary" id="btn-findId">아이디 찾기</button>
		        	<button type="button" class="btn btn-danger" id="btn-cancel" onclick="location.replace('/RoadViewNavi')">취소</button>
		        </td>
	        </tr>
        </table>
	</form>
</div>
</body>
</html>