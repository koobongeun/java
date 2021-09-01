<%@ page language="java" contentType="text/html; charset=UTF-8" import = "java.util.*, sec01.ex01.*"
    pageEncoding="UTF-8" isELIgnored = "false"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id = "m1" class = "sec01.ex01.MemberBean"/>
<jsp:setProperty name = "m1" property="*" />
<jsp:useBean id = "membersList" class ="java.util.ArrayList"/>
<jsp:useBean id = "membersMap" class= "java.util.HashMap"/>
<%
	membersMap.put("id", "park2");
	membersMap.put("pwd", "4231");
	membersMap.put("name", "바그지성");
	membersMap.put("email", "park2@naver.com");

	MemberBean m2 = new MemberBean("sin", "1212", "신구본근", "sin@naver.com");
	membersList.add(m1);
	membersList.add(m2);
	membersMap.put("membersList", membersList);
%>
<c:set var = "membersList" value = "${membersMap.membersList}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원 정보 출력창</title>
</head>
<body>
	<table border = "1" align = "center">
		<tr align = "center" bgcolor ="#99ccff">
			<td width = "20%"><b>아이디</b></td>
			<td width = "20%"><b>비밀번호</b></td>
			<td width = "20%"><b>이름</b></td>
			<td width = "20%"><b>이메일</b></td>
		</tr>
		<tr align = center>
			<td>${membersMap.id}</td>
			<td>${membersMap.pwd}</td>
			<td>${membersMap.name}</td>
			<td>${membersMap.email}</td>
		</tr>
		<tr align = center>
			<td>${membersList[0].id}</td>
			<td>${membersList[0].pwd}</td>
			<td>${membersList[0].name}</td>
			<td>${membersList[0].email}</td>
		</tr>
		<tr align = center>
			<td>${membersList[1].id}</td>
			<td>${membersList[1].pwd}</td>
			<td>${membersList[1].name}</td>
			<td>${membersList[1].email}</td>
		</tr>
	</table>
</body>
</html>