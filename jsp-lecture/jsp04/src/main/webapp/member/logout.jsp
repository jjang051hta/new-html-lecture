<%@page import="util.CookieManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	
	//session.removeAttribute("loggedName");
	CookieManager.deleteCookie(response, "visitedCookie");
	session.invalidate();
	response.sendRedirect("../index/index.jsp");

%>