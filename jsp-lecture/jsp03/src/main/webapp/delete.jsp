<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userID = request.getParameter("id");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="delete-check.jsp" method="post">
		<table>
			<tbody>
				<tr>
					<th>아이디</th>
					<!-- <td><input type="text" name="userID" value="<%= userID %>" readonly></td>-->
					<td><%= userID %></td>
					<input type="hidden" name="userID" value="<%= userID %>" readonly>
				</tr>
				<tr>
					<th>password</th>
					<td><input type="password" name="userPW"></td>
				</tr>
			</tbody>
		</table>
		<button>확인</button>
	</form>
</body>
</html>








