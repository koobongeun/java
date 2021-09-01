<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		String msg = request.getParameter("msg");
		if(msg != null){
			%>
		}
		<h1> <%=msg %></h1>
	<%
	}
	%>
	<form action = "result2.jsp" method = "post">
		아이디 : <input type="text" name = "user_id">
		비밀번호 : <input type = "password" name = "user_pwd">
		<input type = "submit" value = "제출하기">
		<input type = "reset" value = "취소하기">
	</form>
</body>
</html>