<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>include.jsp</title>
</head>
<body>
	안녕하세요. 쇼핑몰 중심 JSP 시작입니다!!
	<br>
	<jsp:include page="flower_image.jsp" flush ="ture">
		<jsp:param value="꽃" name="name"/>
		<jsp:param value="flower.jpg" name="imgName"/>
	</jsp:include>
	<br>
	끝 부분입니다.
</body>
</html>