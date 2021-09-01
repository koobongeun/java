<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" isELIgnored = "false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>여러 가지 논리 연산자</h2>
	<h2>
		\${(10==10) && (20 == 20)} : ${(10==10) && (20 == 20)}<br>
		\${(10==10) and (20 != 20)} : ${(10==10) and (20 != 20)}<br>
		\${(10==10) || (20 != 30)} : ${(10==10) || (20 != 30)}<br>
		\${(10==10) or (20 != 20)} : ${(10==10) or (20 != 20)}<br>
		
		\${!(20==10)} : ${!(20==10)}<br>
		\${not(20==10)} : ${not(20==10)}<br>
	</h2>
</body>
</html>