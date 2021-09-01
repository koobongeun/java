<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	request.setAttribute("id", "koo");
	request.setAttribute("pwd", "1212");
	session.setAttribute("name", "구본근");
	application.setAttribute("email", "gbg7524@naver.com");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward1</title>
</head>
<body>
	<jsp:forward page = "member1.jsp"/>
</body>
</html>