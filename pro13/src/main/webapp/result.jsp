<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ㅎㅇㅎㅇ</title>
</head>
<body>
	<%
		String userID = request.getParameter("user_id");
		if(userID.length() == 0){
	%>
	<jsp : forward page = "login.jsp";>
	<%
		}
	%>
	<h1> 환영합니다. <%=userID %>님!!</h1>
</body>
</html>