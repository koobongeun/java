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
		���̵� : <input type="text" name = "user_id">
		��й�ȣ : <input type = "password" name = "user_pwd">
		<input type = "submit" value = "�����ϱ�">
		<input type = "reset" value = "����ϱ�">
	</form>
</body>
</html>