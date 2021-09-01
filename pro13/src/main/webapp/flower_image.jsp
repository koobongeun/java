<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
    	request.setCharacterEncoding("utf-8");
    	String name = request.getParameter("name");
    	String imgName = request.getParameter("imgName");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>꽃 이미지</title>
</head>
<body>
	<br><br>
	<h1>이름은 <%=name %>입니다.</h1><br><br>
	<img src = "./image/<%= imgName %>" />
</body>
</html>