<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" 
    errorPage = "addException.jsp"%>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	int sum = 0;
	for(int i =1; i<=num; i++){
		sum = sum + i;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�հ� ���ϱ�</title>
</head>
<body>
	<h2>�հ� ���ϱ�</h2>
	<h1>1���� <%=num %>������ ����<%=sum %>�Դϴ�.</h1>
</body>
</html>