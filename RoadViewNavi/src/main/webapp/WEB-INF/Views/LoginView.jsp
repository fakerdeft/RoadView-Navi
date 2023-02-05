<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>
	.inputs{
        border: 1px solid lightgray;
        border-radius: 3px;
        width: 300px;
        height: 40px;
    }

	#login1{
    	margin-top: 50px;
        margin-right: 50px;
        height: 200px;
    }
    
	#login-btn{
        width: 300px;
        height: 40px;
        border: 0px;
        border-radius: 3px;
        background-color: rgb(69, 69, 73);
        color: white;
        cursor: pointer;
    }
</style>
</head>
<body>
<%@include file = "../Views/common.jsp" %>
<c:if test="${not empty alertMsg}">
     <script>
        alert("${alertMsg}");
     </script>
     <c:remove var="alertMsg" scope="session"/>
</c:if>
<div id="outer">
	<div align="center">
		<form action='logIn.do' method='post'>
			<table id="login1">
                   <tr align="center">
                       <td style="font-size: 20px; color:rgb(69, 69, 73);">회원 로그인</td>
                   </tr>
                   <tr align="center">
                       <td></td>
                   </tr>
                   <tr>
                  		<td><input type="text" name="userId" class="inputs" id="userId" placeholder="아이디" required></td>
                   </tr>
                   <tr align="center">
                       <td></td>
                   </tr>
                   <tr>
                       <td><input type="password" name="userPwd" class="inputs" id="userPwd" placeholder="비밀번호" required></td>
                   </tr>
                   <tr align="right">
                       <td colspan="2" style="font-size: 15px; margin:10px;">
                           <input type="checkbox" name="saveId" id="saveId">&nbsp; <label for="saveId">아이디 저장</label>
                       </td>
                   </tr>
                   <tr align="center">
                       <th>
                           <button type="submit" id="login-btn">로그인</button>
                       </th>
                   </tr>
                   <tr align="right">
                       <td>
                           <a href="findId.do">아이디 찾기</a> |
                           <a href="findPw.do">비밀번호 찾기</a>
                           <br>
                       </td>
                   </tr>
                   <tr>
                       <td style="padding-top: 17px;">
                       </td>
                   </tr>
               </table>
		</form>
	</div>
</div>
</body>
</html>