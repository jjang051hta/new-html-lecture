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
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
	%>
	<h1>Hi jsp</h1>
	<h2>나의 이름은 <%= name %>이고 나이는 <%= age %></h2>
	<a href="hello.jsp">hello</a>
</body>
</html>