<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��������</title>
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
	<h1> ȯ���մϴ�. <%=userID %>��!!</h1>
</body>
</html>