<%@page import="util.CookieManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
	String userID = request.getParameter("userID");
	String userPW = request.getParameter("userPW");
	String saveID = request.getParameter("saveID");
	//System.out.println(saveID);
	if(userID.equals("jjang051") && userPW.equals("1234")) {
		if(saveID!=null && saveID.equals("yes")) {
			// 여기다가 쿠키 설정
			Cookie cookie = new Cookie("loginID",userID);
			cookie.setPath("/");
			cookie.setMaxAge(60*60*24*365);
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("loginID",userID);
			cookie.setPath("/");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		out.println("<script>alert('로그인 성공'); location.href='login-main.jsp';</script>");
	} else {
		out.println("<script>alert('로그인 실패'); history.back();</script>");
	}
	*/
	String userID = request.getParameter("userID");
	String userPW = request.getParameter("userPW");
	String saveID = request.getParameter("saveID");
	if(userID.equals("jjang051") && userPW.equals("1234")) {
		if(saveID!=null && saveID.equals("yes")) {
			CookieManager.createCookie(response, "loginID", userID, 60*60*24*365);
		} else {
			CookieManager.deleteCookie(response, "loginID");
		}
		out.println("<script>alert('로그인 성공'); location.href='login-main.jsp';</script>");
	} else {
		out.println("<script>alert('로그인 실패'); history.back();</script>");
	}
%>


