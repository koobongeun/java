<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" isELIgnored = "false" %>
    <jsp:useBean id = "m1" class = "sec01.ex01.MemberBean" scope ="page"/>
    <jsp:setProperty name = "m1" property = "name" value = "�̼���"/>
    <jsp:useBean id = "m2" class = "java.util.ArrayList" scope ="page"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ǥ�� ����� ���� ���� �����ڵ�</title>
</head>
<body>
	empty ������
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