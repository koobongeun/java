<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored = "false" import = "java.util.*, sec01.ex01.*"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
	List membersList = new ArrayList();
	MemberBean m1 = new MemberBean("koo", "1234", "구본근", "gbg7524@naver.com");
	MemberBean m2 = new MemberBean("koo1", "1234", "구본근1", "gbg7525@naver.com");
	MemberBean m3 = new MemberBean("koo2", "1234", "구본근2", "gbg7526@naver.com");
	membersList.add(m1);
	membersList.add(m2);
	membersList.add(m3);
%>
<c:set var = "membersList" value ="<%=membersList%>" />
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원 정보 출력창</title>
</head>
<body>
<table align = "center" border = 1>
		<tr align = "center" bgcolor = "lightgreen">
			<td width = "7%"><b>아이디</b></td>
			<td width = "7%"><b>비밀번호</b></td>
			<td width = "5%"><b>이름</b></td>
			<td width = "5%"><b>이메일</b></td>
		</tr>
		<c:forEach var = "member" items="${membersList}">
		<tr align = "center">
		<td>${member.id}</td>
		<td>${member.pwd}</td>
		<td>${member.name}</td>
		<td>${member.email}</td>
		</tr>
		</c:forEach>
</table>
</body>
</html>