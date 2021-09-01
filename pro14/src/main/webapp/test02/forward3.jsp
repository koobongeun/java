<%@ page language="java" contentType="text/html; charset=UTF-8" import = "java.util.*, sec01.ex01.*"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	List membersList = new ArrayList();
	MemberBean m1 = new MemberBean("koo", "1234", "구본근", "gbg7524@naver.com");
	MemberBean m2 = new MemberBean("jo", "1234", "조해지", "gbg7524@naver.com");
	membersList.add(m1);
	membersList.add(m2);
	request.setAttribute("membersList", membersList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward1</title>
</head>
<body>
	<jsp:forward page = "member3.jsp"/>
</body>
</html>