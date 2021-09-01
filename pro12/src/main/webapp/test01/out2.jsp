<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
    	request.setCharacterEncoding("utf-8");
    	String name = request.getParameter("name");
    	String age = request.getParameter("age");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if(name!=null || name.length()!=0){
	%>
		<h1><%=name %>, <%=age %></h1>
	<%
		}else{
	%>
		<h1>이름을 입력하세요</h1>
	<%
		}
	%>
		<%
		if(name!=null || name.length()!=0){
	%>
		<h1><% out.println(name+ "," +age); %></h1>
	<%
		}else{
	%>
		<h1>이름을 입력하세요</h1>
	<%
		}
	%>
</body>
</html>