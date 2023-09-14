<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<form action="join-process.jsp" name="joinForm" method="post">
			<div>
				<input type="text" name="userID" required id="" />
			</div>
			<div>
				<input type="password" name="userPW" required id="" />
			</div>
			<div>
				<input type="text" name="userName" required id="" />
			</div>
			<div>
				<input type="text" name="userAddress" id="" />
			</div>
			<div>
				<input type="text" name="userZipcode" id="" />
			</div>
			<div>
				<input type="text" name="userEmail" id="" />
			</div>
			<div>
				<input type="text" name="userTel" id="" />
			</div>
			<div>
				<input type="date" name="userBirth" id="" />
			</div>
			<div>
				개인정보 동의합니다. <input type="checkbox" name="agree" required value="yes">
			</div>
			<button>join</button>
		</form>
	</div>
	<script>
		if(document.joinForm.userID.value==="") {
			alert("아이디 넣어주세요.");
		}
	
	</script>
</body>
</html>