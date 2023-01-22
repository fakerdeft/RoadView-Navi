<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- Core -->
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %> <!-- XML -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <!-- I18N -->
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %> <!-- Database -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> <!-- Functions -->
<!DOCTYPE html>
<html>
<head>
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Main Page</title>
</head>
<body>
<c:if test="${not empty alertMsg}">
     <script>
        alert("${alertMsg}");
     </script>
     <c:remove var="alertMsg" scope="session"/>
</c:if>

<c:choose>
	<c:when test="${empty loginUser}">
		<button onClick="location.href='logIn.do'">로그인</button>
		<button onClick="location.href='insert.do'">회원가입</button>
	</c:when>
	<c:otherwise>
		<button onClick="location.href='myPage.do'">마이페이지</button>
		<button onClick="location.href='map.do'">지도</button>
	</c:otherwise>
</c:choose>
</body>

</html>













