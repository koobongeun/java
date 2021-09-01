<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored = "false" %>
<%
	request.setCharacterEncoding("utf-8");
	request.setAttribute("id", "koo");
	request.setAttribute("pwd", "1212");
	session.setAttribute("name", "구본근");
	application.setAttribute("email", "gbg7524@naver.com");
	//request.setAttribute("address", "포항시 북구");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward1</title>
</head>
<body>
	<jsp:forward page = "member4.jsp"/>
</body>
</html>