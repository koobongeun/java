<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>출력할 구구단의 수를 지정해 주세요.</h1>
	<form method = "post" action = "guguResult2.jsp">
		출력할 구구단 : <input type = "text" name = "dan" /><br>
					<input type = "submit" value = "구구단 출력" />
	</form>
</body>
</html>