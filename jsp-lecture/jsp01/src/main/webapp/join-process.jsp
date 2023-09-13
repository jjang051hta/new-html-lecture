<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	response.setContentType("text/html;charset=utf-8");
	String userID = request.getParameter("userID");
	String userPW = request.getParameter("userPW");
	String userName = request.getParameter("userName");
	String userAddress = request.getParameter("userAddress");
	String userZipcode = request.getParameter("userZipcode");
	String userEmail = request.getParameter("userEmail");
	String userTel = request.getParameter("userTel");
	String userBirth = request.getParameter("userBirth");
	String agree = request.getParameter("agree");
	
	if(userID==null || userID=="") {
		out.println("<script>alert('회원아이디는 필수');history.back();</script>");
	}
	if(userPW==null || userPW=="") {
		out.println("<script>alert('비밀번호는 필수');history.back();</script>");
	}
	if(userName==null || userName=="") {
		out.println("<script>alert('회원이름은 필수');history.back();</script>");
	}
	if(agree==null || agree=="") {
		out.println("<script>alert('개인정보 동의해주세요.');history.back();</script>");
	}
	
	
		/*
			System.out.println(userID);
			System.out.println(userPW);
			System.out.println(userName);
			System.out.println(userAddress);
			System.out.println(userZipcode);
			System.out.println(userEmail);
			System.out.println(userTel);
			System.out.println(userBirth);
			System.out.println(agree);
		*/ 
%>