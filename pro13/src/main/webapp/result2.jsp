<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
    	request.setCharacterEncoding("utf-8");
    %>
    <%!
    	String msg = "���̵� �Է����� �ʾҽ��ϴ�. ���̵� �Է��� �ּ���.";	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String userID = request.getParameter("user_id");
	if(userID.length()==0){
%>	
	<jsp:forward page = "login2.jsp">
	<jsp:param name = "msg" value="<%=msg %>"/>
	</jsp:forward>
<%
	}
%>
<h1>ȯ���մϴ�. <%=userID %>��!!</h1>
</body>
</html>