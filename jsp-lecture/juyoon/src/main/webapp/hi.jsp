<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hi ${me.name} 나는 forward된 jsp</h1>
	<h1>Hi ${me.nickName} 나는 forward된 jsp</h1>
	<h1>Hi ${me.age} 나는 forward된 jsp</h1>
	<h1>Hi ${me.gender} 나는 forward된 jsp</h1>

	<ul>
		<c:forEach items="${personList}" var="i" begin="0" end="5" varStatus="loop"> <!-- 이 태그를 쓰기 위해 maven respository에 접속해서 jstl을 다운 받기 다운 받은 jar파일을 lib폴더에 넣기 -->
			<li>
				<div>${loop.count}</div> <!-- loop.end-loop.index 역순 으로 번호 매기기-->
				<div>name : ${i.name}</div>
				<div>nickname : ${i.nickName}</div>
				<div>age : ${i.age}</div>
				<div>gender : ${i.gender}</div>
			</li>
		</c:forEach>
	</ul>
	<ul>
		<c:forEach begin="1" end="100" step="1" var="i"> 
			<c:if test="${i%2 !=0 }">  <%-- ${i mod 2 ne 0} --%>
				<li>${i}</li>
			</c:if>
		</c:forEach>
	</ul>
	
	<c:set var = "name" value="이주윤"></c:set>
	<c:choose>
		<c:when test="${name eq '이주윤'}">
			<p>이주윤이 맞습니다.</p>
		</c:when>
		<c:otherwise>
			<p>이주윤이 아닙니다.</p>
		</c:otherwise>
	</c:choose>
</body>
</html>