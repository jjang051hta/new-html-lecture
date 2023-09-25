<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> Hi ${me.name}</h1>
	<h1> ${me.nickName}</h1>
	<h1> ${me.age}</h1>
	<h1> ${me.gender}</h1>
	<ul>
		<c:forEach items="${personList }" var="item" begin="0" end="5" varStatus="loop">
			<li>
				<div>${loop.end - loop.index }</div>
				<div>name : ${item.name }</div>
				<div>nickname : ${item.nickName }</div>
				<div>age : ${item.age }</div>
				<div>gender : ${item.gender }</div>
			</li>
		</c:forEach>
		
		
	</ul>
	<ul>
		<c:forEach begin="1" end="100" step="1" var="item">
			<%-- <c:if test="${item%2!=0 }"> --%>
			<c:if test="${item mod 2 ne 0 }">
				<li>${ item}</li>
			</c:if>
		</c:forEach>
	</ul>
	<c:set var="name" value="장동건"></c:set>
	<c:choose>
		<c:when test="${'장성호' eq name  }">
			<p>장성호가 맞습니다.</p>
		</c:when>
		<c:when test="${'장동건' eq name  }">
			<p>장동건이 맞습니다.</p>
		</c:when>
		<c:otherwise>
			<p>장성호가 아닙니다.</p>
		</c:otherwise>	
	</c:choose>
</body>
</html>


