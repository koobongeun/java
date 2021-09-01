<%@ page language="java" contentType="text/html; charset=UTF-8" import = "sec01.ex01.*"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	MemberBean member = new MemberBean("koo", "1234", "구본근", "gbg7524@naver.com");
	request.setAttribute("member", member);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward1</title>
</head>
<body>
	<jsp:forward page = "member2.jsp"/>
</body>
</html>