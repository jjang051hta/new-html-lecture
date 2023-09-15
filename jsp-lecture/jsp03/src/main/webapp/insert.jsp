<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="insert-process.jsp" method="post">
		<div>
			<label>
				<span>아이디</span>
				<input type="text" name="userID">
			</label>
		</div>
		<div>
			<label>
				<span>패스워드</span>
				<input type="password" name="userPW">
			</label>
		</div>
		<div>
			<label>
				<span>age</span>
				<input type="text" name="userAge">
			</label>
		</div>
		<div>
			<label>출생년도</label>
			<!-- 1900~2023 -->
			<select name="birthYear">
				<% for( int i=1900;i<=2023;i++) { %>
					<option value="<%= i %>"><%= i %></option>
				<%} %>
			</select>
		</div>
		<button>회원가입</button>
	</form>
</body>
</html>






