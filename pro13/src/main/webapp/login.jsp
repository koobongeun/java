<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>로그인 창</title>
</head>
<body>
	<h1>아이디를 입력하지 않았습니다. 아이디를 입력해 주세요.</h1>
	<form action = "result.jsp" method = "post">
		아이디 : <input type="text" name = "user_id">
		비밀번호 : <input type = "password" name = "user_pwd">
		<input type = "submit" value = "제출하기">
		<input type = "reset" value = "취소하기">
	</form>
</body>
</html>