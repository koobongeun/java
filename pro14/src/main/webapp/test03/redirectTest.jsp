<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored = "false" import = "java.util.*"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>c:redirect 태그 실습</title>
</head>
<body>
	<c:redirect url ="/test01/member1.jsp">
	<c:param name= "id" value="koo"/>
	<c:param name= "pwd" value="1213"/>
	<c:param name= "name" value="구본근"/>
	<c:param name= "email" value="koo@naver.com"/>
	</c:redirect>
</body>
</html>