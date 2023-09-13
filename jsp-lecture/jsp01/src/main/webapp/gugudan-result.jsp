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
		int dan = Integer.parseInt(request.getParameter("dan"));
	%>
	<ul>
		<%  
			for(int i=1;i<9;i++){
				out.println("<li>"+dan+"x"+ i+" = "+dan*i+"</li>");		
			}
		%>
	</ul>
	<ul>
		<% for(int i=1;i<9;i++){ %>
				<li><%= dan %> x <%= i %> = <%= dan*i %></li>		
		<% } %>
	</ul>
</body>
</html>




