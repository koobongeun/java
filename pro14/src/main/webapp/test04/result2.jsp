<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<c:if test ="${empty param.userID }">
		아이디를 입력하세요.<br>
		<a href = "login.jsp">로그인창</a>
	</c:if>
	
	<c:if test ="${not empty param.userID}">
		<c:if test = "${param.userID == 'admin' }">
		<h1>관리자로 로그인 하셨습니다.</h1>
		<form >
			<input type = "button" value = "회원 정보 삭제하기">
			<input type = "button" value = "회원 정보 수정하기">
		</form>
		</c:if>
		<c:if test = "${param.userID != 'admin' }">
		<h1>환영합니다. <c:out value="${param.userID}" />님!!</h1>
		</c:if>
	</c:if>
</body>
</html>