<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- Core -->
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %> <!-- XML -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <!-- I18N -->
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %> <!-- Database -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> <!-- Functions -->

<%
 String strReferer = request.getHeader("referer"); //이전 URL 가져오기
 
 if(strReferer == null){
%>
 <script language="javascript">
  alert("로그인이 필요합니다.");
  location.replace('/')
 </script>
<%
  return;
 }
%>

<!DOCTYPE html>
<html>
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
</head>

<body>
<c:choose>
	<c:when test="${empty loginUser}">
		<jsp:forward page="WEB-INF/Views/main.jsp" />
	</c:when>
	<c:otherwise>
		<jsp:forward page="WEB-INF/Views/MapView.jsp" />
	</c:otherwise>
</c:choose>
</body>

</html>













