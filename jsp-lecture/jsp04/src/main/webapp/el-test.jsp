<%@page import="java.net.URLEncoder"%>
<%@page import="util.CookieManager"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	&lt;p&gt;태그는 란락을 나타내는 태그이다.
	<p>\${20+10 } : ${20+10 }</p>
	<p>\${20-10 } : ${20-10 }</p>
	<p>\${20*10 } : ${20*10 }</p>
	<p>\${20/10 } : ${20/10 }</p>
	<p>\${20>10 } : ${20>10 }</p>
	<p>\${20 gt 10 } : ${20 gt 10 }</p>
	<p>\${20<10 } : ${20<10 }</p>
	<p>\${20 lt 10 } : ${20 lt 10 }</p>
	<p>\${20==10 } : ${20 == 10 }</p>
	<p>\${20 eq 10 } : ${20 eq 10 }</p>
	<p>\${"jjang051" eq "jjang051" } : ${"jjang051" eq "jjang051" }</p>
	<p>\${"jjang051" == "jjang051" } : ${"jjang051" == "jjang051" }</p>
	<p>\${10!=10 } : ${10 != 10 }</p>
	<p>\${10 ne 10 } : ${10 ne 10 }</p>
	<p>\${"jjang051" ne "jjang051" } : ${"jjang051" ne "jjang051" }</p>
	<p>\${"jjang051" != "jjang051" } : ${"jjang051" != "jjang051" }</p>
	<p>\${20>10 && 20<10  } : ${20 > 10 && 20<10 }</p>
	<p>\${20>10 and 20<10  } : ${20 > 10 and 20<10 }</p>
	<p>\${20>10 || 20<10  } : ${20 > 10 || 20<10 }</p>
	<p>\${20>10 or 20<10  } : ${20 > 10 or 20<10 }</p>
	<p>\${not true} : ${not true }</p>
	<p>\${null + 10} : ${null + 10 }</p>
	<p>\${"10" + 10} : ${"10" + 10 }</p>
	<%-- <p>\${"ten" + 10} : ${"ten" + 10 }</p> --%>
	<%
		String emptyString = "";
		String emptyNull = null;
		String emptyArray[] = new String[0];
		List<String> emptyList = new ArrayList<>();
		Map<String, String> map = new HashMap<>();
		pageContext.setAttribute("name", "pageContext 장성호");
		request.setAttribute("name", "request 장성호");
		session.setAttribute("name", "session 장성호");
		application.setAttribute("name", "application 장성호");
		CookieManager.createCookie(response, "ELCookie", "장성호", 60*60);
	%>
	<p>${empty emptyString }</p>
	<p>${empty emptyNull }</p>
	<p>${empty emptyArray }</p>
	<p>${empty emptyList }</p>
	<p>${empty map }</p>
	<p>${pageScope.name }</p>
	<p>${requestScope.name }</p>
	<p>${sessionScope.name }</p>
	<p>${applicationScope.name }</p>
	<p>${name }</p>
	<p>${header["user-agent"] }</p>
	<p>${param.age}</p>
	<p>${cookie.ELCookie.value }</p>
	
	
	
</body>
</html>







