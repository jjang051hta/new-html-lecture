<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login-process.jsp" method="post">
		<input type="text" name="userID">
		<input type="password" name="userPW">
		<input type="hidden" name="userName" value="장성호">
		<button>로그인</button>
	</form>
</body>
</html>