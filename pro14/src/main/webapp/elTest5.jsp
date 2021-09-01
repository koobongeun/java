<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" isELIgnored = "false" %>
    <jsp:useBean id = "m1" class = "sec01.ex01.MemberBean" scope ="page"/>
    <jsp:setProperty name = "m1" property = "name" value = "이순신"/>
    <jsp:useBean id = "m2" class = "java.util.ArrayList" scope ="page"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>표현 언어의 여러 가지 연산자들</title>
</head>
<body>
	empty 연산자
	<h2>
		\${empty m1} : ${empty m1}<br>
		\${not empty m1} : ${not empty m1}<br><br>
		\${empty m2} : ${empty m2}<br>
		\${not empty m2} : ${not empty m2}<br><br>
		\${empty "hello"} : ${empty "hello"}<br>
		\${empty null} : ${empty null}<br>
		\${empty ""} : ${empty ""}<br>
	</h2>
</body>
</html>