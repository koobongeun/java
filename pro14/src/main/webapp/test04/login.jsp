<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "result2.jsp" method= "post">
		아이디 : <input type = "text" name = "userID">
		비밀번호 : <input type = "password" name = "userPw">
		<input type = "submit" value="로그인">
		<input type = "reset" value="다시하기">
	</form>
</body>
</html>