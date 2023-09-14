<%@ page import="common.Person"%>
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
	
		Person person = new Person("장동건",30);
		String name = "장성호";
		int age= 20;
		//pageContext < request < session < application
		pageContext.setAttribute("name", "나는 pageContext입니다.");
		request.setAttribute("name", "나는 request입니다.");
		session.setAttribute("name", "나는 session입니다.");
		application.setAttribute("name", "나는 application입니다.");
		
		out.println("scope=====");
		String pageContextName = (String)pageContext.getAttribute("name");
		String requestName = (String)request.getAttribute("name");
		String sessionName = (String)session.getAttribute("name");
		String applicationName = (String)application.getAttribute("name");
		
		out.println(pageContextName);
		out.println("<hr>");
		out.println(requestName);
		out.println("<hr>");
		out.println(sessionName);
		out.println("<hr>");
		out.println(applicationName);
		
		// forward를 이용해서 model2 사용가능
		
		request.getRequestDispatcher("second.jsp").forward(request, response);
		//response.sendRedirect("third.jsp");
				
	%>
	<a href="second.jsp">second</a> <br>
	<a href="third.jsp">third</a>
	
</body>
</html>



















