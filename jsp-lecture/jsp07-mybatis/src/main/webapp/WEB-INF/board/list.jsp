<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../board/search">
		<input type="text" name="keyword">
		<select name="category">
			<option value="name">글쓴이</option>
			<option value="title">제목</option>
			<option value="content">내용</option>
			<option value="all">전체</option>
		</select>
		<button>검색</button>
	</form>
</body>
</html>