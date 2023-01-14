<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<head>
<meta charset="UTF-8">
<title>Login</title>

<style>
	#login1{
    	margin-top:50px;
        margin-right: 50px;
        height: 200px;
        float: right;
    }
    
	#login-btn{
	        width: 300px;
	        height: 40px;
	        border: 0px;
	        border-radius: 3px;
	        background-color: rgb(69, 69, 73);
	        color: white;
    }
</style>

</head>
<body>
	<div id="outer">
		<div align="center">
			로그인 창
			<form action='insert.do' method='post'>
				<table id="login1">
                    <tr align="left">
                        <td style="font-size: 20px; color:rgb(69, 69, 73);">| 회원 로그인</td>
                    </tr>
                    <tr align="left">
                        <td></td>
                    </tr>
                    <tr>
                   		<td><input type="text" name="userId" class="inputs" id="userId" placeholder="아이디" required></td>
                    </tr>
                    <tr align="left">
                        <td></td>
                    </tr>
                    <tr>
                        <td><input type="password" name="userPwd" class="inputs" id="userPwd" placeholder="비밀번호" required></td>
                    </tr>
                    <tr align="left">
                        <td colspan="2" style="font-size: 15px; margin:10px;">
                            <input type="checkbox" name="saveId" id="saveId">&nbsp; <label for="saveId">아이디 저장</label>
                        </td>
                    </tr>
                    <tr align="left">
                        <th>
                            <button type="submit" id="login-btn">로그인</button>
                        </th>
                    </tr>
                    <tr align="right">
                        <td>
                            <a href="/findId.do">아이디 찾기</a> |
                            <a href="/findPw.do">비밀번호 찾기</a>
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
	
<%if(loginUser != null) {%>
	<script type="text/javascript">
		location.replace("/");
	</script>
<%} %>

</body>


</html>