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
		String name = "장성호";
		int age = 15;
	%>
	<h1>hello jsp</h1>
	<h2>나의 이름은 <% out.println(name); %>입니다.</h2>
	<h2>나이는 <% out.println(age); %>입니다.</h2>
	<a href="hi.jsp?name=장동건&age=30">hi</a>
</body>
</html>