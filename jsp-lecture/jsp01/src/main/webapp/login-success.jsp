<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String userName = (String)session.getAttribute("userName");
	%>
	<h1><%= userName %>님 안녕하세요.</h1>
</body>
</html>